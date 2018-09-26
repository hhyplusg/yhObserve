package com.wave.sysmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wave.sysmanage.vo.AreaRoleTreeVo;
import com.wave.sysmanage.vo.SRoleVo;

public interface SRoleMapper {

    int insert(SRoleVo record);

    int insertSelective(SRoleVo record);

    SRoleVo selectByPrimaryKey(String roleCode);
    
    List<SRoleVo> selectByRoleName(String roleName);

    int updateByPrimaryKeySelective(SRoleVo record);

    int updateByPrimaryKey(SRoleVo record);
    
    int deleteByPrimaryKey(String roleCode);
    /**
     * 根据区划代码和角色类型查询角色信息
     * @param areaCode
     * @param roleType
     * @return
     */
	List<SRoleVo> getRolesByAreaAndType();
	
	List<SRoleVo> getAreaRoleByRoleName(@Param("areaCode") String areaCode,@Param("roleName") String roleName);
	
	/**
     * 根据角色类型查询角色tree
     * @return
     */
    List<AreaRoleTreeVo> getRoleByRoleTypeAndAreaCode(SRoleVo sRole);
	
}
