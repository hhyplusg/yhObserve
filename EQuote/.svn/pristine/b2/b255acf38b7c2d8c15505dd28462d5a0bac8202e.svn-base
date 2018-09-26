package com.wave.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.wave.common.vo.SysCAreaManageVo;


public interface CAreaInfoMapper { 
    /**
     * 根据ID取得区划信息
     * @param areaCode
     * @return
     * @throws DataAccessException
     */
    List<SysCAreaManageVo> getAreasById(String id) throws DataAccessException;
    
    /**
     * 根据区划代码取得区划信息
     * @param areaCode
     * @return
     * @throws DataAccessException
     */
    List<SysCAreaManageVo> getAreasByAreaCode(String areaCode) throws DataAccessException;
    /**
     * 根据pid取得区划信息
     * @param areaCode
     * @return
     * @throws DataAccessException
     */
	List<SysCAreaManageVo> getAreasByPid(String pid) throws DataAccessException; 
    /**
     * 根据子节点查询父节点信息
     * @param childAreaCode
     * @return
     */
	List<SysCAreaManageVo> getCAreaInfoVoByChild(String childAreaCode) throws DataAccessException;
	/**
	 * 根据父节点查询子节点及其子节点的子节点
	 * @param parentAreaCode
	 * @return
	 */
	List<SysCAreaManageVo> getAllNextAreaByPid(@Param("pid")String pid) throws DataAccessException;
	/**
	 * 删除导入的数据信息
	 * @param areaCodes
	 * @return
	 */
	int deleteByImport(@Param("areaCodes") String[] areaCodes);
}