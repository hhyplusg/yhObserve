package com.wave.sysmanage.service;

import java.util.List;

import com.wave.base.service.BaseService;
import com.wave.sysmanage.vo.AreaUserTreeVo;
import com.wave.sysmanage.vo.SRoleVo;
import com.wave.sysmanage.vo.SUserInfoVo;
import com.wave.sysmanage.vo.SelectUserConditionVo;

public interface SUserService extends BaseService {
	/**
	 * 根据区划和角色类型查询角色信息
	 * @param areaCode
	 * @param roleType
	 * @return
	 */
	List<SRoleVo> getRolesByAreaAndType();
	/**
	 * 根据用户的id查询用户的信息和用户的角色信息
	 * @param userId
	 * @return
	 */
	SUserInfoVo getUserInfoByUserId(String userId);
	/**
	 * 添加用户信息和用户的角色信息
	 * @param sUserInfo
	 * @return
	 */
	void addUserAndRole(SUserInfoVo sUserInfo);
	/**
	 * 根据区划代码查询当前区划下的所有区划和区划的系统
	 * @param treeCode
	 * @return
	 */
	List<AreaUserTreeVo> getAreaAndSysByAreaCode(String treeCode);
	/**
	 * 根据前台条件查询用户信息
	 * @param selectUserCondition
	 * @return
	 */
	List<SUserInfoVo> getUserByCondition(SelectUserConditionVo selectUserCondition);
	 
	/**
	 * 验证密码的正确性
	 * @param sUserInfo
	 */
	int checkUserPass(SUserInfoVo sUserInfo);
	 
	/**
	 * 验证用户是否存在
	 * @param sUserInfo
	 * @return
	 */
	int checkUserLoginName(SUserInfoVo sUserInfo);
	 
	/**
	 * 修改密码
	 */
	public void updatePass(SUserInfoVo sUserInfo);
}
