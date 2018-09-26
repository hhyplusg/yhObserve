package com.wave.base.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wave.base.service.BaseService;
import com.wave.core.util.StringUtil;
@Service
public class BaseServiceImpl implements BaseService {
	 /** 公用日志处理类 */
    protected transient final Logger log = LogManager.getLogger(getClass());
     
    
    /**
     * 根据区划代码获得CITY_CODE以及COUNTY_CODE
     * */
    public String[] getAreaCodeArray(String areaCode) {
    	if ( StringUtil.isNotEmpty(areaCode) && areaCode.length() == 6) {
    		String[] areaCodeArray = new String[2];
    		areaCodeArray[0] = areaCode.substring(2,4);
    		areaCodeArray[1] = areaCode.substring(4,6);
    		if(areaCode.equals("420001")) {
    			areaCodeArray[0] = "00";
    			areaCodeArray[1] = "01";
    			return areaCodeArray;
    		} else {
    			if(areaCodeArray[0].equals("00") ){
        			return null;
        		}else{
        			return areaCodeArray;
        		}
    		}
    	} 
    	return null;
    }
}