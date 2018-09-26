package com.wave.core.aspect;  
    
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.util.JSONUtils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.wave.common.cnstants.Constants;
import com.wave.core.annotation.ControllerLoggerAnnontation;
import com.wave.core.annotation.ServiceLoggerAnnotation;
import com.wave.core.util.ConfigUtil;
import com.wave.core.util.HttpUtil;
import com.wave.core.util.StringUtil;
import com.wave.core.util.UUIDUtils;
import com.wave.sysmanage.service.SOperationLogsInfoService;
import com.wave.sysmanage.vo.SOperationLogsInfoVo;
import com.wave.user.vo.SUserVo;
  
/** 
 * 切点类 
 * @author
 * @version 1.0 
 */  
@Aspect
@Component
public  class LoggerAspect {  
    @Autowired
    ThreadPoolTaskExecutor threadPoolExecutor;
    //注入Service用于把日志保存数据库  
    @Autowired
    SOperationLogsInfoService iSOperationLogsInfoService;
    //本地异常日志记录对象  
    protected transient final Logger log = LogManager.getLogger(LoggerAspect.class);
  
    //Service层切点  
    @Pointcut("@annotation(com.wave.core.annotation.ServiceLoggerAnnotation)")  
     public  void serviceAspect() {  
    }  
  
    //Controller层切点  
    @Pointcut("@annotation(com.wave.core.annotation.ControllerLoggerAnnontation)")  
     public  void controllerAspect() {  
    }  
  
    /** 
     * 前置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */  
    @Before("controllerAspect()")  
     public  void doBefore(JoinPoint joinPoint) {  
      //获取用户请求方法的参数并序列化为JSON格式字符串  
        log.debug("请求方法:" + getMethodFullName(joinPoint)  + "() is start");  
        log.debug("请求参数:" + getMethodArgs(joinPoint));
        log.debug("方法描述:" + getControllerMethodDescription(joinPoint));  
    }
  
    /** 
     * 后置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */  
    @After("controllerAspect()")  
     public  void doAfter(JoinPoint joinPoint) {
        //========数据库日志========= 
      //  if (!"login".equals(joinPoint.getSignature().getName())) {  
            saveLog(joinPoint,Constants.S_OPT_LOGS_TYPE_OPT);
       // }
        log.debug("请求方法:" + (getMethodFullName(joinPoint) + "() is end"));  
    }
   
    /** 
     * 异常通知 用于拦截service层记录异常日志 
     * 
     * @param joinPoint 
     * @param e 
     */  
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")  
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {  
        //获取用户请求方法的参数并序列化为JSON格式字符串  
        String params = getMethodArgs(joinPoint);  
         try {  
              /*========控制台输出=========*/  
            log.debug("=====异常通知开始=====");  
            log.debug("异常代码:" + e.getClass().getName());  
            log.debug("异常信息:" + e.getMessage());  
            log.debug("异常方法:" + this.getMethodFullName(joinPoint));  
            log.debug("请求参数:" + getMethodArgs(joinPoint));
            log.debug("方法描述:" + getServiceMthodDescription(joinPoint));  
            log.debug("请求参数:" + params);  
               /*==========数据库日志=========*/  
            // 登陆时出现的异常不能用此方法保存异常信息到数据
            if (!"login".equals(joinPoint.getSignature().getName())) {   
                saveLog(joinPoint,Constants.S_OPT_LOGS_TYPE_EXCEPTION);
            }
        }  catch (Exception ex) {  
            //记录本地异常日志  
            log.error("异常信息:{}", ex.getMessage());  
        }  
         /*==========记录本地异常日志==========*/  
        log.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", getMethodFullName(joinPoint), e.getClass().getName(), e.getMessage(), params);  
  
    }  
  
  
    /** 
     * 获取注解中对方法的描述信息 用于service层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */  
     public  static String getServiceMthodDescription(JoinPoint joinPoint)  
             throws Exception {  
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        Class<?> targetClass = Class.forName(targetName);  
        Method[] methods = targetClass.getMethods();  
        String description = "";  
         for (Method method : methods) {  
             if (method.getName().equals(methodName)) {  
                Class[] clazzs = method.getParameterTypes();  
                 if (clazzs.length == arguments.length) {  
                    description = method.getAnnotation(ServiceLoggerAnnotation.class).description(); 
                     break;  
                }  
            }  
        }  
         return description;  
    }  
  
    /** 
     * 获取注解中对方法的描述信息 用于Controller层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */  
     public String getControllerMethodDescription(JoinPoint joinPoint)  {  
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        String description = "";
        try {
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        description = method.getAnnotation(ControllerLoggerAnnontation.class).description();
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            return description;
        } 
         return description;  
    }  
     
     /** 
      * 获取注解中对方法的日志是否存入数据标识 用于Controller层注解 
      * 
      * @param joinPoint 切点 
      * @return 方法描述 
      * @throws Exception 
      */  
      public boolean getControllerLogIsSaveToDb(JoinPoint joinPoint)  {  
         String targetName = joinPoint.getTarget().getClass().getName();  
         String methodName = joinPoint.getSignature().getName();  
         Object[] arguments = joinPoint.getArgs();  
         boolean isSaveToDb = false;
         try {
             Class targetClass = Class.forName(targetName);
             Method[] methods = targetClass.getMethods();
             for (Method method : methods) {
                 if (method.getName().equals(methodName)) {
                     Class[] clazzs = method.getParameterTypes();
                     if (clazzs.length == arguments.length) {
                    	 isSaveToDb = method.getAnnotation(ControllerLoggerAnnontation.class).isSaveToDb();
                         break;
                     }
                 }
             }
         } catch (ClassNotFoundException e) {
             return isSaveToDb;
         } 
          return isSaveToDb;  
     }  
     
     /**
      * 取得参数JSON
      * */
     private String getMethodArgs(JoinPoint joinPoint) {
         if (ArrayUtils.isEmpty(joinPoint.getArgs())) {
             return "";
         }
         StringBuffer params = new StringBuffer();
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
              for ( int i = 0; i < joinPoint.getArgs().length; i++) {  
                  params.append(JSONUtils.valueToString(joinPoint.getArgs()[i])).append(";");  
             } 
         }
         return params.toString();
     }  
     
     /**
      * 取得方法全名
      * */
     private String getMethodFullName(JoinPoint joinPoint) {
         return joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
     }
     /**
      * 取得方法名
      * */
     private String getMethod(JoinPoint joinPoint) {
         return joinPoint.getSignature().getName();
     }
     
     /**
      * 取得类名
      * */
     private String getclass(JoinPoint joinPoint) {
         return joinPoint.getTarget().getClass().getName();
     }
     
     /**
      * 保存操作日志到数据库
      * */
     private void saveLog(JoinPoint joinPoint,String logType) {
      // 获取httpRequest
         HttpServletRequest request = HttpUtil.getRequest();  
         //读取session中的用户  
         SUserVo user = HttpUtil.getUserInfo(request);  
         // 取得日志描述
         String description = getControllerMethodDescription(joinPoint);
         
         boolean isSaveToDb = this.getControllerLogIsSaveToDb(joinPoint);
         
         if (!isSaveToDb) {
        	 return;
         }
         // 将日志描述中的"{}"替换为对应的值  descriptionValue=“aa,bb”
         // 如“用户{}登陆{}”替换后为：“用户aa登陆bb”
         if (description.indexOf(Constants.DOUBLE_BRACE) > 0) {
             String descriptionValue = HttpUtil.getAttribute(request, Constants.LOG_DESCRIPTION_VALUE);
             String[] descriptionValues = descriptionValue.split(Constants.DBC_CASE_COMMA);
             for (int i = 0; i < descriptionValues.length; i++) {
                 description = description.replace(Constants.DOUBLE_BRACE, descriptionValues[i]);
            } 
         }
         SOperationLogsInfoVo logVo = new SOperationLogsInfoVo();
         logVo.setId(UUIDUtils.getUUID());
         logVo.setUserName(user.getUserId());
         logVo.setUserIp(HttpUtil.getIpAddr(request));
         logVo.setBizName(ConfigUtil.getString(ConfigUtil.LOG_INFO,getclass(joinPoint)));
         logVo.setOptFunctionName(ConfigUtil.getString(ConfigUtil.LOG_INFO,getMethodFullName(joinPoint)));
         logVo.setOptInfo(description);
         logVo.setLogType(logType); 
         request.removeAttribute(description);
         Thread thread = new Thread() {
             public void run() {
                 //保存数据库  
                 iSOperationLogsInfoService.addOperationLogs(logVo);
             }  
         };
         threadPoolExecutor.execute(thread);
     }
      

}  