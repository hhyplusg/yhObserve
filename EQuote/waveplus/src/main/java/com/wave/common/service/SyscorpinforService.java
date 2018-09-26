package com.wave.common.service;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.wave.base.vo.entity.Syscorpinfor;

public interface SyscorpinforService {
	
	public List<Syscorpinfor> getAllCorps() throws ApplicationException;
	
	public List<Syscorpinfor> getAllCorps(List<Integer> ids) throws ApplicationException;
	/**
	 * 增加机构信息
	 * @param syscorpinfor
	 * @throws ApplicationException
	 */
	public Boolean saveSyscorpinfor(Syscorpinfor syscorpinfor) throws ApplicationException;
	
	/**
	 * 更新机构信息
	 * @param syscorpinfor
	 * @throws ApplicationException
	 */
	public Boolean updateSyscorpinfor(Syscorpinfor syscorpinfor) throws ApplicationException;
	
	/**
	 * 删除机构信息
	 * @param id 机构ID
	 * @throws ApplicationException
	 */
	public Boolean delSyscorpinfor(Integer id) throws ApplicationException;
	
	public Boolean delSyscorpinfor(String ids) throws ApplicationException;
	
	
	/**
	 * 校验登陆用户名是否存在
	 * @param userloginname
	 * 			用户登录名
	 * @return
	 * @throws ApplicationException
	 */
	public Boolean checkUserLoginName(String  userloginname) throws ApplicationException;
	
	/**
	 * 校验登陆密码是否正确
	 * @param password
	 * 			用户登录名
	 * @return
	 * @throws ApplicationException
	 */
	public Boolean checkPassword(String id,String password ) throws ApplicationException;
	
	public Syscorpinfor login(Syscorpinfor syscorpinfor);
	
	/**
     * 查询报价信息
     * @Title getBankList
     * @param bankName
     * @return List<Equote>
     * @author hannj
     * @date 2018年2月5日
     */
	public List<Syscorpinfor> getBankList(String bankName) throws ApplicationException;

	/**
	 * 修改密码
	 * @param id
	 * @param new_password
	 * @return
	 */
	public Boolean editPassword(Syscorpinfor syscorpinfor);

	/**
	 * 查询机构里列表
	 * @param collection
	 * @return
	 */
	public List<Syscorpinfor> getCollectionList(String collection);
}
