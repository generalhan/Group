package com.sys.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.datamodel.TBean;
import com.common.global.annotions.Constants;
import com.common.json.strategy.HttpObjectModel;
import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.common.utils.DesUtils;
import com.common.utils.MapParamsUtil;
import com.common.utils.R;
import com.common.utils.RandUtil;
import com.sys.entity.BaseEntity;
import com.sys.entity.TEmailCodeEntity;
import com.sys.service.SysBaseService;
import com.sys.service.TEmailCodeService;
import com.sys.service.TUserService;




@Controller
@RequestMapping("tuser")
public class TUserController<TUserEntity> {

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	
	@Resource
	private TUserService tUserService;
	
	@Resource
	private TEmailCodeService tEmailCodeService;
	
	/**
	 * 加载所有用户信息
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/showUserView/{currentPage}")
	public ModelAndView showUserView(@PathVariable  int currentPage){
		try {         
	           Pagemodal pg=tUserService.getListbyPage(new Page(currentPage,Constants.EVERY_PAGE),new HashMap<String, Object>());
	               return new pageListUtil().pageModelList(tUserService.getCount(),new ModelAndView("sys/SysAdmin"),pg,pg.getPage());
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public R login(String userName,String userPwd,HttpServletRequest request){
		 try {				
			 synchronized (this) {
			   /**生成令牌**/
				UsernamePasswordToken token=new UsernamePasswordToken(userName, userPwd);
				/**获得主体**/
				 org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
	        	token.setRememberMe(true);
	              subject.login(token);
	                /**得到用户信息**/
	  	        com.sys.entity.TUserEntity user=(com.sys.entity.TUserEntity) tUserService.getTUserEntity(new MapParamsUtil(userNameobj(userName)).setKeyandValues());
	  	              /**密码置空**/
	  	           user.setUserPwd("");   
	  	                    /**保存用户会话信息**/
	                   subject.getSession().setAttribute("CurrentUser", user);
	                      new HttpObjectModel().getRequest().getSession().setAttribute("currentUser", user);                 
	                      request.setAttribute("flag", 1);
	  		        return R.ok().put("msg", "登录成功");
			 }
	        } catch (IncorrectCredentialsException ice) {	        	
	            // 捕获密码错误异常
	        	return R.fail().put("msg", "用户名或者密码不对");
	        } catch (UnknownAccountException uae) {	        	
	            // 捕获未知用户名异常
	        	return R.fail().put("msg", "用户名不存在");
	        } catch (ExcessiveAttemptsException eae) {	        	
	            // 捕获错误登录过多的异常
	        	return R.fail().put("msg", "用户名错误登录过多");
	        }
	        catch (AuthenticationException eae) {	        	
	            // 捕获错误权限异常
	        	return R.fail().put("msg", "没有权限");
	        }
	}

	/**
	 * 验证用户名是否存在
	 * @param userName
	 * @return
	 */
	@RequestMapping("/isuserNamed")
	@ResponseBody
	public R isuserNamed(String userName){
		try {
			synchronized (this) {	
			 return tUserService.getUserEntity(new MapParamsUtil(userNameobj(userName)).setKeyandValues())==true?R.ok():R.fail();
			}
		} catch (Exception e) {
			logger.info("用户注册姓名验证出现一个异常!");
			return R.fail();
		}	
	}

	/**
	 * 发送验证码
	 * @param emailAddress
	 * @return
	 */
	
	@RequestMapping("/sendmail")
	@ResponseBody
	public R regist(String emailAddress){
		try {
			synchronized (this) {
				/**判断邮箱是否已被注册**/
				if(!isEmailAddressed(emailAddress)&&isEmailAddressed(emailAddress))return R.fail().put("msg", "该邮箱已经被注册！");
			   /**判断验证码是否已发到该邮箱，是，则不重复发直接取第一次座位验证码，不是，重新发送**/
				String emailCode=isEmailCoded(emailAddress)==true?tEmailCodeService.getEmailCodeList(
					new MapParamsUtil( emailObj(emailAddress)).setKeyandValues()).get(0).getEmailCode():
						RandUtil.createActiveCode(6);
					//邮箱发送标记
					int mailFlag=0;
					if(!isEmailCoded(emailAddress)){
						/**保存emailcode信息**/
						tEmailCodeService.save(new TEmailCodeEntity(emailAddress,emailCode));
						/**第一次注册，发送验证码**/	
						mailFlag=1;
						//new SendMailToSomeone().send("激活码",emailCode ,emailAddress,MailUtil.getInstance().getfromEmail(),MailUtil.getInstance().getPassword(),MailUtil.getInstance().getmailType());
					}
					return R.ok().put("msg", emailCode).put("mailFlag", mailFlag).put("emailCode", new DesUtils().encrypt(emailCode)).put("emailAddress", new DesUtils().encrypt(emailAddress));
			}
		} catch (Exception e) {
			logger.info("用户发送验证码出现一个异常!");
			return R.fail();
		}		
	}
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public R userRegist(com.sys.entity.TUserEntity user){
		try {			
			synchronized (this) {						
				user.setUserPwd(new Md5Hash(user.getUserPwd(), Constants.SALT,Constants.HASH_iTERATIONS).toString());
			        tUserService.save(user);
			        return R.ok();
			}
		} catch (Exception e) {
			return R.fail();
		}
	}
	
	/**
	 * 重置密码
	 * @param emailCode
	 * @param userPwd
	 * @return
	 */
	@RequestMapping("/forget")
	@ResponseBody
	public R forgetPwd(TEmailCodeEntity emailCode,String userPwd){
		try {
			synchronized (this) {
				/**该用户是否存在**/
				if(!isEmailAddressed(emailCode.getEmailAddress()))return R.fail().put("msg", "该email未被注册，用户不存在,修改失败!");
				/**验证验证码是否正确**/	
				if(!tEmailCodeService.getEmailCodeEntity(new MapParamsUtil(emailEntityObj(emailCode)).setKeyandValues()))
					return R.code(2).put("msg","验证码不正确!");
				/**修改密码**/				
				tUserService.update(new MapParamsUtil(updateUserObj(emailCode, userPwd)).setKeyandValues());
				return R.ok().put("msg", "修改成功!");
			}			
		} catch (Exception e) {
			return R.code(3).put("msg", "服务器发生异常!");
		}
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView exit(){
		try {
			synchronized (this) {
			SecurityUtils.getSubject().logout();
			return new ModelAndView("portal/exit");
			}
		} catch (Exception e) {
			return new ModelAndView("other/500");
		}
	}

	
	/**验证码是否已经存在**/
	private boolean isEmailCoded(String emailAddress){	
		return tEmailCodeService.getEmailCodeEntity(new MapParamsUtil( emailObj(emailAddress)).setKeyandValues())==true?true:false;		
	}
	
	/**email是否已被注册**/
	private boolean isEmailAddressed(String emailAddress){		
		return tUserService.getUserEntity(new MapParamsUtil( emailObj(emailAddress)).setKeyandValues())==true?true:false;
	}
	
	private Object[][] updateUserObj(TEmailCodeEntity emailCode, String userPwd) {
		Object[][] obj=new Object[2][2];
		obj[0][0]="emailAddress";
		 obj[0][1]=emailCode.getEmailAddress();
		 obj[1][0]="userPwd";
		 obj[1][1]=new Md5Hash(userPwd, Constants.SALT,Constants.HASH_iTERATIONS).toString();
		return obj;
	}
	
	private Object[][] emailEntityObj(TEmailCodeEntity emailCode) {
		Object[][] obj=new Object[2][2];
		obj[0][0]="emailAddress";
		 obj[0][1]=emailCode.getEmailAddress();
		 obj[1][0]="emailCode";
		 obj[1][1]=emailCode.getEmailCode();
		return obj;
	}

	private Object[][] emailObj(String emailAddress) {
		Object[][] obj=new Object[1][2];
		    obj[0][0]="emailAddress";
		         obj[0][1]=emailAddress;
		return obj;
	}
	
	private Object[][] userNameobj(String userName) {
		Object[][] obj=new Object[1][2];
		   obj[0][0]="userName";
		   obj[0][1]=userName;
		return obj;
	}
}