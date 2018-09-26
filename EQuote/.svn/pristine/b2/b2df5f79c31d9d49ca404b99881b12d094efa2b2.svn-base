package com.wave.sysmanage.service;

import java.util.List;

import com.wave.base.service.BaseService;
import com.wave.sysmanage.vo.AreaRoleTreeVo;
import com.wave.sysmanage.vo.SRoleFunctionVo;
import com.wave.sysmanage.vo.SRoleVo;

public interface SRoleService extends BaseService {
	/**
	 * 根据角色类型和区划代码查询区划和角色树形列表
	 * @return
	 */
	List<AreaRoleTreeVo> getAreaRoleTree(SRoleVo sRole);
	/**
	 * 添加一个角色
	 * @param sRole
	 * @return
	 */
	void addRole(SRoleVo sRole);
	/**
	 * 根据角色编码查询角色信息
	 * @param roleCode
	 * @return
	 */
	SRoleVo getRoleByRoleCode(String roleCode);
	/**
	 * 根据角色名称查询角色信息
	 */
	SRoleVo getRoleByRoleName(String roleName);
	/**
	 * 为角色添加功能权限
	 * @param roleCode
	 * @param function_check
	 * @return
	 */
	void addRoleFunctions(String roleCode, List<String> function_check);
	/**
	 * 根据角色id查询角色的功能权限
	 * @param roleCode
	 * @return
	 */
	List<SRoleFunctionVo> getFunctionByRoleId(String roleCode);
	
}
