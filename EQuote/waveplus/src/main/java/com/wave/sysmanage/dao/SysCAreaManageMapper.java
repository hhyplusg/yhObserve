package com.wave.sysmanage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wave.common.vo.SysCAreaManageVo;

public interface SysCAreaManageMapper {
	

     
    List<SysCAreaManageVo> getAreasByPid(
            @Param("pid") String pid,
            @Param("cityCode") String cityCode ,
            @Param("countyCode") String countyCode);
    /**
     * 通过区划代码取得区划信息
     * @param areaCode
     * @return List<CAreaInfoVo> 
     */
    public List<SysCAreaManageVo> getAreaInfoByAreaCode(String areaCode);
    
    int deleteByPrimaryKey(String id);

    int insert(SysCAreaManageVo record);

    int insertSelective(SysCAreaManageVo record);

    SysCAreaManageVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysCAreaManageVo record);

    int updateByPrimaryKey(SysCAreaManageVo record);
     
    public List<Map<String, Object>> getAreaInfoOrgLevelId();
	 

}