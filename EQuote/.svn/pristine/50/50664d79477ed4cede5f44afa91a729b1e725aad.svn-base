package com.wave.sysmanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wave.sysmanage.dao.SysManageCDictMapper;
import com.wave.sysmanage.service.SysCDictService;
import com.wave.sysmanage.vo.SysManageCDictVo;
@Service("sysCDictServiceImpl")
public class SysCDictServiceImpl implements SysCDictService {

	@Resource(name="sysManageCDictMapper")
	private SysManageCDictMapper sysManageCDictMapper;
	@Override
	public List<SysManageCDictVo> getTreeInfo(SysManageCDictVo sysManageCDictVo) {
		return sysManageCDictMapper.getTreeInfo(sysManageCDictVo);
	}
	
	/**
	 * 保存字典子集
	 * */
	@Override
	public int saveDictChiled(SysManageCDictVo sysManageCDictVo) {
		int intResult = 0;
		intResult = checkDictKeyInfo(sysManageCDictVo);
		if(intResult > 0) {
			intResult = 2;
		} else {
			sysManageCDictVo.setPid(sysManageCDictVo.getCheckId());
			SysManageCDictVo sysManageCDictParentVo = sysManageCDictMapper.getDictParentInfo(sysManageCDictVo.getPid());
			sysManageCDictVo.setIsSysUsed(sysManageCDictParentVo.getIsSysUsed());
			sysManageCDictVo.setId(sysManageCDictVo.getPid() + sysManageCDictVo.getDictKey());
			intResult = sysManageCDictMapper.insertSelective(sysManageCDictVo);
		}
		return intResult;
	}
	
	
	/**
	 * 新增字典数据
	 * */
	@Override
	public int insertDictInfo(SysManageCDictVo sysManageCDictVo) {
		int intResult = 0;
		//字典类型的dict_type等于dict_key
        sysManageCDictVo.setDictType(sysManageCDictVo.getDictKey());
		intResult = sysManageCDictMapper.checkDictKey(sysManageCDictVo);
		if(intResult > 0) {
			intResult = 2;
		} else {
			// 字典类型的pid等于dict_key
			sysManageCDictVo.setPid(sysManageCDictVo.getDictKey());
			
			// 字典id=字典pid+dict_key
			sysManageCDictVo.setId(sysManageCDictVo.getPid()+sysManageCDictVo.getDictKey());
			
//			sysManageCDictVo.setOtherSysKey(sysManageCDictVo.getDictKey());
//			sysManageCDictVo.setOtherSysValue(sysManageCDictVo.getDictValue());
			sysManageCDictVo.setOtherSysKey(sysManageCDictVo.getOtherSysKey());
			sysManageCDictVo.setOtherSysValue(sysManageCDictVo.getOtherSysValue());
			intResult = sysManageCDictMapper.insertSelective(sysManageCDictVo);
		}
		return intResult;
	}
	
	
	/**
	 * 查询实名制代码或系统代码是否有重复的
	 * */
	@Override
	public int checkDictKeyInfo(SysManageCDictVo sysManageCDictVo) {		
		return sysManageCDictMapper.checkDictKeyInfo(sysManageCDictVo);
	}
	

	@Override
	public SysManageCDictVo getInfoById(String id) {
		return sysManageCDictMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 修改字典信息
	 * */
	@Override
	public int updateDictInfo(SysManageCDictVo sysManageCDictVo) {
		int intResult = 0;
		//intResult = sysManageCDictMapper.checkCentralitySysKeyInfo(sysManageCDictVo);
		//获得上级字典信息
		SysManageCDictVo sysManageCDictParentVo = sysManageCDictMapper.getDictParentInfo(sysManageCDictVo.getPid());
		if (sysManageCDictParentVo != null) {
		    sysManageCDictVo.setIsSysUsed(sysManageCDictParentVo.getIsSysUsed()); 
        }
		/*if(intResult > 0) {
			intResult = 2;
		} else {
			intResult = sysManageCDictMapper.updateByPrimaryKeySelective(sysManageCDictVo);
		}*/
		sysManageCDictMapper.updateByPrimaryKeySelective(sysManageCDictVo);
		return intResult;
	}


}
