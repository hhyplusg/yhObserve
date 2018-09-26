package com.wave.common.service.impl;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wave.base.dao.mapper.EquotetargetMapper;
import com.wave.base.vo.entity.Equotetarget;
import com.wave.base.vo.entity.EquotetargetExample;
import com.wave.base.vo.entity.EquotetargetExample.Criteria;
import com.wave.common.exception.CommonServiceException;
import com.wave.common.service.EquoteTargetService;
@Service("EquoteTargetServices")
public class EquoteTargetServiceImpl implements EquoteTargetService{
    
	@Autowired
	private EquotetargetMapper EquoteTargetMapper;
	

	@Override
	public List<Equotetarget> getAllInquiries(Integer id) throws ApplicationException {
		try{
			EquotetargetExample example = new EquotetargetExample();
			example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	Criteria criteria = example.createCriteria();
		   	
			criteria.andIdIsNotNull(); 
			criteria.andQuoteidEqualTo(id);
			//分页查询报价关联表
			List<Equotetarget> list = EquoteTargetMapper.selectByExample(example);
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new CommonServiceException("error.Equotetarget.query");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveEquotetarget(Equotetarget Equotetarget) throws ApplicationException {
		try{
			//插入报价关联表
			EquoteTargetMapper.insert(Equotetarget);
		} catch(Exception e){
			e.printStackTrace();
			//报价关联表新增失败
			throw new CommonServiceException("error.Equotetarget.add");
		}
          		
	}

	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateEquotetarget(Equotetarget Equotetarget) throws ApplicationException {
		try{
			//更新报价关联表
			EquoteTargetMapper.updateByPrimaryKey(Equotetarget);
		} catch(Exception e){
			e.printStackTrace();
			//报价关联表更新失败
			throw new CommonServiceException("error.Equotetarget.update");
		}
		
	}

	@Override
	public void delEquotetarget(Integer id) throws ApplicationException {
		try{
			//删除报价关联信息
			EquoteTargetMapper.deleteByPrimaryKey(id);
		} catch(Exception e){
			e.printStackTrace();
			throw new CommonServiceException("error.Equotetarget.delete");
			//删除报价关联信息失败
		}
		
	}

	@Override
	public void delEquotetargets(List<Integer> ids) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

}
