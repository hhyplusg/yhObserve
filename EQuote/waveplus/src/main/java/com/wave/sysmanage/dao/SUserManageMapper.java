package com.wave.sysmanage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wave.sysmanage.vo.AreaUserTreeVo;
import com.wave.sysmanage.vo.SUserInfoVo;
import com.wave.sysmanage.vo.SelectUserConditionVo;

public interface SUserManageMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SUserInfoVo record);

    int insertSelective(SUserInfoVo record);

    SUserInfoVo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SUserInfoVo record);
    
    void updateAreaCode(@Param("areaCode") String areaCode,@Param("orgId") String orgId);

    int updateByPrimaryKey(SUserInfoVo record);
    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @return
     */
	List<SUserInfoVo> selectUserById(@Param("userId")String userId);
	/**
	 *根据区划代码查询当前区划下的所有区划和区划的系统
	 * @param treeCode
	 * provinceCode cityCode countyCode
	 * @return
	 */ 
	List<AreaUserTreeVo> selectAreaSysAndOrgByPid(@Param("treeCode")String treeCode,
	        @Param("treeType")String treeType, 
	        @Param("cityCode")String cityCode,
	        @Param("countyCode")String countyCode
	        );
	
	List<AreaUserTreeVo> selectAreaSysAndOrgWithPid(@Param("treeCode")String treeCode,
	        @Param("cityCode")String cityCode,
	        @Param("countyCode")String countyCode);
	/**
	 * 根据条件查询用户信息
	 * @param selectUserCondition
	 * @return
	 */
	List<SUserInfoVo> selectUserByCondition(SelectUserConditionVo selectUserCondition);
	/**
	 * 根据父节点查询一级子节点
	 * @param treeCode
	 * @return
	 */
	List<AreaUserTreeVo> selectChildsByPid(@Param("treeId") String treeId, 
	        @Param("treeArea") String treeArea,
	        @Param("orgType") String orgType,
	        @Param("cityCode")String cityCode,
            @Param("countyCode")String countyCode, 
            @Param("orgId")String orgId);
	/**
	 * 根据用户id和密码查询用户是否存在
	 * @param sUserInfo
	 * @return
	 */
	List<SUserInfoVo> selectByUserIdAndPass(SUserInfoVo sUserInfo);
	
	/**
	 * 数据同步用
	 * */ 
	 List<SUserInfoVo> selectByExport(String userLonginName);
	 
	 void insertByImport(@Param("sUserInfoVoList")List<SUserInfoVo>  sUserInfoVoList);

	List<SUserInfoVo> selectByUserNameAndArea(SUserInfoVo sUserInfo);
	/**
	 * 查询节点下所有节点
	 * @param treeCode
	 * @return
	 */
	List<AreaUserTreeVo> selectNextAllByAreaCode(@Param("treeCode")String treeCode);

	List<Map<String,String>> getSystemByAreaCode(@Param("treeCode") String treeCode);
}