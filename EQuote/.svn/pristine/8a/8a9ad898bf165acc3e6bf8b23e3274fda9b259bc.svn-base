package com.wave.sysmanage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wave.base.action.BaseController;
import com.wave.base.action.ClientDatatModel;
import com.wave.common.cnstants.Constants;
import com.wave.core.annotation.ControllerLoggerAnnontation;
import com.wave.core.annotation.RepetitionSubmitAnnotation;
import com.wave.sysmanage.service.SUserService;
import com.wave.sysmanage.vo.SUserInfoVo;
import com.wave.sysmanage.vo.SelectUserConditionVo;

@Controller
@ResponseBody
public class UserManageController extends BaseController {
	
	@Autowired
	SUserService sUserService;
	 
	/**
	 * 查询用户和角色的信息
	 * @return
	 */
	@RequestMapping("/showUserList")
	public ClientDatatModel<List<SUserInfoVo>> showUserList(SelectUserConditionVo selectUserCondition){
		ClientDatatModel<List<SUserInfoVo>> clientDatatModel = new ClientDatatModel<List<SUserInfoVo>>();
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
		clientDatatModel.setMsg("");
		List<SUserInfoVo> list = sUserService.getUserByCondition(selectUserCondition);
		clientDatatModel.setData(list );
		return clientDatatModel;
	}
	 
	/**
	 * 根据用户id查询用户信息
	 * @return
	 */
	@RequestMapping("/getUserInfoByUserId/{userId}")
	public ClientDatatModel<SUserInfoVo> getUserInfoByUserId(@PathVariable("userId") String userId){
		ClientDatatModel<SUserInfoVo> clientDatatModel = new ClientDatatModel<SUserInfoVo>();
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
		clientDatatModel.setMsg("");
		SUserInfoVo user = sUserService.getUserInfoByUserId(userId);
		clientDatatModel.setData(user);
		return clientDatatModel;
	}
	/**
	 * 添加或更新用户信息
	 * @return
	 */
	@ControllerLoggerAnnontation(description = "添加或更新用户信息",isSaveToDb=true)
	@RequestMapping(value = "/addUserAndRole", method = RequestMethod.PUT)
	@RepetitionSubmitAnnotation(needRemoveToken = true)
	public ClientDatatModel<Integer> addOrUpdateUserAndRole(@RequestBody SUserInfoVo sUserInfo,HttpServletRequest request){
		ClientDatatModel<Integer> clientDatatModel = new ClientDatatModel<Integer>();
		sUserService.addUserAndRole(sUserInfo);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
		clientDatatModel.setMsg("");
		return clientDatatModel;
	}
	/**
	 * 添加或更新用户信息
	 * @return
	 */
	@RequestMapping(value = "/checkUserPass", method = RequestMethod.GET)
	public ClientDatatModel<Integer> checkUserPass(@RequestParam("userId") String userId,@RequestParam("password") String password,HttpServletRequest request){
		ClientDatatModel<Integer> clientDatatModel = new ClientDatatModel<Integer>();
		SUserInfoVo sUserInfo = new SUserInfoVo();
		sUserInfo.setUserId(userId);
		sUserInfo.setPassword(password);
		int i = sUserService.checkUserPass(sUserInfo);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
		clientDatatModel.setMsg("");
		clientDatatModel.setData(i);
		return clientDatatModel;
	}
	/**
	 * 更新密码
	 * @return
	 */
	@ControllerLoggerAnnontation(description = "修改密码",isSaveToDb=true)
	@RequestMapping(value = "/updatePass", method = RequestMethod.PUT)
	@RepetitionSubmitAnnotation(needRemoveToken = true)
	public ClientDatatModel<Integer> updatePass(@RequestBody SUserInfoVo sUserInfo,HttpServletRequest request){
		ClientDatatModel<Integer> clientDatatModel = new ClientDatatModel<Integer>();
		sUserService.updatePass(sUserInfo);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
		clientDatatModel.setMsg("");
		return clientDatatModel;
	}
	/**
	 * 查询区划下用户是否存在
	 * @return
	 */
	@RequestMapping(value = "/checkUserLoginName", method = RequestMethod.PUT)
	public ClientDatatModel<Integer> checkUserLoginName(@RequestBody SUserInfoVo sUserInfo,HttpServletRequest request){
		ClientDatatModel<Integer> clientDatatModel = new ClientDatatModel<Integer>();
		int i = sUserService.checkUserLoginName(sUserInfo);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
		clientDatatModel.setMsg("");
		clientDatatModel.setData(i);
		return clientDatatModel;
	}
}
