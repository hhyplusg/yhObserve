package com.wave.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wave.base.dao.mapper.EquoteMapper;
import com.wave.base.vo.entity.Equote;
import com.wave.base.vo.entity.EquoteExample;
import com.wave.base.vo.entity.EquoteExample.Criteria;
import com.wave.base.vo.entity.EquotePojo;
import com.wave.base.vo.entity.Equotetarget;
import com.wave.common.exception.CommonServiceException;
import com.wave.common.service.EquoteService;
@Service("equoteServices")
public class EquoteServiceImpl implements EquoteService{
	
	@Autowired
	private EquoteMapper equoteMapper;



	@Override
	public List<Equote> getAllEquote(String quoteDateStart, String quoteDateEnd, int id)throws ApplicationException {
		try{
			EquoteExample example = new EquoteExample();
			
		   	example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	Criteria criteria = example.createCriteria();
		   	 
			criteria.andIdIsNotNull(); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dQuoteDateStart = sdf.parse(quoteDateStart + " 00:00:00");
			Date dQuoteDateEnd = sdf.parse(quoteDateEnd + " 23:59:59");
			criteria.andQuotedateGreaterThanOrEqualTo(dQuoteDateStart);
			criteria.andQuotedateLessThanOrEqualTo(dQuoteDateEnd);
			criteria.andQuotetypeNotEqualTo("corpAdd");
			criteria.andCorpidEqualTo(id);
		   	List<Equote> list = equoteMapper.selectByExample(example);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}


	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	@Options(useGeneratedKeys=true)
	public void saveEquote(Equote equote) throws ApplicationException {
		try{
			//插入申购业务订单主表
			 equoteMapper.insert(equote);
			
			//equotetarget.set
			
		}catch(Exception e){
			//logger.error("添加报价信息失败", e);
			e.printStackTrace();
			throw new CommonServiceException("error.equote.add");
		}
		
	}


	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateEquote(Equote equote) throws ApplicationException {
		try{
			//更新报价表
			equoteMapper.updateByPrimaryKey(equote);
			
		}catch(Exception e){
			//logger.error("更新报价信息失败", e);
			throw new CommonServiceException("error.equote.update");
		}
		
	}


	@Override
	public void delEquote(Integer id) throws ApplicationException {
		try{
			//删除报价信息
			equoteMapper.deleteByPrimaryKey(id);
		}catch(Exception e){
			//logger.error("删除报价信息失败", e);
			throw new CommonServiceException("error.equote.delete");
		}
		
	}


	@Override
	public void delEquote(List<Integer> ids) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Equote selectByPrimaryKey(Integer id) throws ApplicationException {
		return equoteMapper.selectByPrimaryKey(id);
	}


	@Override
	public void saveEquoteByCorp(Equote equote) {

		try{
			//插入申购业务订单主表
			equote.setQuotetype("corpAdd");
			equoteMapper.insert(equote);
			
			//equotetarget.set
			
		}catch(Exception e){
			//logger.error("添加报价信息失败", e);
			e.printStackTrace();
			throw new CommonServiceException("error.equote.add");
		}
		
	}


}
