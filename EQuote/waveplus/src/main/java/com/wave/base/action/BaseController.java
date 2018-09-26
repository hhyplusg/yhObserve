package com.wave.base.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.wave.base.constant.ErrorConstants;
import com.wave.base.exception.ExceptionsHandler;
import com.wave.base.exception.ServiceException;
import com.wave.common.cnstants.Constants;
import com.wave.common.cnstants.ModulesConstants;
import com.wave.common.exception.SessionOverdueException;
import com.wave.core.util.HttpUtil;
import com.wave.core.util.UUIDUtils;
import com.wave.sysmanage.service.SOperationLogsInfoService;
import com.wave.sysmanage.vo.SOperationLogsInfoVo;
import com.wave.user.vo.SUserVo;
@Component
public class BaseController {
    protected transient final Logger log = LogManager.getLogger(getClass()); 
    @Autowired
    ExceptionsHandler exceptionsHandler;
    @Autowired
    SOperationLogsInfoService iSOperationLogsInfoService;
    
    @Autowired
    ThreadPoolTaskExecutor threadPoolExecutor;
     
    /**
     *  添加操作日志
     * @param request session中用户相关信息（IP,用户ID）
     * @param bizName 业务模块名称
     * @param optFunctionName 操作工作名称
     * @param optInfo 操作内容
     */
    public void addOpertationLogs(HttpServletRequest request,String bizName, String optFunctionName,String optInfo) {
        Thread thread = new Thread() {
            public void run() {
                /* 
                 * 添加操作日志
                 * SOperationLogsInfoVo构造函数
                 * @param id UUID
                 * @param userName 用户名称
                 * @param userIp 用户IP
                 * @param bizName 业务模块名称
                 * @param optFunctionName 操作工作名称
                 * @param logType 日志类型 O：操作日志 S:系统日志
                 * @param optInfo 操作内容 
                 */
                SOperationLogsInfoVo sOperationLogsInfoVo = new SOperationLogsInfoVo(UUIDUtils.getUUID(),
                        getSUserVo(request).getUserId(),
                        getIpAddr(request),
                        bizName,
                        optFunctionName,
                        Constants.S_OPT_LOGS_TYPE_OPT,    
                        optInfo
                        );
                  iSOperationLogsInfoService.addOperationLogs(sOperationLogsInfoVo);
            }  
        };
        threadPoolExecutor.execute(thread); 

    }
    /**
     *  添加操作日志
     * @param request session中用户相关信息（IP,用户ID）
     * @param bizName 业务模块名称
     * @param optFunctionName 操作工作名称
     * @param optInfo 操作内容
     */
    public void addSysLogs(HttpServletRequest request,String bizName, String optFunctionName,String optInfo) {
        
        
        Thread thread = new Thread() {
            public void run() {
                /* 
                 * 添加操作日志
                 * SOperationLogsInfoVo构造函数
                 * @param id UUID
                 * @param userName 用户名称
                 * @param userIp 用户IP
                 * @param bizName 业务模块名称
                 * @param optFunctionName 操作工作名称
                 * @param logType 日志类型 O：操作日志 S:系统日志
                 *  @param optInfo 操作内容 
                 */
                SOperationLogsInfoVo sOperationLogsInfoVo = new SOperationLogsInfoVo(UUIDUtils.getUUID(),
                        getSUserVo(request).getUserId(),
                        getIpAddr(request),
                        ModulesConstants.OPT_LOGS,
                        ModulesConstants.OPT_LOGS_QUERY,
                        Constants.S_OPT_LOGS_TYPE_OPT,    
                        optInfo
                        );
                  iSOperationLogsInfoService.addOperationLogs(sOperationLogsInfoVo);
            }  
        };
        threadPoolExecutor.execute(thread);
        

    }
    /** 
     * 基于@ExceptionHandler异常处理
     **/  
    @ExceptionHandler
    @ResponseBody
    public ClientDatatModel<Object> resolveException(HttpServletRequest request, Exception e) { 
        ClientDatatModel<Object> cdm = exceptionsHandler.resolveException(e);
        return cdm;
    }
    
    public SUserVo getSUserVo(HttpServletRequest request){
        // TODO 开发为了测试接口，此处取不到session.所以直接返回
       /* SUserVo userVoTest = new SUserVo();
        userVoTest.setcAreaInfoVo(new CAreaInfoVo());
        return userVoTest;*/
        HttpSession session = request.getSession();
        if (session == null) {
            throw new SessionOverdueException("登陆超时，请重新登陆！", ErrorConstants.EXCEPTION_SOURCE_USER, ErrorConstants.EXCEPTION_SEVERITY_HIGH);
        }
        SUserVo userVo = (SUserVo)session.getAttribute("sUserVo");
        if (userVo == null) {
            throw new SessionOverdueException("未登录或登陆超时，请登陆！", ErrorConstants.EXCEPTION_SOURCE_USER, ErrorConstants.EXCEPTION_SEVERITY_HIGH);
        }
        return userVo;
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
    public String getIpAddr(HttpServletRequest request) {
        return HttpUtil.getIpAddr(request);
    }
     
    /* (non-Javadoc)
     * @see com.hoosen.base.service.impl.BaseService#getParameter(javax.servlet.http.HttpServletRequest, java.lang.String)
     */
    public String getParameter(HttpServletRequest request,String name) throws ServiceException{
        return HttpUtil.getParameter(request, name);
    }
    
    public PageBounds buildPageBounds(Integer pageSize, Integer currentPageNum, Boolean isContainsTotalCount){
         if(null == pageSize){
             pageSize = 10;
         }
         if(null == currentPageNum){
             currentPageNum = 1;
         }
         if(null == isContainsTotalCount){
             isContainsTotalCount = true;
         }
         PageBounds pageBounds = new PageBounds();
         pageBounds.setPage(currentPageNum);
         pageBounds.setLimit(pageSize);
         pageBounds.setContainsTotalCount(isContainsTotalCount);
         return pageBounds;
     }
}
