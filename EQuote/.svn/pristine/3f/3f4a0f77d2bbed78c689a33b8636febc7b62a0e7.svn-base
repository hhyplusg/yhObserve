package com.wave.common.service;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.wave.base.vo.entity.Eqinquiry;
import com.wave.base.vo.entity.VEqinquiry;

public interface EqinquiryService {
	
	
	/**
	 * 查询所有询价信息
	 * @return
	 * @throws ApplicationException
	 */
	public List<Eqinquiry> getAllInquiries() throws ApplicationException;

	/**
	 * 增加询价信息
	 * @param eqinquiry
	 * @throws ApplicationException
	 */
	public void saveEqinquiry(Eqinquiry eqinquiry) throws ApplicationException;
	
	/**
	 * 更新询价信息
	 * @param eqinquiry
	 * @return
	 * @throws ApplicationException
	 */
	public void updateEqinquiry(Eqinquiry eqinquiry) throws ApplicationException;
	
	/**
	 * 删除一条询价信息
	 * @param id
	 * @throws ApplicationException
	 */
	public void delEqinquiry(Integer id)throws ApplicationException;
	
	/***
	 * 	删除多条询价信息
	 * @param ids
	 * @throws ApplicationException
	 */
	public void delEqinquirys(List<Integer> ids) throws ApplicationException;
	
	/**
	 * 根据机构名称和时间段查询询价信息
	 * @return
	 * @throws ApplicationException
	 */
	public List<VEqinquiry> getInquiriesByCorp(String corpName, String inquiryDateStart, String inquiryDateEnd) throws ApplicationException;
    
}
