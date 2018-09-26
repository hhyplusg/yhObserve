package com.wave.core.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wave.common.cnstants.Constants;
import com.wave.core.util.DateUtil;

public class SqliteInit {
    protected transient final Logger log = LogManager.getLogger(getClass());
    String dbUrl;
    String dbFolder;
    String driverClassName;
    public void init(){
        log.debug("SqliteInit() is start!");
        Connection conn = null;
        try {
            Class.forName(driverClassName);
            // 切换java.io的临时文件目录，用于生成sqlite.dll的临时文件"sqlite-3.8.11.2-0b383af3-d159-4395-9a14-9a54722ef352-sqlitejdbc.dll"
            // 因为java关闭时不一定能关闭sqlite，如果再次启动时，将无法启动。
            // 因为每次启动时都在生成一下dll文件，
            // 所以在启动前需要删除相关的文件。
            File dbFolderFiles = new File(dbFolder);
            //获取目录中的文件 或者文件夹  
            File[] dllFiles = dbFolderFiles.listFiles();
            String strDate = DateUtil.format(new Date(), "yyyyMMdd");
            String strFileName;
            // 数据库文件一天只备份一次。
            boolean isBacked = false;
            for (File tempFile : dllFiles) {  
                if (tempFile.isDirectory()) {  
                    continue;
                } else if (tempFile.getName().endsWith(Constants.FILE_SUBFFIX_DLL) || 
                        tempFile.getName().endsWith(Constants.FILE_SUBFFIX_TMP)) {
                    // 删除sqlite临时dll文件,其他临时文件
                    if (!tempFile.delete()){
                        tempFile.deleteOnExit();
                    } 
                }else {
                    // 遍历文件，用于判断启动当天是否已备份过数据库文件
                    strFileName = tempFile.getName();
                    if (!isBacked) {
                        if (strFileName.startsWith(strDate)) {
                            isBacked = true;
                        }
                        
                    }
                } 
            }  
            // 切换java.io的临时文件目录，否则会将临时文件放到系统临时文件目录，有的操作系统到导致拒绝访问sqlite.dll
            System.setProperty("java.io.tmpdir", dbFolder); 
            
            // 如果当天已备份过数据库，则不用再备份。
            if (isBacked) {
                return;
            }
            log.debug("----------------------------->数据库备份开始");
            String strBackupFileFullName = dbFolder + DateUtil.getTimeStampFileName() + Constants.FILE_SUBFFIX_DB;
            log.debug("->数据库备份目录：{}",strBackupFileFullName);
            FileUtils.copyFile(new File(dbUrl), new File(strBackupFileFullName));
            log.debug("----------------------------->数据库备份结束");
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbUrl);
            log.debug("----------------------------->sqlite init success");
        } catch (Exception e) {
            log.debug(e);
        } finally {
           try {
            if (conn != null && conn.isClosed()) {
                   conn.close();
                   conn = null;
               }
            } catch (SQLException e) {
                log.debug("sqlite数据库初始化失败！",e);
            }
           log.debug("SqliteInit() is end!");
        }
    }
    
    /**
     * @return the driverClassName
     */
    public String getDriverClassName() {
        return driverClassName;
    }

    /**
     * @param driverClassName the driverClassName to set
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    /**
     * @return the dbFolder
     */
    public String getDbFolder() {
        return dbFolder;
    }

    /**
     * @param dbFolder the dbFolder to set
     */
    public void setDbFolder(String dbFolder) {
        this.dbFolder = dbFolder;
    }

    /**
     * @return the dbUrl
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /**
     * @param dbUrl the dbUrl to set
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }
 
}
