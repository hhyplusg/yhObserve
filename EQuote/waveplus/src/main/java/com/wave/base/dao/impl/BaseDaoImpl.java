package com.wave.base.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wave.base.dao.BaseDao;

/**
 *  
 */
public  class BaseDaoImpl extends Object implements BaseDao {
	
	
	/** common logger */
    protected transient final Logger log = LogManager.getLogger(getClass()); 
    
    /* (non-Javadoc)
	 * @see com.hoosen.base.dao.impl.BaseDao#init()
	 */
    public void init(){
    	
    }
    
}
