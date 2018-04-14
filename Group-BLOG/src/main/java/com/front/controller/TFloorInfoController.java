package com.front.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.common.utils.R;
import com.front.entity.TFloorInfoEntity;
import com.front.service.TFloorInfoService;
import com.sys.entity.TUserEntity;






/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:43
 */
@RestController
@RequestMapping("tfloorinfo")
public class TFloorInfoController {
	@Autowired
	private TFloorInfoService tFloorInfoService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public R saveFloorInfo(TFloorInfoEntity floorInfo){
		try {
			TUserEntity user=(TUserEntity) SecurityUtils.getSubject().getSession().getAttribute("CurrentUser");
			    floorInfo.setUserName(user.getUserName());
			    floorInfo.setImgUrl(user.getUserHeadimg());
			    tFloorInfoService.save(floorInfo);
			    return R.ok();
		} catch (Exception e) {
			return R.fail();
		}
	}
	
}
