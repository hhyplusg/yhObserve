package com.wave.common.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wave.base.dao.mapper.EqinquiryMapper;
import com.wave.base.dao.mapper.VEqinquiryMapper;
import com.wave.base.vo.entity.Eqinquiry;
import com.wave.base.vo.entity.EqinquiryExample;
import com.wave.base.vo.entity.EqinquiryExample.Criteria;
import com.wave.base.vo.entity.VEqinquiry;
import com.wave.base.vo.entity.VEqinquiryExample;
import com.wave.common.exception.CommonServiceException;
import com.wave.common.service.EqinquiryService;
import com.wave.core.util.DateUtil;
@Service("eqinquiryServices")
public class EqinquiryServiceImpl implements EqinquiryService{
    
	@Autowired
	private EqinquiryMapper eqinquiryMapper;
	
	@Autowired
	private VEqinquiryMapper veqinquiryMapper;

	@Override
	public List<Eqinquiry> getAllInquiries() throws ApplicationException {
		try{
			EqinquiryExample example = new EqinquiryExample();
			example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	Criteria criteria = example.createCriteria();
		   	
			criteria.andIdIsNotNull(); 
			//分页查询询价表
			List<Eqinquiry> list = eqinquiryMapper.selectByExample(example);
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new CommonServiceException("error.eqinquiry.query");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveEqinquiry(Eqinquiry eqinquiry) throws ApplicationException {
		try{
			//插入询价表
			eqinquiryMapper.insert(eqinquiry);
		} catch(Exception e){
			e.printStackTrace();
			//询价表新增失败
			throw new CommonServiceException("error.eqinquiry.add");
		}
          		
	}

	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateEqinquiry(Eqinquiry eqinquiry) throws ApplicationException {
		try{
			//更新询价表
			eqinquiryMapper.updateByPrimaryKey(eqinquiry);
		} catch(Exception e){
			e.printStackTrace();
			//询价表更新失败
			throw new CommonServiceException("error.eqinquiry.update");
		}
		
	}

	@Override
	public void delEqinquiry(Integer id) throws ApplicationException {
		try{
			//删除询价信息
			eqinquiryMapper.deleteByPrimaryKey(id);
		} catch(Exception e){
			e.printStackTrace();
			throw new CommonServiceException("error.eqinquiry.delete");
			//删除询价信息失败
		}
		
	}

	@Override
	public void delEqinquirys(List<Integer> ids) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VEqinquiry> getInquiriesByCorp(String corpName, String inquiryDateStart, String inquiryDateEnd)
			throws ApplicationException {
		try{
			VEqinquiryExample example = new VEqinquiryExample();
		   	example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	
		   	com.wave.base.vo.entity.VEqinquiryExample.Criteria criteria = example.createCriteria();
			criteria.andIdIsNotNull(); 
			// 机构名称
			if (StringUtils.isNotBlank(corpName)) {
				criteria.andCorpnameLike("%"+corpName+"%");
			}
			
			// 日期条件
			if (StringUtils.isNotBlank(inquiryDateStart) && StringUtils.isNotBlank(inquiryDateEnd)){
				criteria.andInquirydateBetween(DateUtil.String2Date(inquiryDateStart, DateUtil.yyyy_MM_dd), 
						DateUtil.getNextDay(DateUtil.String2Date(inquiryDateEnd, DateUtil.yyyy_MM_dd)));
			} else if (StringUtils.isNotBlank(inquiryDateStart) && StringUtils.isBlank(inquiryDateEnd)){
				criteria.andInquirydateGreaterThanOrEqualTo(DateUtil.String2Date(inquiryDateStart, DateUtil.yyyy_MM_dd));
			} else if (StringUtils.isBlank(inquiryDateStart) && StringUtils.isNotBlank(inquiryDateEnd)){
				criteria.andInquirydateLessThanOrEqualTo(
						DateUtil.getNextDay(DateUtil.String2Date(inquiryDateEnd, DateUtil.yyyy_MM_dd)));
			} 
			
		   	List<VEqinquiry> list = veqinquiryMapper.selectByExample(example);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}


}
