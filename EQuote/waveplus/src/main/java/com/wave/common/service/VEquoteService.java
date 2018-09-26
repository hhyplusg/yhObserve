package com.wave.common.service;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.wave.base.vo.entity.Syscorpinfor;
import com.wave.base.vo.entity.VEquote;

public interface VEquoteService {
	
	/**
     * 机构查询报价信息
     * @Title getEquoteByBank
     * @param bankName
     * @param quoteDateStart
     * @param quoteDateEnd
     * @return List<Equote>
     * @author hannj
     * @date 2018年1月29日
     */
	public List<VEquote> getVEquoteByBank(String bankName, String quoteDateStart , String quoteDateEnd, String inquiryContent, Syscorpinfor syscorpinfo) throws ApplicationException;
	
	/**
     * 银行查询报价信息
     * @Title getBankEquotes
     * @param bankName
     * @param quoteDateStart
     * @param quoteDateEnd
     * @return List<Equote>
     * @author hannj
     * @date 2018年5月26日
     */
	public List<VEquote> getBankEquotes(String quoteDateStart , String quoteDateEnd, String inquiryContent, Syscorpinfor syscorpinfo) throws ApplicationException;

}
