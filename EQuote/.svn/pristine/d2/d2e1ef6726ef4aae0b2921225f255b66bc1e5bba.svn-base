package com.wave.sysmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.wave.sysmanage.vo.SFunctionInfoVo;



public interface SFunctionManageMapper {
	

	
    int deleteByPrimaryKey(Integer id);

    int insert(SFunctionInfoVo record);

    int insertSelective(SFunctionInfoVo record);

    SFunctionInfoVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SFunctionInfoVo record);

    int updateByPrimaryKey(SFunctionInfoVo record);
    
    
    /**
     * 根据功能类型和父节点查询功能信息
     * @param functionType 10:菜单；20:按钮
     * @param pid
     * @return
     */
    List<SFunctionInfoVo> selectFunctionByTypeAndPid(@Param("functionType") String functionType,@Param("pid")String pid);
    
    /**
     * 数据同步用
     * @return
     */
    List<SFunctionInfoVo> selectByExport();
    int deleteByImport(@Param("sFunctisonInfoVoList")List<SFunctionInfoVo> sFunctionInfoVoList);
    public void insertByImport(@Param("sFunctisonInfoVoList")List<SFunctionInfoVo> sFunctionInfoVoList) throws DataAccessException;

}