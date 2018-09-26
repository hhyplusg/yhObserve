package com.wave.common.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wave.base.action.ClientDatatModel;
import com.wave.base.action.BaseController;
import com.wave.base.constant.BaseConstants;
import com.wave.common.cnstants.Constants;
import com.wave.core.annotation.RepetitionSubmitAnnotation;
import com.wave.core.util.StringUtil;
@Controller
@ResponseBody
public class TokenController extends BaseController {
    
    /**
     * 用于验证重复提交时生成token
     */ 
    @RepetitionSubmitAnnotation(needSaveToken = true)
    @RequestMapping("getToken")
    public ClientDatatModel<String> getToken(HttpServletRequest request) {
        ClientDatatModel<String> bcdm = new ClientDatatModel<String>(); 
        String strToken  = (String) request.getSession().getAttribute(BaseConstants.TOKEN_NAME);
        log.debug("toke------>{}", strToken); 
        bcdm.setCode(Constants.CONTROLLER_SUCCE);
        //bcdm.setData(Constants.TOKEN_NAME + ":" + strToken);
        bcdm.setData(strToken);
        return bcdm;
    }
       
    /**
     * 用于验证重复提交时生成token
     */ 
    @RequestMapping("testToken")
    @RepetitionSubmitAnnotation(needRemoveToken = true)
    public void testToken(HttpServletRequest request,Writer out) {
        try {
        String strToken = (String)request.getSession().getAttribute(BaseConstants.TOKEN_NAME);
        log.debug("toke------>{}", strToken);
        if (StringUtil.isNull(strToken)) { 
            out.write(" is repetition submit ");
        } 
       // request.getSession().removeAttribute(BaseConstants.TOKEN_NAME); 
         out.write("OK");
        } catch (IOException e) {
            
        }
    }
}
