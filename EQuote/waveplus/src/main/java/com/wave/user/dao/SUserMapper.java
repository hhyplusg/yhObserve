    package com.wave.user.dao;

import java.util.List;

import com.wave.user.vo.SUserVo;


public interface SUserMapper {
    
    /**
     * 根据用户名密码取得登陆用户的信息
     * @param record
     * @return List<SUserVo> 
     */
    List<SUserVo> login( SUserVo sUserVo);
    /**
     * 根据用户名查询用户信息
     * @param sUserVo
     * @return
     */
    List<SUserVo> selectUserByLoginUserName( SUserVo sUserVo);
    /**
     * 根据用户名更新失败登录次数和状态
     * @param sUserVo
     * @return
     */
    int updateLoginCountByLoginUserName(SUserVo sUserVo);
    
    /**
     * 全字段添加用户信息
     * @param record
     * @return
     */
    int insert(SUserVo record);
    /**
     * 全字段添加用户信息，用户空的字段不添加
     * @param record
     * @return
     */
    int insertSelective(SUserVo record);
    
    
}