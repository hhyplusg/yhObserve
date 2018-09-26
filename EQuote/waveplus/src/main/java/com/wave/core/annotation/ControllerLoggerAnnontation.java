package com.wave.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 *自定义注解 拦截Controller  
 */    
    
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface ControllerLoggerAnnontation {    
    /**
     * 日志描述，如果需要动态对其传值时，对应站位用“{}”，多个是，多个值时用多个“{}”。将多个值用逗号分割放到sesseion中。如：request.getSession().setAttribute(Constants.LOG_DESCRIPTION_VALUE, "aa,bb");
     * eg. 用户{}登陆{}
     * */
    String description()  default "";    
    /**
     * 操作日志是否存到数据库，默认需要
     * */
    boolean isSaveToDb() default  true;
    
    
}    
   