package com.wave.sysmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wave.sysmanage.vo.SRoleUserVo;


public interface SRoleUserMapper {
    int deleteByPrimaryKey(SRoleUserVo key);

    int insert(SRoleUserVo record);

    int insertSelective(SRoleUserVo record);
    /**
     * 根据用户的id删除用户的角色信息
     * @param userId
     */
	int deleteRoleByUserId(String userId);
	
	/**
     * 数据同步用
     * */ 
     List<SRoleUserVo> selectByExport(String userLonginName);
     
     void insertByImport(@Param("sRoleUserVoList")List<SRoleUserVo>  sRoleUserVoList);
    
}