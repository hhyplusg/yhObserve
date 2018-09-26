package com.wave.core.util;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wave.base.exception.ServiceException;


/**
 * 文件操作的工具类
 */
public class BaseFileUtil {
	public final static  Logger log = LogManager.getLogger(BaseFileUtil.class); 
	/**
	 * 得到文件的后缀名
	 * @param fileName 文件名
	 * @return 文件的格式
	 */
	public static String getSuffix(String fileName){
		String str="";
		int beginIndex=fileName.lastIndexOf(".");
		str=fileName.substring(beginIndex, fileName.length());
		return str;
	}
	
	/**
	 * 得到文件的文件名
	 * @param fileName 文件名
	 * @return 文件的格式
	 */
	public static String getFileName(String strFullFileName){
		String str="";
		int index=strFullFileName.lastIndexOf("/");
		if (index == -1) {
			index=strFullFileName.lastIndexOf("\\");
		}
		str=strFullFileName.substring(index+1, strFullFileName.length());
		return str;
	}
	/**
	 * 得到文件的文件目录
	 * @param fileName 文件名
	 * @return 文件的格式
	 */
	public static String getFilePath(String strFullFileName){
		String str="";
		int index=strFullFileName.lastIndexOf("/");
		if (index == -1) {
			index=strFullFileName.lastIndexOf("\\");
		}
		str=strFullFileName.substring(0,index+1);
		return str;
	}
	/**
	 * 更换文件扩展名
	 * @param fileName 文件名
	 * @param strSubffix 文件扩展名
	 * @return 文件名
	 */
	public static String changeSuffix(String fileName,String strSubffix){
		
		int beginIndex = fileName.lastIndexOf(".");
		// 原文件名没有扩展名，或没指定扩展名时，返回原文件名
		if (beginIndex < 1 || StringUtil.isEmpty(strSubffix)) {
			return fileName;
		}
		String str = "";
		// 指定的文件名前带“.”处理。
		if (StringUtil.isNotEmpty(strSubffix) && strSubffix.startsWith(".")) {
			str = fileName.substring(0, beginIndex) + strSubffix;
		
		} else {
			str=fileName.substring(0, beginIndex + 1) + strSubffix;
		}
		
		return str;
	}
	
	/**
	 * 得到文件大小  单位是字节
	 * 
	 * @param file the file
	 * 
	 * @return 如果正常返回文件的大小，否则返回-1
	 */
	public static long getFileSize(File file){
	    long size=-1;
		try {
			size=file.length(); 
		} catch (Exception e) {
			return size;
		}
		return size;
	}
	
	/**
     * 得到文件大小  单位是字节
     * 
     * @param inFullFileName the file
     * 
     * @return 如果正常返回文件的大小，否则返回-1
     */
    public static String getZHFileSize(String inFullFileName){
        long size= getFileSize(new File(inFullFileName));
        String fileSize=""; 
        float kb = 1024;
        float mb = kb * 1024;
        float gb = mb * 1024; 
        if(size >= gb) { 
            fileSize = String.format("%.2f",size/gb)+ "GB";
        } else if(size >= mb) { 
            fileSize = String.format("%.2f",size/mb)+ "MB";
        } else if(size >= kb) { 
            fileSize = String.format("%.2f",size/kb)+ "KB";
        } else {
            fileSize = String.valueOf(size) + "B";
        }
        return fileSize;
    }
	
	/**
	 * 文件转移
	 * @param filename 文件名
	 * @param oldpath 旧目录
	 * @param newpath 新目录
	 */
	public boolean changeDirectory(String filename, String oldpath, String newpath) throws ServiceException {
		try {
			File f = new File(newpath);
			
			if (!f.isDirectory()) {	//如果指定的目录不存在那么新建一个
				f.mkdir();
			}
			if (!oldpath.equals(newpath)) {//如果指定的目录与原目录不是同一目录
				File oldfile = new File(oldpath + "/" + filename);
				File newfile = new File(newpath + "/" + filename);
				if(newfile.exists()){//如果新目录存在此文件
					newfile.delete();	//删掉
				}
				
				FileUtils.copyFile(oldfile, newfile);  //copy到新目录
				if (log.isDebugEnabled()) {
					log.debug("文件（" + filename + "）已从目录（" + oldpath + "）移到了目录（" + newpath + "）！");
				}
				boolean isDel = false;
				if(oldfile.exists()){	//删除掉原目录下的文件
					isDel=oldfile.delete();
				}
				return isDel;
				
			}else{
				throw new Exception("指定文件转移目录与现目录一样！");
			}
		} catch (Exception e) {
			log.info("文件转移异常-->"+e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inFullFileName= "d:\\VirtualMachinesa.rar";
	/*	System.out.println(BaseFileUtil.changeSuffix(inFullFileName, ".temp"));
		System.out.println(BaseFileUtil.changeSuffix(inFullFileName, "temp"));
		System.out.println(BaseFileUtil.changeSuffix(inFullFileName, ""));
		System.out.println(BaseFileUtil.changeSuffix(inFullFileName, null));*/
		 
		System.out.println(BaseFileUtil.getZHFileSize("d:\\VirtualMachinesa.rar")); 
		System.out.println(BaseFileUtil.getZHFileSize("d:\\jdk864.rar")); 
		System.out.println(BaseFileUtil.getZHFileSize("d:\\sunshine_data.sql")); 
		System.out.println(BaseFileUtil.getZHFileSize("d:\\1.txt")); 
	}
	
}


