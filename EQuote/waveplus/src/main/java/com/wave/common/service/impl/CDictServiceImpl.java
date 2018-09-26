package com.wave.common.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.wave.base.constant.ErrorConstants;
import com.wave.base.service.impl.BaseServiceImpl;
import com.wave.common.cnstants.Constants;
import com.wave.common.dao.CDictMapper;
import com.wave.common.exception.CommonServiceException;
import com.wave.common.service.CDictService;
import com.wave.common.vo.CDictVo;
import com.wave.core.util.StringUtil;
@Service("cDictService")
public class CDictServiceImpl extends BaseServiceImpl implements CDictService  {
	@Resource(name="CDictMapper")
    CDictMapper cDictMapper;
	/**
	 *  根据数据字典的key列表返回相应字典数据
	 * @param cDictVoList
	 * @return
	 */
	public  Map<String,  List<CDictVo>> getDictListBytypes(List<String> cDictTypeList) throws CommonServiceException{
	    Map<String,  List<CDictVo>> cDictMapList = new HashMap<String,  List<CDictVo>>();
	    for (Iterator<String> iterator = cDictTypeList.iterator(); iterator.hasNext();) {
            String cDictType = (String) iterator.next();
            if ( StringUtil.isEmpty(cDictType) ) {
                throw new CommonServiceException("字典类型不能为空！",ErrorConstants.EXCEPTION_SOURCE_USER, ErrorConstants.EXCEPTION_SEVERITY_HIGH);
            }
            List<CDictVo> CDictVoList = cDictMapper.getCDictVoByType(cDictType);
            cDictMapList.put(cDictType, CDictVoList);
        }
        return cDictMapList;
	    
	}
	
    /**
     * 通过数据字典Pid取得数据字典
     * @param cDictPid
     * @return
     */
	public  Map<String,  List<CDictVo>> getCDictByPid(List<String> pidList){
        Map<String,  List<CDictVo>> cDictMapList = new HashMap<String,  List<CDictVo>>();
        for (Iterator<String> iterator = pidList.iterator(); iterator.hasNext();) {
            String pid = (String) iterator.next();
            if ( StringUtil.isEmpty(pid) ) {
                throw new CommonServiceException("要查询的数据数据父节点要不能为空！",ErrorConstants.EXCEPTION_SOURCE_USER, ErrorConstants.EXCEPTION_SEVERITY_HIGH);
            }
            List<CDictVo> CDictVoList = cDictMapper.getCDictVoByPid(pid);
            cDictMapList.put(pid, CDictVoList);
        }
        return cDictMapList;
    }
	/**
     * 通过数据字典的type 和 key取值
     * @param dictType,dictKey
     * @return
     */
	public CDictVo getCDictByTypeAndKey(String dictType,String dictKey){
		CDictVo cDictVo = new CDictVo();
		cDictVo.setDictKey(dictKey);
		cDictVo.setDictType(dictType);
		cDictVo = cDictMapper.getCDictVoByKey(cDictVo);
		return cDictVo;
	}
	/**
     * 通过字典类型与字段key取得字典信息
     * @param record
     * @return
     * @throws DataAccessException
     */
	public CDictVo getCDictVoByKey(CDictVo cDictVo){
	    if ( log.isDebugEnabled() ) {
            log.debug("getCDictVoByKey() is start");
            log.debug("传入参数：{}---->{}" ,Constants.CRLF, cDictVo ); 
        }
	    CDictVo retCDictVo = new CDictVo();
        try{
            retCDictVo =cDictMapper.getCDictVoByKey(cDictVo);
            return retCDictVo;
        } finally {
            log.debug("返回值：" + Constants.CRLF + retCDictVo );
           log.debug("getCDictVoByKey() is end");
        }
	}
 
}