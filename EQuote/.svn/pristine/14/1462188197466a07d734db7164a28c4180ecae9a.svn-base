package com.wave.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.wave.common.vo.CDictVo;


public interface CDictMapper {
    /**
     * 通过数据字典类型取得数据字典
     * @param cDictType
     * @return
     */
    public List<CDictVo> getCDictVoByType(String cDictType) throws DataAccessException; 
    
    /**
     * 通过数据字典Pid取得数据字典
     * @param cDictPid 
     * @return
     */
    public List<CDictVo> getCDictVoByPid(String cDictPid) throws DataAccessException; 
    /**
     * 通过字典类型与字段key取得字典信息
     * @param record
     * @return
     * @throws DataAccessException
     */
    public CDictVo getCDictVoByKey(CDictVo cDictVo) throws DataAccessException;
    
    

    
    
 
}