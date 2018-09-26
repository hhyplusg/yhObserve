package com.wave.common.service;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.wave.base.vo.entity.Eqinquirytarget;

public interface EqinquiryTargetService {
	
	
	/**
	 * 查询所有询价关联信息
	 * @return
	 * @throws ApplicationException
	 */
	public List<Eqinquirytarget> getAllInquiries() throws ApplicationException;
	/**
	 * 查询所有询价关联信息
	 * @return
	 * @throws ApplicationException
	 */
	public List<Eqinquirytarget> getAllInquiries(int inquiryId) throws ApplicationException;
	/**
	 * 增加询价关联信息
	 * @param Eqinquirytarget
	 * @throws ApplicationException
	 */
	public void saveEqinquirytarget(Eqinquirytarget Eqinquirytarget) throws ApplicationException;
	
	/**
	 * 更新询价关联信息
	 * @param Eqinquirytarget
	 * @return
	 * @throws ApplicationException
	 */
	public void updateEqinquirytarget(Eqinquirytarget Eqinquirytarget) throws ApplicationException;
	
	/**
	 * 删除一条询价关联信息
	 * @param id
	 * @throws ApplicationException
	 */
	public void delEqinquirytarget(Integer id)throws ApplicationException;
	
	/***
	 * 	删除多条询价关联信息
	 * @param ids
	 * @throws ApplicationException
	 */
	public void delEqinquirytargets(List<Integer> ids) throws ApplicationException;
}
