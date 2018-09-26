package com.wave.sysmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wave.sysmanage.vo.SRoleFunctionVo;
public interface SRoleFunctionMapper {
    int deleteByPrimaryKey(SRoleFunctionVo key);

    int insert(SRoleFunctionVo record);
    
    int insertSelective(SRoleFunctionVo record);
    
    /**
     * 批量添加角色权限
     * @param list
     * @return
     */
   public void addRoleFunctions(@Param("sRoleFunctionVoList")List<SRoleFunctionVo> sRoleFunctionVoList);
    /**
     * 根据角色id查询角色功能
     * @param roleId
     * @return
     */
    List<SRoleFunctionVo> selectByRoleId(String roleId);
    /**
     * 根据角色id删除角色功能权限
     * @param roleId
     * @return
     */
    int deleteByRoleId(String roleId);
    
    
    /**
     * 数据同步用
     * */ 
     List<SRoleFunctionVo> selectByExport(String userLonginName);
     
     void insertByImport(@Param("sRoleFunctionVoList")List<SRoleFunctionVo>  sRoleFunctionVoList);
    
    
}