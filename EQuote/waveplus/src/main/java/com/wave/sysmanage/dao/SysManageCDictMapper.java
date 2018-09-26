package com.wave.sysmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.wave.sysmanage.vo.SysManageCDictVo;

public interface SysManageCDictMapper {
	

	
    int deleteByPrimaryKey(String id);

    int insert(SysManageCDictVo record);

    int insertSelective(SysManageCDictVo record);

    SysManageCDictVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysManageCDictVo record);

    int updateByPrimaryKey(SysManageCDictVo record);
    
    int  checkDictKey(SysManageCDictVo sysManageCDictVo);
    int checkCentralitySysKeyInfo(SysManageCDictVo sysManageCDictVo);
    
    List<SysManageCDictVo> getTreeInfo(SysManageCDictVo sysManageCDictVo);
    
    int checkDictKeyInfo(SysManageCDictVo sysManageCDictVo);
    
    SysManageCDictVo getDictParentInfo(String pid);
    /**
     * 数据同步用
     * @return
     */
    List<SysManageCDictVo> selectByExport(@Param("exportType") String exportType);
    
    void insertByImport(
    		@Param("sysManageCDictVoList")List<SysManageCDictVo> sysManageCDictVoList) throws DataAccessException;

    
    /**
     * 删除字典数据信息
     * */
    int deleteDictInfo();
    
    /**
     * 删除字典数据信息
     * */
    int deleteByImport(@Param("sysManageCDictVoList")List<SysManageCDictVo> sysManageCDictVoList);
    
    
    
}