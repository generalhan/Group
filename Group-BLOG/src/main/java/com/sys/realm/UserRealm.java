package com.sys.realm;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.global.annotions.Constants;
import com.sys.entity.TRoleEntity;
import com.sys.entity.TUserEntity;
import com.sys.service.TRoleService;
import com.sys.service.TUserService;




/**
 * 用户realm
 * @author zwl
 *
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private TRoleService tRoleService;
	
	@Resource
	private TUserService tUserService;

	
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName=(String)principals.getPrimaryPrincipal();
         SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
          Set<TRoleEntity> set=tRoleService.findRoles(userName);
           Set<String> roles=new HashSet<String>();
            Iterator<TRoleEntity> it=set.iterator();
              while(it.hasNext()){
        	     TRoleEntity t=it.next();
        	     System.out.println(t.getRoleName());
        	       roles.add(t.getRoleName());
              }    
              authorizationInfo.setRoles(roles);
              System.out.println( authorizationInfo.getRoles().size());
           authorizationInfo.setStringPermissions(new HashSet<String>());
         return authorizationInfo;
    }

    /**
     * 对前登陆的用户进行身份认证
     */
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	String userName=(String)token.getPrincipal(); // 根据刚刚传过来的获取用户名
    	TUserEntity user=(TUserEntity) tUserService.getTUserEntity(userNameMap(userName));
    	    if(user==null){
         	  throw new UnknownAccountException();//没找到帐号 
           }

           //若存在，将此用户存放到登录认证info中    
	       return new SimpleAuthenticationInfo(user.getUserName(),user.getUserPwd(), ByteSource.Util.bytes(Constants.SALT), getName());
	       
    }

	private Map<String, Object> userNameMap(String userName) {
		Map<String, Object> map=new HashMap<String, Object>();
    	     map.put("userName", userName);
		return map;
	}

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
