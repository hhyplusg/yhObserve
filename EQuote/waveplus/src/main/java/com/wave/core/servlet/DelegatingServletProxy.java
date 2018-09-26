package com.wave.core.servlet;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DelegatingServletProxy extends GenericServlet {
    /**
	 * serialVersionUID = -6146877514841892322L;
	 */
	private static final long serialVersionUID = -6146877514841892322L;
	private String targetBean;
    private Servlet proxy;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        proxy.service(req, res);
    }
    
    @Override
    public void init() throws ServletException {
        this.targetBean = getServletName();
        getServletBean();
        proxy.init(getServletConfig());
    }

    private void getServletBean() {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.proxy = (Servlet) wac.getBean(targetBean);
    }
}