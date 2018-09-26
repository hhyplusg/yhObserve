package com.wave.common.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wave.base.dao.mapper.VEquoteMapper;
import com.wave.base.vo.entity.Syscorpinfor;
import com.wave.base.vo.entity.VEquote;
import com.wave.base.vo.entity.VEquoteExample;
import com.wave.base.vo.entity.VEquoteExample.Criteria;
import com.wave.common.exception.CommonServiceException;
import com.wave.common.service.VEquoteService;
import com.wave.core.util.DateUtil;
@Service("vequoteServices")
public class VEquoteServiceImpl implements VEquoteService{
	
	@Autowired
	private VEquoteMapper vequoteMapper;
	/**
     * 查询报价信息
     * @Title getEquoteByBank
     * @param bankName
     * @param quoteDateStart
     * @param quoteDateEnd
     * @return List<Equote>
     * @author hannj
     * @date 2018年1月29日
     */
	@Override
	public List<VEquote> getVEquoteByBank(String bankName, String quoteDateStart, String quoteDateEnd,String inquiryContent, Syscorpinfor syscorpinfo)
			throws ApplicationException {
		try{
			VEquoteExample example = new VEquoteExample();
		   	example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	
		   	Criteria criteria = example.createCriteria();
			criteria.andQuoteidIsNotNull();
			// 银行名称
			if (StringUtils.isNotBlank(bankName)) {
				criteria.andBjcorpnameLike("%"+bankName+"%");
			}
			
			// 日期条件
			if (StringUtils.isNotBlank(quoteDateStart) && StringUtils.isNotBlank(quoteDateEnd)){
				criteria.andQuotedateBetween(DateUtil.String2Date(quoteDateStart, DateUtil.yyyy_MM_dd), 
						DateUtil.getNextDay(DateUtil.String2Date(quoteDateEnd, DateUtil.yyyy_MM_dd)));
			} else if (StringUtils.isNotBlank(quoteDateStart) && StringUtils.isBlank(quoteDateEnd)){
				criteria.andQuotedateGreaterThanOrEqualTo(DateUtil.String2Date(quoteDateStart, DateUtil.yyyy_MM_dd));
			} else if (StringUtils.isBlank(quoteDateStart) && StringUtils.isNotBlank(quoteDateEnd)){
				criteria.andQuotedateLessThanOrEqualTo(
						DateUtil.getNextDay(DateUtil.String2Date(quoteDateEnd, DateUtil.yyyy_MM_dd)));
			} 
			
			// 询价机构
		   	criteria.andXjcorpidEqualTo(syscorpinfo.getId());
		   	
		   	// 询价内容
		   	if (StringUtils.isNotBlank(inquiryContent)) {
				criteria.andInquirycontentLike("%"+inquiryContent+"%");
			} else {
		   		Criteria criteriaOr =example.createCriteria();  
			   	criteriaOr.andQuotetypeEqualTo("public");
			   	
			   	// 银行名称
				if (StringUtils.isNotBlank(bankName)) {
					criteriaOr.andBjcorpnameLike("%"+bankName+"%");
				}
				
			   	// 日期条件
				if (StringUtils.isNotBlank(quoteDateStart) && StringUtils.isNotBlank(quoteDateEnd)){
					criteriaOr.andQuotedateBetween(DateUtil.String2Date(quoteDateStart, DateUtil.yyyy_MM_dd), 
							DateUtil.getNextDay(DateUtil.String2Date(quoteDateEnd, DateUtil.yyyy_MM_dd)));
				} else if (StringUtils.isNotBlank(quoteDateStart) && StringUtils.isBlank(quoteDateEnd)){
					criteriaOr.andQuotedateGreaterThanOrEqualTo(DateUtil.String2Date(quoteDateStart, DateUtil.yyyy_MM_dd));
				} else if (StringUtils.isBlank(quoteDateStart) && StringUtils.isNotBlank(quoteDateEnd)){
					criteriaOr.andQuotedateLessThanOrEqualTo(
							DateUtil.getNextDay(DateUtil.String2Date(quoteDateEnd, DateUtil.yyyy_MM_dd)));
				} 
			   	example.or(criteriaOr);  
		   	}
		   	
		   	List<VEquote> list = vequoteMapper.selectByExample(example);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}
	@Override
	public List<VEquote> getBankEquotes(String quoteDateStart, String quoteDateEnd, String inquiryContent,
			Syscorpinfor syscorpinfo) throws ApplicationException {
		try{
			VEquoteExample example = new VEquoteExample();
			
		   	example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	
		   	Criteria criteria = example.createCriteria();
		   	criteria.andQuotetypeNotEqualTo("corpAdd");
			// 日期条件
			if (StringUtils.isNotBlank(quoteDateStart) && StringUtils.isNotBlank(quoteDateEnd)){
				criteria.andQuotedateBetween(DateUtil.String2Date(quoteDateStart, DateUtil.yyyy_MM_dd), 
						DateUtil.getNextDay(DateUtil.String2Date(quoteDateEnd, DateUtil.yyyy_MM_dd)));
			} else if (StringUtils.isNotBlank(quoteDateStart) && StringUtils.isBlank(quoteDateEnd)){
				criteria.andQuotedateGreaterThanOrEqualTo(DateUtil.String2Date(quoteDateStart, DateUtil.yyyy_MM_dd));
			} else if (StringUtils.isBlank(quoteDateStart) && StringUtils.isNotBlank(quoteDateEnd)){
				criteria.andQuotedateLessThanOrEqualTo(
						DateUtil.getNextDay(DateUtil.String2Date(quoteDateEnd, DateUtil.yyyy_MM_dd)));
			} 
			
			//报价机构id等于登录机构id
		   	criteria.andBjcorpidEqualTo(syscorpinfo.getId());
			// 询价内容
		   	if (StringUtils.isNotBlank(inquiryContent)) {
				criteria.andInquirycontentLike("%"+inquiryContent+"%");
			}
		   	
		   	List<VEquote> list = vequoteMapper.selectByExample(example);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}
	
}


