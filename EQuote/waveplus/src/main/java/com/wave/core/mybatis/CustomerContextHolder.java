package com.wave.core.mybatis;

import com.wave.common.cnstants.Constants;

public abstract class CustomerContextHolder {
    public static final String SQLITE="SQLITE";
    public static final String SQLITE_EXP_IMP="SQLITE_EXP_IMP";
    public static final String ORACLE="ORACLE"; 
    public static String DATASOURCE; 
    static {
        if (Constants.IS_DEFUALT.equals(Constants.IS_DEFUALT)) {
            DATASOURCE = DataSourceSwitch.ORACLE;
        } else {
            DATASOURCE = DataSourceSwitch.SQLITE;
        }
    }
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
    
    public static void setContextType(String contextType) {  
        contextHolder.set(contextType);  
    }  
      
    public static String getContextType() {  
        return contextHolder.get();  
    }  
      
    public static void clearContextType() {  
        contextHolder.remove();  
    }  
}