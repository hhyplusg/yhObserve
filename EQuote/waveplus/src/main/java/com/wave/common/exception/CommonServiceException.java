package com.wave.common.exception;

import com.wave.base.exception.BaseException;
import com.wave.base.exception.DaoException;
import com.wave.core.util.ClassUtil;

@SuppressWarnings("serial")
public class CommonServiceException extends BaseException{  
	public CommonServiceException(String message) {
		super(message);
	}
	
	public CommonServiceException(String message,Exception e) {
		super(message, e.getCause());		
		log.error("捕获ServiceException:");
		log.error("异常信息：" + message);
		log.error("异常原因：" + e.getCause());
	}
	
	public CommonServiceException(DaoException e){
		super(e.getMessage(), e.getCause(),e.getSource(),e.getSeverity());
		this.setSource(e.getSource());
		this.setSeverity(e.getSeverity());
	}
	
	public CommonServiceException(String message,DaoException e){
		super(message, e.getCause(),e.getSource(),e.getSeverity());
		this.setSource(e.getSource());
		this.setSeverity(e.getSeverity());
	}
	public CommonServiceException(String message, int source, int severity) {
		super(message);
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n").append("捕获ServiceException异常");
		buffer.append("\n").append("异常来源：" + ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SOURCE_"+source));
		buffer.append("\n").append("异常级别："+ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SEVERITY_"+severity));
		buffer.append("\n").append("异常信息：" + message);
		
		this.setSource(source);
		this.setSeverity(severity); 
	}
	
	public CommonServiceException(String message,Exception e, int source, int severity) {
		super(message, e.getCause(), source,severity);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n").append("捕获ServiceException异常");
		buffer.append("\n").append("异常来源：" + ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SOURCE_"+source));
		buffer.append("\n").append("异常级别："+ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SEVERITY_"+severity));
		buffer.append("\n").append("异常信息：" + message);
		buffer.append("\n").append("异常原因：" + e);
		log.error(buffer.toString(),e);
		
		this.setSource(source);
		this.setSeverity(severity);
		 
	}
	
	public CommonServiceException(Exception e, int source, int severity) {
		super(e.getMessage(), e.getCause(), source,severity);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n").append("捕获ServiceException异常");
		buffer.append("\n").append("异常来源：" + ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SOURCE_"+source));
		buffer.append("\n").append("异常级别："+ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SEVERITY_"+severity));
		buffer.append("\n").append("异常信息：" + e.getMessage());
		buffer.append("\n").append("异常原因：" + e);
		log.error(buffer.toString(),e);
		
		this.setSource(source);
		this.setSeverity(severity); 
	}
}
