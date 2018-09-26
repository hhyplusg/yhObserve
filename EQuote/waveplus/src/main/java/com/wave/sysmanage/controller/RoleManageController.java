package com.wave.sysmanage.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.wave.sysmanage.service.SFunctionService;
import com.wave.sysmanage.service.SRoleService;
import com.wave.sysmanage.vo.AreaRoleTreeVo;
import com.wave.sysmanage.vo.SFunctionInfoVo;
import com.wave.sysmanage.vo.SRoleFunctionVo;
import com.wave.sysmanage.vo.SRoleVo;

@Controller
@ResponseBody
public class RoleManageController extends BaseController{
	@Autowired
	SRoleService sRoleService;
	@Autowired
	SFunctionService sFunctionService;
	/**
	 * 查询角色管理的角色列表
	 * @param areaCode
	 * @param roleType
	 * @return
	 */
	@RequestMapping("/showRoleTree")
	public ClientDatatModel<List<AreaRoleTreeVo>> showRoleTree(@RequestBody SRoleVo sRole){
		ClientDatatModel<List<AreaRoleTreeVo>> clientDatatModel = new ClientDatatModel<>();
		List<AreaRoleTreeVo> list = sRoleService.getAreaRoleTree(sRole);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
        clientDatatModel.setData(list);    
        return clientDatatModel;
	}
	/**
	 * 添加新的角色
	 * @param sRole
	 * @return
	 */
	@ControllerLoggerAnnontation(description = "添加角色",isSaveToDb=true)
	@RequestMapping(value = "/addRole", method = RequestMethod.PUT)
	@RepetitionSubmitAnnotation(needRemoveToken = true)
	public ClientDatatModel<String> addRole(@RequestBody SRoleVo sRole){
		ClientDatatModel<String> clientDatatModel = new ClientDatatModel<>();
		sRoleService.addRole(sRole);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
		clientDatatModel.setMsg("添加成功"); 
        return clientDatatModel;
	}
	/**
	 * 根据角色编码查询角色信息
	 * @param roleCode
	 * @return
	 */
	@RequestMapping(value="getRoleByRoleCode/{roleCode}", method=RequestMethod.GET)
	public ClientDatatModel<SRoleVo> getRoleByRoleCode(@PathVariable("roleCode") String roleCode){
		ClientDatatModel<SRoleVo> clientDatatModel = new ClientDatatModel<>();
		SRoleVo sRoleVo = sRoleService.getRoleByRoleCode(roleCode);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
        clientDatatModel.setData(sRoleVo);    
        return clientDatatModel;
	}
	/**
	 * 根据角色名称查询角色信息
	 * @param roleCode
	 * @return
	 */
	@RequestMapping("getRoleByRoleName/{roleName}")
	public ClientDatatModel<SRoleVo> getRoleByRoleName(@PathVariable("roleName") String roleName){
		ClientDatatModel<SRoleVo> clientDatatModel = new ClientDatatModel<>();
		SRoleVo sRoleVo = sRoleService.getRoleByRoleName(roleName);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
        clientDatatModel.setData(sRoleVo);    
        return clientDatatModel;
	}
	/**
	 * 查询功能树形
	 * @return
	 */
	@RequestMapping("/showFunctionTree")
	public ClientDatatModel<List<SFunctionInfoVo>> showFunctionTree(){
		ClientDatatModel<List<SFunctionInfoVo>> clientDatatModel = new ClientDatatModel<>();
		List<SFunctionInfoVo> list = sFunctionService.getFunctionTree();
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
        clientDatatModel.setData(list);    
        return clientDatatModel;
	}
	/**
	 * 为角色添加功能
	 * @param function_check
	 * @return
	 */
	@ControllerLoggerAnnontation(description = "为角色添加功能",isSaveToDb=true)
	@RequestMapping("/addRoleFunction/{roleCode}")
	@RepetitionSubmitAnnotation(needRemoveToken = true)
	public ClientDatatModel<String> addRoleFunction(@PathVariable("roleCode") String roleCode, @RequestParam("function_check") List<String> function_check){
		ClientDatatModel<String> clientDatatModel = new ClientDatatModel<>();
		if(function_check == null){
			function_check = new ArrayList<String>();
		}
		sRoleService.addRoleFunctions(roleCode,function_check);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
        return clientDatatModel;
	}
	/**
	 * 根据角色id查询角色的功能权限
	 * @param roleCode
	 * @return
	 */
	@RequestMapping("/showFunctionByRoleId/{roleCode}")
	public ClientDatatModel<List<SRoleFunctionVo>> showFunctionByRoleId(@PathVariable("roleCode") String roleCode){
		ClientDatatModel<List<SRoleFunctionVo>> clientDatatModel = new ClientDatatModel<>();
		List<SRoleFunctionVo> list = sRoleService.getFunctionByRoleId(roleCode);
		clientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
        clientDatatModel.setData(list);
        return clientDatatModel;
	}
}
