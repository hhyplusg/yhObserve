package com.wave.core.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 过滤Url非法字符 
 * 
 * @author sdh
 */
public class UrlFilter implements Filter { 
 
	private static String WEB_XML_URL ;

	private static String FORWARD ; 
	/**
	 * Url过滤 
	 * @param request
	 * @return true合法 false非法
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> UrlFile(HttpServletRequest request) { 
		Map rsMap = new HashMap();
		// 转义字符
		String web_xml[] = WEB_XML_URL.split("\\#");
		StringBuffer str;
		String st[];
		StringBuffer keyName;
		Enumeration enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			keyName = new StringBuffer((String) enu.nextElement());
			if (request.getParameter(keyName.toString())!= null) {
				str = new StringBuffer(request.getParameter(keyName.toString()));
				for (int i1 = 0; i1 < web_xml.length; i1++) {
					String paramValue=str.toString();
					if(paramValue!=null){
						paramValue=paramValue.toUpperCase();
						String value=web_xml[i1].toUpperCase();
						if(paramValue.indexOf(value)!=-1){ 
							rsMap.put("falg","false");
							rsMap.put("msg", value);
							return rsMap;
						}
					}
				}

			} if (request.getParameterValues(keyName.toString())!= null) {
				st = request.getParameterValues(keyName.toString());
				for (int i = 0; i < st.length; i++) {
					for (int j = 0; j < web_xml.length; j++) {
						String paramVal=st[i];
						if(st[i]!=null){
							paramVal=paramVal.toUpperCase();
							String val=web_xml[j].toUpperCase();
							if(paramVal.indexOf(val)!=-1){
								rsMap.put("falg","false");
								rsMap.put("msg", val);
								return rsMap;
							}
						}
					}
				}

			}
		}
		rsMap.put("falg","true");
		rsMap.put("msg", "no");
		return rsMap;
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		Map<String, String> reMap = UrlFilter.UrlFile((HttpServletRequest) request);
		String booleanStr = reMap.get("falg");
		Boolean boo = Boolean.valueOf(booleanStr);
		if (boo == false) {
			//request.getRequestDispatcher(UrlFilter.FORWARD).forward(request, response);
			String msg = reMap.get("msg");  
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		UrlFilter.WEB_XML_URL = filterConfig.getInitParameter("sql");
		UrlFilter.FORWARD = filterConfig.getInitParameter("forward");
	}

}
