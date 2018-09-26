package com.wave.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wave.base.dao.mapper.SyscorpinforMapper;
import com.wave.base.dao.mapper.VEqinquiryTargetMapper;
import com.wave.base.vo.entity.Syscorpinfor;
import com.wave.base.vo.entity.VEqinquiryTarget;
import com.wave.base.vo.entity.VEqinquiryTargetExample;
import com.wave.base.vo.entity.VEqinquiryTargetExample.Criteria;
import com.wave.common.exception.CommonServiceException;
import com.wave.common.service.VEqinquiryTargetService;
@Service("vEqinquiryTargetService")
public class VEqinquiryTargetServiceImpl implements VEqinquiryTargetService{
	
	@Autowired
	private VEqinquiryTargetMapper vEqinquiryTargetMapper;
	@Autowired
	private SyscorpinforMapper syscorpinforMapper;
	/**
     * 查询询价对象信息
     * @Title getEquoteByBank
     * @param bankName
     * @param quoteDateStart
     * @param quoteDateEnd
     * @return List<Equote>
     * @author hannj
     * @date 2018年1月29日
     */
	@Override
	public List<VEqinquiryTarget> getInquiresByBank(String bankName, String quoteDateStart, String quoteDateEnd,Syscorpinfor syscorpinfo)
			throws ApplicationException {
		try{
			VEqinquiryTargetExample example = new VEqinquiryTargetExample();
			
		   	example.setDistinct(true);
		   	Criteria criteria = example.createCriteria();
			criteria.andCorpnametarLike("%"+bankName+"%");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dQuoteDateStart = sdf.parse(quoteDateStart  + " 00:00:00");
			Date dQuoteDateEnd = sdf.parse(quoteDateEnd + " 23:59:59");
			criteria.andInquirydateBetween(dQuoteDateStart, dQuoteDateEnd);
			criteria.andCorpidtarEqualTo(syscorpinfo.getId());
			
			VEqinquiryTargetExample vEqinquiryTargetExample = new VEqinquiryTargetExample();
			vEqinquiryTargetExample.setDistinct(true);
			
		   	List<VEqinquiryTarget> vEqinquiryTargetList = vEqinquiryTargetMapper.selectByExample(vEqinquiryTargetExample);
//		   	List<VEquote> list = vequoteMapper.selectByExample(example);
//		   	for (Equote equote : equoteList) {
//		   		VEquote vEquote = new VEquote(); 
//		   		String corpname = syscorpinforMapper.selectByPrimaryKey(equote.getCorpid()).getCorpname();
//		   		if(StringUtil.isNotEmpty(bankName)){
//		   			if(corpname.contains(bankName)){
//		   				vEquote.setBjcorpid(equote.getCorpid());
//				   		vEquote.setBjcorpname(syscorpinforMapper.selectByPrimaryKey(equote.getCorpid()).getCorpname());
//				   		vEquote.setQuotedate(equote.getQuotedate());
//				   		vEquote.setRatesevenday(equote.getRatesevenday());
//				   		vEquote.setRatefourteenday(equote.getRatefourteenday());
//				   		vEquote.setRateonemonth(equote.getRateonemonth());
//				   		vEquote.setRatetwomonth(equote.getRatetwomonth());
//				   		vEquote.setRatethreemonth(equote.getRatethreemonth());
//				   		vEquote.setRatesixmonth(equote.getRatesixmonth());
//				   		vEquote.setOneyear(equote.getOneyear());
//				   		vEquote.setQuotetype(equote.getQuotetype());
//				   		list.add(vEquote);
//		   			}
//		   		}else{
//		   			vEquote.setBjcorpid(equote.getCorpid());
//		   			vEquote.setBjcorpname(syscorpinforMapper.selectByPrimaryKey(equote.getCorpid()).getCorpname());
//		   			vEquote.setQuotedate(equote.getQuotedate());
//		   			vEquote.setRatesevenday(equote.getRatesevenday());
//		   			vEquote.setRatefourteenday(equote.getRatefourteenday());
//		   			vEquote.setRateonemonth(equote.getRateonemonth());
//		   			vEquote.setRatetwomonth(equote.getRatetwomonth());
//		   			vEquote.setRatethreemonth(equote.getRatethreemonth());
//		   			vEquote.setRatesixmonth(equote.getRatesixmonth());
//		   			vEquote.setOneyear(equote.getOneyear());
//		   			vEquote.setQuotetype(equote.getQuotetype());
//		   			list.add(vEquote);
//		   		}
//		   	}
			return vEqinquiryTargetList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}
	
}


