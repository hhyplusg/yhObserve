package com.wave.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wave.base.action.ClientDatatModel;
import com.wave.base.action.BaseController;
import com.wave.common.cnstants.Constants;
import com.wave.core.annotation.ControllerLoggerAnnontation;
import com.wave.core.util.StringUtil;
import com.wave.user.service.UserService;
import com.wave.user.vo.SUserVo;

/**
 * 用户登录
 * @author 
 * 2015年8月30日
 */
@Controller
@RequestMapping(value="userController")
public class UserController extends BaseController {

    @Autowired
    private UserService iUserService;

    /**
     * 登录接口
     * @throws Exception 
     * 
     * @user 2015年8月30日
     */
   // @ControllerLoggerAnnontation(description = "用户{}登陆",isSaveToDb=true)
    @RequestMapping(value = "login/{user}", method = RequestMethod.GET)
    @ResponseBody
    public ClientDatatModel<SUserVo> login(@PathVariable("user") String user,SUserVo sUserVo, HttpServletRequest request, HttpServletResponse response,String description) throws Exception {
        ClientDatatModel<SUserVo> ClientDatatModel = new ClientDatatModel<>();
        
        sUserVo.setUserLonginName(user);
        sUserVo.setPassword("a123456");
        sUserVo = iUserService.login(sUserVo);
        description = "用户登陆";
        if(StringUtil.isEmpty(sUserVo.getUserId())){
        	ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
            ClientDatatModel.setMsg("用户名或密码错误！");
        }else{
        	// 清空session中的密码
            sUserVo.setPassword("");
        	ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
        	ClientDatatModel.setData(sUserVo);
            ClientDatatModel.setMsg("登录成功！");
        }
        request.getSession().setAttribute(Constants.WEB_SESSION_USER_INFO, sUserVo);
        request.getSession().setAttribute(Constants.LOG_DESCRIPTION_VALUE, sUserVo.getUserName());
 
        return ClientDatatModel;
    }
    /**
     * 用户退出
     * @param request
     * @return
     */
   // @ControllerLoggerAnnontation(description = "",isSaveToDb=false)
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public ClientDatatModel<String> logout(HttpServletRequest request) { 
        ClientDatatModel<String> ClientDatatModel = new ClientDatatModel<>();
        ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
        ClientDatatModel.setMsg("退出登录失败！");
        if(request.getSession().getAttribute(Constants.WEB_SESSION_USER_INFO)!=null){
        	 request.getSession().removeAttribute(Constants.WEB_SESSION_USER_INFO);
             request.getSession().invalidate();
             ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
             ClientDatatModel.setMsg("退出登录成功！");
        } 
        return ClientDatatModel;
    }
    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "getcurrentloguser", method = RequestMethod.GET)
    @ResponseBody
    public ClientDatatModel<SUserVo> getCurrentLogUser(HttpServletRequest request) { 
    	 ClientDatatModel<SUserVo> ClientDatatModel = new ClientDatatModel<>();
    	 SUserVo sUserVo = (SUserVo) request.getSession().getAttribute(Constants.WEB_SESSION_USER_INFO);
    	 if(sUserVo!=null)
    	 {
         	ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
         	ClientDatatModel.setData(sUserVo);
            ClientDatatModel.setMsg("获取用户信息成功！");
         }else{
        	 ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
          	 ClientDatatModel.setData(null);
             ClientDatatModel.setMsg("获取用户信息失败！");
         }
         return ClientDatatModel;
    }
}
