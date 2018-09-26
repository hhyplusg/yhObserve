package com.wave.base.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
 
	/** common logger */ 
    protected transient final Logger log = LogManager.getLogger(getClass()); 
	/**
	 * 异常类名称
	 */
	public final String ErrorConstantsPath = "com.wave.base.constant.ErrorConstants";
	/**
	 * 异常类名称
	 */
	private  String exceptionClassName;

	
	/**
	 * 异常来源
	 */
	private int source;
	
	/**
	 * 异常严重度
	 */
	private int severity;	
	

	Throwable cause = null;
	
	public BaseException() {
		super();
	}
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(Throwable cause) {
		super(cause.getMessage());
		this.cause = cause;
	}

	public BaseException(String message, Throwable cause) {
		super(message,cause);
		this.cause = cause;
	}
	
	public BaseException(String message, Throwable cause, int source, int severity) {
		super(message,cause);
		this.cause = cause;		
		this.severity = severity;
		this.source = source;
	}
	

	public Throwable getReason() {
		return cause;
	}		

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public String getExceptionClassName() {
		return exceptionClassName;
	}

	public void setExceptionClassName(String exceptionClassName) {
		this.exceptionClassName = exceptionClassName; 
	}
	
}