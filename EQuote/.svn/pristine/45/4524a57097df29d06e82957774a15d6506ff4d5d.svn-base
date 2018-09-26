package com.wave.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wave.base.service.impl.BaseServiceImpl;
import com.wave.core.util.Md5Util;
import com.wave.core.util.StringUtil;
import com.wave.core.util.UUIDUtils;
import com.wave.sysmanage.dao.SRoleMapper;
import com.wave.sysmanage.dao.SRoleUserMapper;
import com.wave.sysmanage.dao.SUserManageMapper;
import com.wave.sysmanage.service.SUserService;
import com.wave.sysmanage.vo.AreaUserTreeVo;
import com.wave.sysmanage.vo.SRoleUserVo;
import com.wave.sysmanage.vo.SRoleVo;
import com.wave.sysmanage.vo.SUserInfoVo;
import com.wave.sysmanage.vo.SelectUserConditionVo;
@Service("sUserService")
public class SUserServiceImpl extends BaseServiceImpl implements SUserService {
	@Resource(name="SRoleMapper")
	SRoleMapper sRoleMapper;
	
	@Resource(name="SUserManageMapper")
	SUserManageMapper sUserManageMapper;
	
	@Resource(name="SRoleUserMapper")
	SRoleUserMapper sRoleUserMapper;
	
	 
	
	/**
	 * 根据区划和角色类型查询角色信息
	 * @param areaCode
	 * @param roleType
	 * @return
	 */
	public List<SRoleVo> getRolesByAreaAndType(){
		List<SRoleVo> list = sRoleMapper.getRolesByAreaAndType();
		return list;
	}
	/**
	 * 根据用户的id查询用户的信息和用户的角色信息
	 * @param userId
	 * @return
	 */
	public SUserInfoVo getUserInfoByUserId(String userId){
		List<SUserInfoVo> users = sUserManageMapper.selectUserById(userId);
		if(users!=null&&users.size()>0){
			return users.get(0);
		}
		return new SUserInfoVo();
	}
	/**
	 * 添加用户信息和用户的角色信息
	 * @param sUserInfo
	 * @return
	 */
	public void addUserAndRole(SUserInfoVo sUserInfo){
		if(StringUtil.isNotEmpty(sUserInfo.getOrgId())){
			if("null".equals(sUserInfo.getOrgId())){
				sUserInfo.setOrgId(null);
			}
		}
		//判断获取的用户信息是否存在用户id，如果不存在执行添加操作，存在则执行修改操作
		if(StringUtil.isEmpty(sUserInfo.getUserId())){
			String uuid = UUIDUtils.getUUID();
			//生成一个uuid并赋给接收对象
			sUserInfo.setUserId(uuid);
			//添加用户信息
			sUserInfo.setPassword(Md5Util.encodePassword(sUserInfo.getPassword()));
			sUserManageMapper.insert(sUserInfo);
			//判断用户信息是否添加成功，成功则添加用户的角色信息
			SRoleUserVo sRoleUserVo = null;
			for(String roleId : sUserInfo.getRoles()){
				//循环添加角色用户信息
				sRoleUserVo = new SRoleUserVo();
				sRoleUserVo.setUserId(uuid);
				sRoleUserVo.setRoleId(roleId);
				sRoleUserMapper.insert(sRoleUserVo);
			}
		}else{
			//更新用户信息
			if(StringUtil.isNotEmpty(sUserInfo.getPassword())){
				sUserInfo.setPassword(Md5Util.encodePassword(sUserInfo.getPassword()));
			}
			sUserManageMapper.updateByPrimaryKeySelective(sUserInfo);
			//先删除当前用户已存在的角色再重新添加
			sRoleUserMapper.deleteRoleByUserId(sUserInfo.getUserId());
			if(sUserInfo.getRoles()!=null&&sUserInfo.getRoles().size()>0){
				SRoleUserVo sRoleUserVo = null;
				for(String roleId : sUserInfo.getRoles()){
					//循环添加角色用户信息
					sRoleUserVo = new SRoleUserVo();
					sRoleUserVo.setUserId(sUserInfo.getUserId());
					sRoleUserVo.setRoleId(roleId);
					sRoleUserMapper.insert(sRoleUserVo);
				}
			}
		}
	}
	/**
	 * 根据区划代码查询当前区划下的所有区划和区划的系统
	 * @param treeCode
	 * @return
	 */
	public List<AreaUserTreeVo> getAreaAndSysByAreaCode(String treeCode){
		List<AreaUserTreeVo> list = new ArrayList<AreaUserTreeVo>();
		String cityCode = treeCode.substring(2, 4);
	    String countyCode = treeCode.substring(4, 6);
	    if("00".equals(cityCode) && "00".equals(countyCode)) {
            cityCode = "";
            countyCode = "";
        } else if ("00".equals(countyCode)) {
            countyCode = "";
        }
		list = sUserManageMapper.selectAreaSysAndOrgWithPid(treeCode,cityCode,countyCode);
		return list;
	}
	 
	 
	/**
	 * 根据前台条件查询用户信息
	 * @param selectUserCondition
	 * @return
	 */
	public List<SUserInfoVo> getUserByCondition(SelectUserConditionVo selectUserCondition){
		List<SUserInfoVo> list = sUserManageMapper.selectUserByCondition(selectUserCondition);
		return list;	
	}
	/**
	 * 验证密码的正确性
	 * @param sUserInfo
	 */
	public int checkUserPass(SUserInfoVo sUserInfo){
		sUserInfo.setPassword(Md5Util.encodePassword(sUserInfo.getPassword()));
		List<SUserInfoVo> list = sUserManageMapper.selectByUserIdAndPass(sUserInfo);
		return list.size();
	}
	/**
	 * 验证用户名是否存在
	 * @param sUserInfo
	 */
	public int checkUserLoginName(SUserInfoVo sUserInfo){
		List<SUserInfoVo> list = sUserManageMapper.selectByUserNameAndArea(sUserInfo);
		return list.size();
	}
	
	 
	/**
	 * 修改密码
	 */
	public void updatePass(SUserInfoVo sUserInfo){
		if(StringUtil.isNotEmpty(sUserInfo.getPassword())){
			sUserInfo.setPassword(Md5Util.encodePassword(sUserInfo.getPassword()));
		}
		sUserManageMapper.updateByPrimaryKeySelective(sUserInfo);
	} 
}
