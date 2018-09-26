package com.wave.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wave.base.vo.entity.Syscorpinfor;

public class LoginInterceptor implements  HandlerInterceptor {


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//log.info("==============执行顺序: 1、preHandle================");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		if (url.contains("/login") || url.contains("/loginOut") || url.contains("/checkUserLoginNameIsExist")) {
			return true;
		} else {
			Syscorpinfor syscorpinfor = (Syscorpinfor) request.getSession().getAttribute("userInfo");
			if (syscorpinfor == null) {
				//log.info("Interceptor：跳转到login页面！");
				return false;
			} else if("1".equals(syscorpinfor.getCorptype())){
						if((url.contains("/equote") || url.contains("/syscorpinforManager/showCollectionList")
								|| url.contains("/inquiry/showInquiryList"))){
							return true;
						}else{
							return false;
						}
			} else if("2".equals(syscorpinfor.getCorptype())){
				if((url.contains("/inquiry") || url.contains("/syscorpinforManager/showBankList")
						|| url.contains("/inquiry/showBankList") || url.contains("/equote/equoteM"))
						||url.contains("/insertByCorp")){
					return true;
				}else{
					return false;
				}
			} else if("3".equals(syscorpinfor.getCorptype()) && url.contains("/syscorpinforManager")
					&& !url.contains("/syscorpinforManager/showBankList")
					&& !url.contains("/syscorpinforManager/showCollectionList")
					){
				return true;
			}else{
				return false;
			}
		}
	}
	
}
