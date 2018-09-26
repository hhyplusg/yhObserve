package com.wave.core.Interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wave.base.action.ClientDatatModel;
import com.wave.base.constant.BaseConstants;
import com.wave.common.cnstants.Constants;
import com.wave.core.annotation.RepetitionSubmitAnnotation;
import com.wave.core.util.ConfigUtil;
import com.wave.core.util.StringUtil;
import com.wave.core.util.UUIDUtils;
import com.wave.sysmanage.dao.SRoleMapper;
import com.wave.sysmanage.dao.SRoleUserMapper;
import com.wave.sysmanage.vo.SRoleUserVo;
import com.wave.sysmanage.vo.SRoleVo;
import com.wave.user.vo.SUserVo;

public class CustomInterceptor extends HandlerInterceptorAdapter {
	@Resource(name="SRoleUserMapper")
	private SRoleUserMapper sRoleUserMapper;
	
	@Resource(name="SRoleMapper")
	private SRoleMapper sRoleMapper;

	private final Logger log = LogManager.getLogger(this.getClass());
	//登陆和登陆验证不需要拦截
	private static final String LOGIN  = ConfigUtil.getString("LOGIN");
	private static final String LOGOUT  = ConfigUtil.getString("LOGOUT");
	private static final String WEB_ROOT  = ConfigUtil.getString("WEB_ROOT");
	private static final String ROLE_ADMIN=ConfigUtil.getString("ROLE_ADMIN");
	
	// 登陆和登陆验证不需要拦截
	private static final Set<String> noMappingSet = new HashSet<String>();
	static {
			noMappingSet.add("/dzht/app/dzht/");
			noMappingSet.add("/dzht/app/lib/");
			noMappingSet.add("/dzht/getShipDataInfo");
			noMappingSet.add("/dzht/getShipDataInfoByShipInfo");
			noMappingSet.add("/dzht/getShipDataInfoByShipInfoList");
			noMappingSet.add("/dzht/getShipCountrysOrTypes/");
			noMappingSet.add("/dzht/getcurrentloguser");
		}
	 
 
	/** 
	 * Controller之前执行
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     *  
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception { 
        log.debug("request url:" + request.getRequestURI());
        response.setCharacterEncoding("UTF-8");  
    	ClientDatatModel<SUserVo> ClientDatatModel = new ClientDatatModel<>();
    	String url = request.getRequestURI();
		// 登陆页面与登陆验证页面不需要做session验证。
        if(url.indexOf(LOGIN) > -1 || url.indexOf(LOGOUT) > -1 || url.indexOf("page_signin") > -1 || request.getServletPath().startsWith("/index") || url.indexOf("/app/") > -1 || url.indexOf("getDictListBytypes") > -1 || url.endsWith(WEB_ROOT)){
           /* log.debug("request url:" + request.getRequestURI());
            log.debug("不需要拦截");*/
            return true;   
        }  
		SUserVo sysUser = (SUserVo) request.getSession(true).getAttribute("sUserVo");
		// 如果session中没有用户信息，说明用户没有登陆，则跳转到用户登陆页面。
		if(sysUser == null){ 
			ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
			ClientDatatModel.setMsg("未登录");
			PrintWriter out = response.getWriter();
			out.print(JSONObject.fromObject(ClientDatatModel).toString());  
			out.close();
        	return false;   
		}
		
		//请求的页面是后台管理页面
		/*if(!noMappingSet.contains(url)){
			//根据用户登录名查询用户角色
			List<SRoleUserVo> listRoleUser = sRoleUserMapper.selectByExport(sysUser.getUserLonginName());
			SRoleVo sRoleVo;
			boolean flagRoleUser=false;
			//判断用户角色是否包含管理员角色
		    if(listRoleUser!=null && listRoleUser.size()>0){
		    	for (SRoleUserVo sRoleUserVo : listRoleUser) {
		    		sRoleVo=sRoleMapper.selectByPrimaryKey(sRoleUserVo.getRoleId());
					if(sRoleVo!=null && ROLE_ADMIN.equalsIgnoreCase(sRoleVo.getRoleName())){
						flagRoleUser=true;
						break;
					}
				}
		    }
		    //如果不是管理员角色输出未登录
			if(flagRoleUser == false){
				ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
				ClientDatatModel.setMsg("未登录");
				PrintWriter out = response.getWriter();
				out.print(JSONObject.fromObject(ClientDatatModel).toString());  
				out.close();
	        	return false;   
			}
		}*/
		
		if (handler instanceof HandlerMethod) {
            HttpSession session = request.getSession();
            if (session != null) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Method method = handlerMethod.getMethod();
                // 获得重复提交的注解
                RepetitionSubmitAnnotation annotation = method.getAnnotation(RepetitionSubmitAnnotation.class);
                if (annotation != null) {
                    boolean needSaveSession = annotation.needSaveToken();
                    if (needSaveSession) {
                        request.getSession(false).setAttribute(BaseConstants.TOKEN_NAME, UUIDUtils.getUUID());
                    }
                    // 如果注解要求清空token，则做token清空处理
                    boolean needRemoveSession = annotation.needRemoveToken();
                    if (needRemoveSession) {
                        if (isRepeatSubmit(request)) {
                            SUserVo userVo = (SUserVo)session.getAttribute("sUserVo");
                            log.debug("please don't repeat submit,[user:" + userVo.getUserName() + ",url:"  + request.getServletPath() + "]");
                            return false;
                        }
                        request.getSession(false).removeAttribute(BaseConstants.TOKEN_NAME);
                    }
                }
            }
        }
        return true;  
	}
	
	  //在业务处理器处理请求执行完成后,生成视图之前执行的动作   
    @Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {   
    }  
  
    /** 
     * 在DispatcherServlet完全处理完请求后被调用  
     *  
     *   当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */  
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {    
    	String url = request.getRequestURI();
    	 if(url.indexOf("LOGOUT") > -1){ 
             return ;   
         }  
    	 
    	if (handler instanceof HandlerMethod) {
            HttpSession session = request.getSession();
            if (session != null) { 
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Method method = handlerMethod.getMethod();
                RepetitionSubmitAnnotation annotation = method.getAnnotation(RepetitionSubmitAnnotation.class);
                if (annotation != null) {
                    boolean needRemoveSession = annotation.needRemoveToken();
                    // 如果执行前清空了token,则执行后返回新的token
                    if (needRemoveSession) {
                        String newToken = UUIDUtils.getUUID();
                        // 保留新的token
                        request.getSession(false).setAttribute(BaseConstants.TOKEN_NAME, newToken);
                        // 返回新的token 
                        Cookie cookie = new Cookie(BaseConstants.TOKEN_NAME,newToken);  
                        response.addCookie(cookie); 
                         
                    }
                }
            }
        } 
    }  
    
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute(BaseConstants.TOKEN_NAME); 
        if (StringUtil.isNull(serverToken)) {
            return true;
        }
        String clinetToken = request.getParameter(BaseConstants.TOKEN_NAME);
        if (StringUtil.isNull(clinetToken)) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }

}
