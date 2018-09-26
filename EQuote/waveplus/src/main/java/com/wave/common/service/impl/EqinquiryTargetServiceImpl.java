package com.wave.common.service.impl;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wave.base.dao.mapper.EqinquirytargetMapper;
import com.wave.base.vo.entity.Eqinquirytarget;
import com.wave.base.vo.entity.EqinquirytargetExample;
import com.wave.base.vo.entity.EqinquirytargetExample.Criteria;
import com.wave.common.exception.CommonServiceException;
import com.wave.common.service.EqinquiryTargetService;
@Service("eqinquiryTargetServices")
public class EqinquiryTargetServiceImpl implements EqinquiryTargetService{
    
	@Autowired
	private EqinquirytargetMapper eqinquiryTargetMapper;
	

	@Override
	public List<Eqinquirytarget> getAllInquiries() throws ApplicationException {
		try{
			EqinquirytargetExample example = new EqinquirytargetExample();
			example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	Criteria criteria = example.createCriteria();
		   	
			criteria.andIdIsNotNull(); 
			//分页查询询价关联表
			List<Eqinquirytarget> list = eqinquiryTargetMapper.selectByExample(example);
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new CommonServiceException("error.eqinquirytarget.query");
		}
	}

	@Override
	public List<Eqinquirytarget> getAllInquiries(int inquiryId) throws ApplicationException {
		try{
			EqinquirytargetExample example = new EqinquirytargetExample();
			example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	Criteria criteria = example.createCriteria();
		   	
			criteria.andIdIsNotNull(); 
			criteria.andInquiryidEqualTo(inquiryId);
			//分页查询询价关联表
			List<Eqinquirytarget> list = eqinquiryTargetMapper.selectByExample(example);
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new CommonServiceException("error.eqinquirytarget.query");
		}
	}
	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveEqinquirytarget(Eqinquirytarget eqinquirytarget) throws ApplicationException {
		try{
			//插入询价关联表
			eqinquiryTargetMapper.insert(eqinquirytarget);
		} catch(Exception e){
			e.printStackTrace();
			//询价关联表新增失败
			throw new CommonServiceException("error.eqinquirytarget.add");
		}
          		
	}

	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateEqinquirytarget(Eqinquirytarget eqinquirytarget) throws ApplicationException {
		try{
			//更新询价关联表
			eqinquiryTargetMapper.updateByPrimaryKey(eqinquirytarget);
		} catch(Exception e){
			e.printStackTrace();
			//询价关联表更新失败
			throw new CommonServiceException("error.eqinquirytarget.update");
		}
		
	}

	@Override
	public void delEqinquirytarget(Integer id) throws ApplicationException {
		try{
			//删除询价关联信息
			eqinquiryTargetMapper.deleteByPrimaryKey(id);
		} catch(Exception e){
			e.printStackTrace();
			throw new CommonServiceException("error.eqinquirytarget.delete");
			//删除询价关联信息失败
		}
		
	}

	@Override
	public void delEqinquirytargets(List<Integer> ids) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

}
