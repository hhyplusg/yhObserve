package com.wave.core.util;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 

/**
 * 加载配置文件
 * @author sdh
 * @date 2010-08-05
 * @version 1.1
 *
 */
public class ConfigUtil {
    /**
     * log信息属性文件
     * */
    public static String LOG_INFO="conf.log4j.loginfo";
	protected transient static final Logger log = LogManager.getLogger(ConfigUtil.class);
	private static ResourceBundle bundle; 
	static {
		bundle = ResourceBundle.getBundle("conf.common");
	}
	
	/**
	 * 得到key的value
	 * @param key值
	 * @return 正常返回key的value，异常返回null
	 * @throws Exception 
	 */
	public static String getString(String key)  {
		String value = null;
		try {
			value = bundle.getString(key);
		} catch (Exception e) { 
			log.error("配置文件（conf.config）中,字段（" + key + "）取值时时失败。请与系统管理员联系！",e);
			value = null;
		}
		return value;
	}
	
	public static String getString(String propertiesPath,String key)  {
		String value = null;
		try {
			value = ResourceBundle.getBundle(propertiesPath).getString(key);
		} catch (Exception e) { 
			log.error("配置文件（" + propertiesPath + "）中,字段（" + key + "）取值时时失败。请与系统管理员联系！",e);
			value = null;
		}
		return value;
	}
	public static void main(String[] args) { 
	}
 
	
}
