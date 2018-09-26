package com.wave.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wave.base.service.impl.BaseServiceImpl;
import com.wave.core.util.StringUtil;
import com.wave.core.util.UUIDUtils;
import com.wave.sysmanage.dao.SRoleFunctionMapper;
import com.wave.sysmanage.dao.SRoleMapper;
import com.wave.sysmanage.service.SRoleService;
import com.wave.sysmanage.vo.AreaRoleTreeVo;
import com.wave.sysmanage.vo.SRoleFunctionVo;
import com.wave.sysmanage.vo.SRoleVo;
@Service("sRoleService")
public class SRoleServiceImpl extends BaseServiceImpl implements SRoleService {
	@Resource(name="SRoleMapper")
	private SRoleMapper sRoleMapper;
	
	@Resource(name="SRoleFunctionMapper")
	private SRoleFunctionMapper sRoleFunctionMapper;
	
	/**
	 * 根据角色类型和区划代码查询区划和角色树形列表
	 * @return
	 */
	@Override
	public List<AreaRoleTreeVo> getAreaRoleTree(SRoleVo sRole) {
		
		List<AreaRoleTreeVo> list= sRoleMapper.getRoleByRoleTypeAndAreaCode(sRole);
		return list;
	}
	/**
	 * 添加新的角色
	 */
	public void addRole(SRoleVo sRole){
		if(StringUtil.isEmpty(sRole.getRoleCode())){
			String uuid = UUIDUtils.getUUID();
			sRole.setRoleCode(uuid);
			sRole.setStatus("20");
			if(StringUtil.isNotEmpty(sRole.getCopyRole())){
				//为areacode赋值
				SRoleVo copyRole = sRoleMapper.selectByPrimaryKey(sRole.getCopyRole());
			}
			//添加新的角色
			sRoleMapper.insert(sRole);
			//如果复制了角色，则将复制角色的权限一并添加
			if(StringUtil.isNotEmpty(sRole.getCopyRole())){
				//查询已复制角色的权限
				List<SRoleFunctionVo> roleFunctions = sRoleFunctionMapper.selectByRoleId(sRole.getCopyRole());
				for(SRoleFunctionVo sRoleFunction : roleFunctions){
					//将复制角色的uuid替换为新增角色的uuid
					sRoleFunction.setRoleId(uuid);
					//执行新增角色权限操作
					sRoleFunctionMapper.insert(sRoleFunction);
				}
			}
		}else{
			sRoleMapper.updateByPrimaryKeySelective(sRole);
		}
	}
	/**
	 * 根据角色编码查询角色信息
	 */
	public SRoleVo getRoleByRoleCode(String roleCode){
		SRoleVo sRoleVo = sRoleMapper.selectByPrimaryKey(roleCode);
		return sRoleVo;
	}
	
	/**
	 * 根据角色名称查询角色信息
	 */
	public SRoleVo getRoleByRoleName(String roleName){
		List<SRoleVo> sRoleList = sRoleMapper.selectByRoleName(roleName);
		if(StringUtil.isNotEmpty(sRoleList) && sRoleList.size() > 0){
			return sRoleList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 为角色添加功能权限
	 * @param roleCode
	 * @param function_check
	 * @return
	 */
	public void addRoleFunctions(String roleCode, List<String> function_check){
		List<SRoleFunctionVo> sRoleFunctionVoList = new ArrayList<SRoleFunctionVo>();
		sRoleFunctionMapper.deleteByRoleId(roleCode);
		SRoleFunctionVo sRoleFunction = null;
		for(int j=0;j<function_check.size();j++){
			sRoleFunction = new SRoleFunctionVo();
			sRoleFunction.setRoleId(roleCode);
			sRoleFunction.setFunctionId(function_check.get(j));
			sRoleFunctionVoList.add(sRoleFunction);
			//i+= sRoleFunctionMapper.insert(sRoleFunction);
		}
		log.debug(sRoleFunctionVoList); 
		sRoleFunctionMapper.addRoleFunctions(sRoleFunctionVoList);
	}
	
	/**
	 * 根据角色id查询角色的功能权限
	 * @param roleCode
	 * @return
	 */
	public List<SRoleFunctionVo> getFunctionByRoleId(String roleCode){
		List<SRoleFunctionVo> list = sRoleFunctionMapper.selectByRoleId(roleCode);
		return list;
	}
	
}
