package com.wave.user.service;

import com.wave.base.service.BaseService;
import com.wave.user.exception.UserServiceException;
import com.wave.user.vo.SUserVo;

public interface UserService extends BaseService {
	
	/**
	 * 系统登录 
	 * 2015年9月1日
	 */
	public SUserVo login(SUserVo sUserVo)   throws UserServiceException ;
	  /**
     * 检查用户是否登陆
     * 2015年9月1日
     */
    public SUserVo loginCheck(SUserVo sUserVo);
    /**
     * 检查用户是否登陆
     * @param sUserVo
     * @return
     */
	public Boolean testLogin(SUserVo sUserVo);
}
