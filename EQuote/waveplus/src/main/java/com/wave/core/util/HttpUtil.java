package com.wave.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wave.base.constant.ErrorConstants;
import com.wave.base.exception.ServiceException;
import com.wave.user.vo.SUserVo;

public class HttpUtil{
    public transient static final Logger log = LogManager.getLogger(HttpUtil.class);
    
    /**
     * 取得当前用户下的Request
     * */
    public static HttpServletRequest getRequest() {
        return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
    }
    
    /**
     * 取得当前用户下的Session
     * */
    public static HttpSession getSession() {
        return getRequest().getSession(true); 
    }
    
    /**
     * 取得当前用户下的Session
     * */
    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession(true); 
    }
    
    /**
     * 取得Session中当前用户信息
     * */
    public static SUserVo getUserInfo() { 
        SUserVo user = (SUserVo) getSession().getAttribute("sUserVo");  
        return user; 
    }
    
    public static SUserVo getUserInfo(HttpServletRequest request) { 
        SUserVo user = (SUserVo) request.getSession(true).getAttribute("sUserVo");  
        return user; 
    }
    
    public static SUserVo getUserInfo(HttpSession session) { 
        SUserVo user = (SUserVo) session.getAttribute("sUserVo");  
        return user; 
    }
    /**
     * 获取客户端IP信息
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址; 
     * 
     * 在Servlet里，获取客户端的IP地址的方法是：request.getRemoteAddr()，这种方法在大部分情况下都是有效的。
     * 但是在通过了Apache，Squid，Nginx等反向代理软件就不能获取到客户端的真实IP地址了。
     * 如果使用了反向代理软件，例如将http://192.168.101.88:80/ 的URL反向代理为http://pay.kedou.com/ 的URL时，
     * 用request.getRemoteAddr()方法获取的IP地址是：127.0.0.1　或192.168.101.88，而并不是客户端的真实IP。
     * ClientA
     *    | *
     *    |   *
     *    |     *
     *    |       *
     *    |         *
     * ProxyB-------ServerC
     * 如上图，原来是client端直接请求服务端，走A路线请求，这时候通过request.getRemoteAddr()方法可以准备的获取客户端的IP。
     * 但是做了代理之后呢，client端不是直接请求服务端，而是走B线路请求代理服务器，由代理器去请求服务端，
     * 这时候服务端通过request.getRemoteAddr()方法拿到的理所当然是代理服务器的地址了。
     * 
     * 经过代理以后，由于在客户端和服务之间增加了中间层，因此服务器无法直接拿到客户端的IP，
     * 服务器端应用也无法直接通过转发请求的地址返回给客户端。但是在转发请求的HTTP头信息中，增加了X－FORWARDED－FOR信息。
     * 用以跟踪原有的客户端IP地址和原来客户端请求的服务器地址。当我们访问http://www.xxx.com/index.jsp/ 时，
     * 其实并不是我们浏览器真正访问到了服务器上的index.jsp文件，而是先由代理服务器去访问http://192.168.1.110:2046/index.jsp ，
     * 代理服务器再将访问到的结果返回给我们的浏览器，因为是代理服务器去访问index.jsp的，所以index.jsp中通过request.getRemoteAddr()的方法获取的IP实际上是代理服务器的地址，
     * 并不是客户端的IP地址。
     * */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtil.isNull(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            if(StringUtil.isNull(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if(StringUtil.isNull(ip) || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("HTTP_CLIENT_IP");
                    if(StringUtil.isNull(ip) || "unknown".equalsIgnoreCase(ip)) {
                        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                        if(StringUtil.isNull(ip) || "unknown".equalsIgnoreCase(ip)) {
                            ip = request.getRemoteAddr();
                            if(!StringUtil.isNotNull(ip)) {
                                ip = "0.0.0.0";  
                            } 
                        }
                    } 
                    
                }
            } else {
                String[] ips = ip.split(",");  
                for (int index = 0; index < ips.length; index++) {  
                    String strIp = (String) ips[index];  
                    if (!("unknown".equalsIgnoreCase(strIp))) {  
                        ip = strIp;  
                        break;  
                    }  
                } 
            }
        }  
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
   }
    public static String getIpAddr() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return getIpAddr(request);
    }
    /* (non-Javadoc)
     * @see com.hoosen.base.service.impl.BaseService#getParameter(javax.servlet.http.HttpServletRequest, java.lang.String)
     */
    public static String getParameter(HttpServletRequest request,String name) throws ServiceException{
        String strResult = null;
        try{
            if (log.isDebugEnabled()) {
                log.debug("getParameter() start");
                log.debug("name:" + name);
            }
            //判断name为""或者为null
            if (StringUtil.isEmpty(name)) {
                return strResult;
            }
            strResult = request.getParameter(name).trim();
            log.debug("结果：" + strResult);
        }catch(Exception e){
            log.error("转换" + name + "编码格式错误", e);
            throw new ServiceException("转换" + name + "编码格式错误", e,
                    ErrorConstants.EXCEPTION_SOURCE_USER,
                    ErrorConstants.EXCEPTION_SEVERITY_HIGH);
        }finally{
            log.debug("getParameter() end");
        }
        return strResult;
    }
    
    public static String getAttribute(HttpServletRequest request,String name) throws ServiceException{
        String strAttribute = "";
        try{
            if (log.isDebugEnabled()) {
                log.debug("getAttribute() start");
                log.debug("name:" + name);
            }
            //判断name为""或者为null
            if (StringUtil.isEmpty(name)) {
                return strAttribute;
            } 
            Object objectAttribute = request.getSession(true).getAttribute(name);
            if (objectAttribute != null) {
                strAttribute = objectAttribute.toString();
            }  
            log.debug("结果：" + strAttribute);
        }catch(Exception e){
            log.error("转换" + name + "编码格式错误", e);
            throw new ServiceException("转换" + name + "编码格式错误", e,
                    ErrorConstants.EXCEPTION_SOURCE_USER,
                    ErrorConstants.EXCEPTION_SEVERITY_HIGH);
        }finally{
            log.debug("getAttribute() end");
        }
        return strAttribute;
    }
    public static String getParameter(String name) throws ServiceException{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return getParameter(request,name);
    }
}
