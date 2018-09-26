package com.wave.core.mybatis;

import com.wave.common.cnstants.Constants;

public class DataSourceSwitch{  
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
    private static final ThreadLocal<String> contextHolder=new ThreadLocal<String>();  
      
    public static void setDataSourceType(String dataSourceType){  
        contextHolder.set(dataSourceType);  
    }  
      
    public static String getDataSourceType(){  
        return (String) contextHolder.get();  
    }  
      
    public static void clearDataSourceType(){  
        contextHolder.remove();  
    }  
} 