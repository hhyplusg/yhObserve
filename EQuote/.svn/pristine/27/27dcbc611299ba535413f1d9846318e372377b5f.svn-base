package com.wave.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.wave.common.vo.CDictVo;

public interface CDictService{

    /**
     *  根据数据字典的key列表返回相应字典数据
     * @param cDictVoList
     * @return
     */
    public  Map<String,  List<CDictVo>> getDictListBytypes(List<String> cDictTypeList);
        
    /**
     * 通过数据字典Pid取得数据字典
     * @param cDictPid
     * @return
     */
    public  Map<String,  List<CDictVo>> getCDictByPid(List<String> pidList);
    
    /**
     * 通过数据字典的type 和 key取值
     * @param dictType,dictKey
     * @return
     */
    public CDictVo getCDictByTypeAndKey(String dictType,String dictKey);
    
    /**
     * 通过字典类型与字段key取得字典信息
     * @param record
     * @return
     * @throws DataAccessException
     */
    public CDictVo getCDictVoByKey(CDictVo cDictVo);
    
}