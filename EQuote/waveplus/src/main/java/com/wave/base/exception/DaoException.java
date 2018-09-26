package com.wave.base.exception;

import com.wave.core.util.ClassUtil;

@SuppressWarnings("serial")
public class DaoException extends BaseException{ 
	
	public DaoException(Exception e,int source, int severity) {
		super(e.getMessage(), e.getCause(), source,severity);
		log.error("捕获DaoException, 异常来源：" + ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SOURCE_"+source) + ",异常级别："+ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SEVERITY_"+severity));
		log.error("异常信息：" + e.getMessage());
		log.error("异常原因：" + e.getCause());
		this.setSource(source);
		this.setSeverity(severity);
	}
	
	public DaoException(String msg, Exception e,int source, int severity) {
		super(msg, e, source, severity);
		
		log.error("捕获DaoException, 异常来源：" + ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SOURCE_"+source) + ",异常级别："+ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SEVERITY_"+severity));
		log.error("异常信息：" + msg);
		log.error("异常原因：" + e.getCause());
		
		this.setSource(source);
		this.setSeverity(severity);
	}
	
	public DaoException(String msg,int source, int severity) {
		super(msg);
		
		log.error("捕获DaoException, 异常来源：" + ClassUtil.invokeConstant(ErrorConstantsPath,"EXCEPTION_SOURCE_"+source) + ",异常级别："+ClassUtil.invokeConstant("com.hoosen.base.constant.constant.ErrorConstants","EXCEPTION_SEVERITY_"+severity));
		log.error("异常信息：" + msg);
		
		this.setSource(source);
		this.setSeverity(severity);
	}

}
