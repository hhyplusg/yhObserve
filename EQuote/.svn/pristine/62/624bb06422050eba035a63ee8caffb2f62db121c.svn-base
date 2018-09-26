package com.wave.core.servlet;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wave.base.exception.ActionException;
import com.wave.core.util.ClassUtil;
import com.wave.core.util.StringUtil;


public class CoreServlet  extends HttpServlet {
	/**
     * common logger
     */
    protected transient final Logger log = LogManager.getLogger(getClass()); 
	private WebApplicationContext wac ;
	 /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * */
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp){
		if (wac == null) {
			wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		} 
		String bean = req.getParameter("bean");
		String action = req.getParameter("action");
		try {
			bean = req.getParameter("bean");
			action = req.getParameter("action");
			if (StringUtil.isEmpty(bean)) { 
				throw new  ActionException("缺少bean参数!");
			} else if (StringUtil.isEmpty(action)) { 
				throw new  ActionException("缺少action参数!");
			}
			 
			Object obj = (Object) wac.getBean(bean);
			if (obj == null) {
				throw new  ActionException("调用了没有经过定义的bean!");
			} 
			Object returnObject = ClassUtil.invokeMethod(obj, action,new Object[]{(HttpServletRequest)req, (HttpServletResponse) resp});
			if(returnObject != null) {
				getServletContext().getRequestDispatcher(String.valueOf(returnObject)).forward(req, resp);
			}
			log.debug("returnObject=" + returnObject );
		} catch (ActionException e) {
			log.error("出错了！",e);
		} catch (NoSuchBeanDefinitionException e) {
			log.error("调用的bean" + bean + "不存在或未定义！",e);
		} catch (NoSuchMethodException e) {
			log.error("调用的方法“"+ action + "()”不存在！",e);
		} catch (InvocationTargetException e) {
			log.error("出现错误！请重试！",e);
		} catch (Exception e) {
			log.error("出现未知错误！请重试！",e);
		} 
	}
 
    
}
