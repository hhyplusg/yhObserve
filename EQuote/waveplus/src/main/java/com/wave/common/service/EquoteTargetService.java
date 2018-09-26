package com.wave.common.service;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.wave.base.vo.entity.Equotetarget;

public interface EquoteTargetService {
	
	
	/**
	 * 查询所有报价关联信息
	 * @return
	 * @throws ApplicationException
	 */
	public List<Equotetarget> getAllInquiries(Integer id) throws ApplicationException;

	/**
	 * 增加报价关联信息
	 * @param Equotetarget
	 * @throws ApplicationException
	 */
	public void saveEquotetarget(Equotetarget Equotetarget) throws ApplicationException;
	
	/**
	 * 更新报价关联信息
	 * @param Equotetarget
	 * @return
	 * @throws ApplicationException
	 */
	public void updateEquotetarget(Equotetarget Equotetarget) throws ApplicationException;
	
	/**
	 * 删除一条报价关联信息
	 * @param id
	 * @throws ApplicationException
	 */
	public void delEquotetarget(Integer id)throws ApplicationException;
	
	/***
	 * 	删除多条报价关联信息
	 * @param ids
	 * @throws ApplicationException
	 */
	public void delEquotetargets(List<Integer> ids) throws ApplicationException;
}
