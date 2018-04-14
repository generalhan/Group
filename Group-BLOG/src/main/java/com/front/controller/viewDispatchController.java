package com.front.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.characterFactory.CharacterTempleFactory;
import com.common.global.annotions.Constants;
import com.common.utils.CharacterUtil;



@Controller
@RequestMapping("/view")
public class viewDispatchController {

	private String desCipherStr;
	
	@Resource
	private CharacterTempleFactory characterTempleFactory;
	
	/**
	 * ��̬ҳ�������ת
	 * @param branch
	 * @param viewTarget
	 * @return
	 */
	@RequestMapping("dispatch/{branch}/{viewTarget}")
	public ModelAndView dispatchHandleMappingUrl(@PathVariable String branch,@PathVariable String viewTarget){
		
		desCipherStr=deQueueForView(viewTarget);
		    ModelAndView mv=new ModelAndView();
		         mv.setViewName(branch+"/"+desCipherStr);
	        return mv;
	}
	
	/**
	 * ���ݰ�ҳ���ض���
	 * @param parentPath
	 * @param TargetPath
	 * @param request
	 * @return
	 */
	@RequestMapping("redirect/{parentPath}/{TargetPath}")
	public String redirectHandleMappingUrl(@PathVariable String parentPath,@PathVariable String TargetPath,HttpServletRequest request){
		  desCipherStr=deQueueForView(TargetPath);
		    String root=request.getContextPath();
		return "redirect:"+Constants.REDIRECT_ROOT_PATH+root+"/"+parentPath+"/"+desCipherStr;
	}
	
	
	private synchronized String deQueueForView(String target){
		return characterTempleFactory.getCharacter(target);
	}
	
}
