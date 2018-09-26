package com.wave.user.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wave.base.constant.BaseConstants;
import com.wave.base.service.impl.BaseServiceImpl;
import com.wave.core.annotation.ServiceLoggerAnnotation;
import com.wave.core.util.ConfigUtil;
import com.wave.core.util.Md5Util;
import com.wave.core.util.StringUtil;
import com.wave.sysmanage.dao.SFunctionInfoMapper;
import com.wave.sysmanage.vo.SFunctionInfoVo;
import com.wave.user.dao.SUserMapper;
import com.wave.user.exception.UserServiceException;
import com.wave.user.service.UserService;
import com.wave.user.vo.SUserVo;

@Service("iUserService")
public class UserServiceImpl extends BaseServiceImpl implements UserService { 
	
	@Resource(name="SUserMapper")
	private SUserMapper  sUserMapper;  
    
   
    	
	@Resource(name="SFunctionInfoMapper")
	private SFunctionInfoMapper sFunctionInfoMapper;
	
	 
  
	/**
     * 用户登陆
     */
    @ServiceLoggerAnnotation(description = "用户登陆")
    @Override
    public SUserVo login(SUserVo sUserVo) throws UserServiceException { 
        if (log.isDebugEnabled()) {
            log.debug("login() start "); 
            log.debug("传入参数： " + BaseConstants.CRLF); 
            log.debug(sUserVo);
        } 
        List<SUserVo> existUserList = sUserMapper.login(sUserVo);
        if ( existUserList.size() < 1 ) {
            int erroeLoginCount = Integer.parseInt(ConfigUtil.getString("ERROR_LOGIN_COUNT"));
            List<SUserVo> errorUserList = sUserMapper.selectUserByLoginUserName(sUserVo);
            if (StringUtil.isNotEmpty(errorUserList) && errorUserList.size() > 0) {
                SUserVo errorUser = errorUserList.get(0);
                if(StringUtil.isEmpty(errorUser.getLoginCount())){
                    errorUser.setLoginCount(0);
                }
                errorUser.setLoginCount(errorUser.getLoginCount()+1);
                if(errorUser.getLoginCount() > erroeLoginCount){
                    errorUser.setStatus("99");
                }
                sUserMapper.updateLoginCountByLoginUserName(errorUser);
            }
        }  else {
            sUserVo = existUserList.get(0);
            sUserVo.setPassword("");
            // 取得用户对应的系统功能信息 
            List<SFunctionInfoVo> functionInfoVoList  = sFunctionInfoMapper.getSFunctionByUserID(sUserVo.getUserId());
            sUserVo.setFunctionInfoVoList(functionInfoVoList);
            
            if(StringUtil.isNotEmpty(sUserVo.getLoginCount()) && sUserVo.getLoginCount() > 0){
                sUserVo.setLoginCount(0);
                sUserVo.setStatus(null);
                sUserMapper.updateLoginCountByLoginUserName(sUserVo);
            } 
        }
        log.debug("login() end"); 
        return sUserVo; 
    }
    
    /**
     * 检查用户是否登陆 
     */
    @Override
    public SUserVo loginCheck(SUserVo sUserVo)  throws UserServiceException { 
        if (log.isDebugEnabled()) {
            log.debug("login() start "); 
            log.debug("传入参数： " + BaseConstants.CRLF); 
            log.debug(sUserVo);
        }
        SUserVo existUser = null;
        List<SUserVo> existUserList = sUserMapper.login(sUserVo);
        if(existUserList.size() < 1){
            throw new UserServiceException("用户不存在或密码错误！");
        }  else {
            existUser = existUserList.get(0);
        }
        log.debug("login() end"); 
        return existUser; 
    }
    
    /**
     * 检查用户
     */
	@Override
	public Boolean testLogin(SUserVo sUserVo) {
		String password =getPasswordByUsername(sUserVo);
		if(password!=null){
			if(sUserVo.getPassword().equalsIgnoreCase(Md5Util.encodePassword(password))){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	
	private String getPasswordByUsername(SUserVo sUserVo) {
		HashMap<String, String> userHashmap=new HashMap<String, String>();
		userHashmap.put("admin", "admin");
		userHashmap.put("111", "111");
		userHashmap.put("222", "222");
		userHashmap.put("333", "333");
		return userHashmap.get(sUserVo.getUserName());
	}
}
