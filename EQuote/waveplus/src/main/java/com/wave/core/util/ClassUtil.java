package com.wave.core.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
@SuppressWarnings("unchecked")
public class ClassUtil {
	/** common logger */
    protected transient static final  Logger log = LogManager.getLogger(ClassUtil.class); 
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/*HashMap parameterObj = new HashMap();
		parameterObj.put("dd", "asdf");
		ClassUtil.invokeMethod("com.amc.base.util.ClassUtil", "testThis", parameterObj);*/
	}

	public Object testThis(HashMap<String,Object> hm) {
		System.out.println("hm:" + hm);
		return hm;
	}


	/**
	 * @param methodObject
	 *            方法所在的对象
	 * @param methodName
	 *            方法名
	 * @param hm
	 *            方法名参数
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Object invokeMethod(Object methodObject, String methodName,Object obj) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
 
			Class<? extends Object> ownerClass = methodObject.getClass();
			Method method = null;
			if (obj != null) {
				method = ownerClass.getMethod(methodName, obj.getClass());
				return method.invoke(methodObject, obj);
			} else {
				method = ownerClass.getMethod(methodName);
				return method.invoke(methodObject);
			}
		 
		
	}
	
	/**
	 * @param methodObject
	 *            方法所在的对象
	 * @param methodName
	 *            方法名
	 * @param hm
	 *            方法名参数
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */  
	public static Object invokeMethod(Object methodObject, String methodName,Object[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
 
			Class<? extends Object> ownerClass = methodObject.getClass();
			Class<? extends Object>[] argsClass = null;
			Method method = null;
			Object resultObject = null;
			if (args != null){
				argsClass = new Class[args.length];  
				for (int i = 0, j = args.length; i < j; i++) {
					if (args[i] instanceof HttpServletRequest){
						argsClass[i] = HttpServletRequest.class;
					}else if (args[i] instanceof HttpServletResponse){
						argsClass[i] = HttpServletResponse.class;
					} else {
						argsClass[i] = args[i].getClass();
					}  
				} 
				method = ownerClass.getMethod(methodName,argsClass);
				resultObject = method.invoke(methodObject, args);
			} else {
				method = ownerClass.getMethod(methodName);
				resultObject = method.invoke(methodObject);
			} 
			return resultObject;
			
	}
	
	/**
	 * 获取Class类中常量的值 static final 变量
	 * @param className 字符形式class类路径和类名称
	 * @param constantName 常量名称
	 * @return constantsObj
	 */
	public static Object invokeConstant(String className,String constantName){
		Object object = null;
		Object constantsObj = null;
		try {
			object = Class.forName(className).newInstance();
			constantsObj = object.getClass().getField(constantName).get(null);
		} catch (InstantiationException e) {
			log .error("未能正常实例化类："+className,e);
		} catch (IllegalAccessException e) {
			log.error("类"+className+"未继承合理的类，所以实例化该类未能成功",e);
		} catch (ClassNotFoundException e) {
			log.error("系统找不到相应的类："+className,e);
		} catch (NoSuchFieldException e) {
			log.error("系统找不到相应的常量："+constantName,e);
		} 
		return constantsObj;
	}
}
