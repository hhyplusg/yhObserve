package com.wave.sysmanage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wave.base.action.BaseController;
import com.wave.base.action.ClientDatatModel;
import com.wave.common.cnstants.Constants;
import com.wave.core.annotation.ControllerLoggerAnnontation;
import com.wave.core.annotation.RepetitionSubmitAnnotation;
import com.wave.sysmanage.service.SysCDictService;
import com.wave.sysmanage.vo.SysManageCDictVo;
import com.wave.user.vo.SUserVo;

@Controller
@ResponseBody
@RequestMapping(value = "sysCDictController")
public class SysCDictController extends BaseController {
	@Autowired
	@Qualifier("sysCDictServiceImpl")
	private SysCDictService sysCDictServiceImpl;
	@RequestMapping("getTreeInfo")
	public ClientDatatModel<List<SysManageCDictVo>> getTreeInfo(@RequestBody(required=false) SysManageCDictVo sysManageCDictVo) {
		ClientDatatModel<List<SysManageCDictVo>> client = new ClientDatatModel<List<SysManageCDictVo>>();
		List<SysManageCDictVo> dictList = sysCDictServiceImpl.getTreeInfo(sysManageCDictVo);
		if(dictList != null && dictList.size() > Constants.CONTROLLER_SUCCE) {
			client.setCode(Constants.CONTROLLER_SUCCE);
			client.setData(dictList);
			client.setMsg("查询完毕");
		} else {
			client.setCode(Constants.CONTROLLER_SUCCE);
			client.setData(dictList);
			client.setMsg("暂无数据");
		}
		return client;
		
	}
	
	@ControllerLoggerAnnontation(description = "添加字典",isSaveToDb=true)
	@RequestMapping(value = "saveDictChiled",method=RequestMethod.POST)
	@RepetitionSubmitAnnotation(needRemoveToken = true)
	public ClientDatatModel<String> saveDictChiled(@RequestBody SysManageCDictVo sysManageCDictVo,HttpServletRequest request) {
		ClientDatatModel<String> ClientDatatModel = new ClientDatatModel<>();
		SUserVo sUserVo = super.getSUserVo(request);
		sysManageCDictVo.setCreater(sUserVo.getUserId());
		sysManageCDictVo.setUpdater(sUserVo.getUserId());
		int intResult = sysCDictServiceImpl.saveDictChiled(sysManageCDictVo);
		
		//如果intResult是1，代表录入成功，如果是Constants.CONTROLLER_SUCCE，代表录入失败，如果是2，代表字典代码重复
		if(intResult == 1) {
			ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
			ClientDatatModel.setMsg("录入完毕");
		} else if ( intResult == Constants.CONTROLLER_SUCCE ) {
			ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
			ClientDatatModel.setMsg("录入失败");
		} else {
			ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
			ClientDatatModel.setMsg("代码重复");
		}
		return ClientDatatModel;
	}
	
	/**
	 * 修改字典信息
	 * */
	@ControllerLoggerAnnontation(description = "修改字典信息",isSaveToDb=true)
	@RequestMapping(value = "updateDictInfo",method=RequestMethod.POST)
//	@RepetitionSubmitAnnotation(needRemoveToken = true)
	public ClientDatatModel<String> updateDictInfo(@RequestBody SysManageCDictVo sysManageCDictVo,HttpServletRequest request) {
		ClientDatatModel<String> ClientDatatModel = new ClientDatatModel<>();
		SUserVo sUserVo = super.getSUserVo(request);
		sysManageCDictVo.setUpdater(sUserVo.getUserId());
		sysCDictServiceImpl.updateDictInfo(sysManageCDictVo);
		ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
		ClientDatatModel.setMsg("修改完毕");
		 
		return ClientDatatModel;
	}
	
	/**
	 * 获取单条信息
	 * */
	@RequestMapping("getInfoById/{id}/{type}/{name}")
	public ClientDatatModel<SysManageCDictVo> getInfoById(@PathVariable("id") String id,
			@PathVariable("type") String type,
			@PathVariable("name") String name
			) {
		ClientDatatModel<SysManageCDictVo> ClientDatatModel = new ClientDatatModel<>();
		SysManageCDictVo sysManageCDictVo = sysCDictServiceImpl.getInfoById(id);
		
		//如果intResult是1，代表录入成功，如果是Constants.CONTROLLER_SUCCE，代表录入失败，如果是2，代表字典代码重复
		if(sysManageCDictVo != null) {
			ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
			ClientDatatModel.setData(sysManageCDictVo);
		} 
		return ClientDatatModel;
	}
	
	/**
	 * 新增字典信息
	 * */
	@ControllerLoggerAnnontation(description = "新增字典信息",isSaveToDb=true)
	@RequestMapping("insertDictInfo")
	//@RepetitionSubmitAnnotation(needRemoveToken = true)
	public ClientDatatModel<String> insertDictInfo(@RequestBody SysManageCDictVo sysManageCDictVo,HttpServletRequest request) {
		ClientDatatModel<String> ClientDatatModel = new ClientDatatModel<>();
		SUserVo sUserVo = super.getSUserVo(request);
		sysManageCDictVo.setCreater(sUserVo.getUserId());
		sysManageCDictVo.setUpdater(sUserVo.getUserId());
		int intResult = sysCDictServiceImpl.insertDictInfo(sysManageCDictVo);
		
		//如果intResult是1，代表修改成功，如果是Constants.CONTROLLER_SUCCE，代表修改失败，如果是2，代表字典代码重复
		if(intResult == 1) {
			ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
			ClientDatatModel.setMsg("新增完毕");
		} else if ( intResult == 0 ) {
			ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
			ClientDatatModel.setMsg("新增失败");
		} else {
			ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
			ClientDatatModel.setMsg("代码重复");
		}
		return ClientDatatModel;
	}
}
