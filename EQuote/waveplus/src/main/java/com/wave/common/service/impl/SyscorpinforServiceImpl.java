package com.wave.common.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wave.base.dao.mapper.SyscorpinforMapper;
import com.wave.base.vo.entity.Syscorpinfor;
import com.wave.base.vo.entity.SyscorpinforExample;
import com.wave.base.vo.entity.SyscorpinforExample.Criteria;
import com.wave.common.exception.CommonServiceException;
import com.wave.common.service.SyscorpinforService;
import com.wave.core.util.Md5Util;
import com.wave.core.util.StringUtil;
@Service("syscorpinforServices")
public class SyscorpinforServiceImpl implements SyscorpinforService{
	
	@Autowired
	private SyscorpinforMapper syscorpinforMapper;


	@Override
	public List<Syscorpinfor> getAllCorps()
			throws ApplicationException {
		try{
			SyscorpinforExample example = new SyscorpinforExample();
			
		   	example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	Criteria criteria = example.createCriteria();
		   	 
			criteria.andIdIsNotNull(); 
		   	//criteria.andCorptypeNotEqualTo("3");
		   	List<Syscorpinfor> list = syscorpinforMapper.selectByExample(example);
		   	if(list != null && list.size() > 0){
		   		for (Syscorpinfor syscorpinfor : list) {
		   			if("1".equals(syscorpinfor.getCorptype())){
		   				syscorpinfor.setCorptype("银行用户");
		   			}else if("2".equals(syscorpinfor.getCorptype())){
		   				syscorpinfor.setCorptype("机构用户");
		   			}else if("3".equals(syscorpinfor.getCorptype())){
		   				syscorpinfor.setCorptype("管理员");
		   			}
		   				
		   		}
		   	}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}

	@Override
	public List<Syscorpinfor> getAllCorps(List<Integer> ids){
		try{
			SyscorpinforExample example = new SyscorpinforExample();
			
		   	example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	Criteria criteria = example.createCriteria();
		   	 
			criteria.andIdIsNotNull(); 
		   	criteria.andCorptypeNotEqualTo("3");
		   	criteria.andIdIn(ids);
		   	List<Syscorpinfor> list = syscorpinforMapper.selectByExample(example);
		   
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public Boolean saveSyscorpinfor(Syscorpinfor syscorpinfor) throws ApplicationException {
		try{
			String password = syscorpinfor.getPassword();
			String encodePassword = Md5Util.encodePassword(password);
			syscorpinfor.setPassword(encodePassword);
			//插入机构表
			int insert = syscorpinforMapper.insert(syscorpinfor);
			if(insert == 1){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			//logger.error("添加机构信息失败", e);
			e.printStackTrace();
			throw new CommonServiceException("error.syscorpinfor.add");
		}
		
	}


	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public Boolean updateSyscorpinfor(Syscorpinfor syscorpinfor) throws ApplicationException {
		try{
			if(StringUtil.isEmpty(syscorpinfor.getPassword())){
				String password = syscorpinforMapper.selectByPrimaryKey(syscorpinfor.getId()).getPassword();
				syscorpinfor.setPassword(password);
			}else{
				String encodePassword = Md5Util.encodePassword(syscorpinfor.getPassword());
				syscorpinfor.setPassword(encodePassword);
			}
			//更新机构表
			int count = syscorpinforMapper.updateByPrimaryKey(syscorpinfor);
			if(count == 1){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			//logger.error("更新机构信息失败", e);
			throw new CommonServiceException("error.syscorpinfor.update");
		}
		
	}


	@Override
	public Boolean delSyscorpinfor(Integer id) throws ApplicationException {
		
		try{
			//删除机构信息
			int count = syscorpinforMapper.deleteByPrimaryKey(id);
			if(count == 1){
				return true;
			}else{
				return true;
			}
		}catch(Exception e){
			//logger.error("删除机构信息失败", e);
			throw new CommonServiceException("error.syscorpinfor.delete");
		}
		
	}


	@Override
	public Boolean delSyscorpinfor(String ids) throws ApplicationException {
		int count = 0;
		String[] split = null;
		if(ids.contains(",")){
			split = ids.split(",");
			for (int i = 0; i < split.length; i++) {
				Integer id = Integer.parseInt(split[i].trim());
				int delNum =  syscorpinforMapper.deleteByPrimaryKey(id);
				if(delNum == 1 ){
					count++;
				}
			}
		}else{
			int delNum =  syscorpinforMapper.deleteByPrimaryKey(Integer.parseInt(ids));
			if(delNum == 1){
				return true;
			}else{
				return false;
			}
		}
		if(count == split.length-1){
			return true;
		}else{
			return false;
		}
		
	}


	@Override
	public Boolean checkUserLoginName(String userloginname) throws ApplicationException {
		Boolean flag = false;
		SyscorpinforExample syscorpinforExample = new SyscorpinforExample();
		syscorpinforExample.isDistinct();
		Criteria criteria = syscorpinforExample.createCriteria();
		criteria.andIdIsNotNull();
		criteria.andUserloginnameLikeInsensitive(userloginname);
		long countByExample = syscorpinforMapper.countByExample(syscorpinforExample);
		if(countByExample == 1l){
			flag = true;
		}
		return flag;
	}


	@Override
	public Syscorpinfor login(Syscorpinfor syscorpinfor) {
		Syscorpinfor userInfo = null;
		if(syscorpinfor != null ){
			String userloginname = syscorpinfor.getUserloginname();
			String password = syscorpinfor.getPassword();
			SyscorpinforExample example = new SyscorpinforExample();
			example.isDistinct();
			Criteria criteria = example.createCriteria();
			criteria.andUserloginnameLikeInsensitive(userloginname);
			//criteria.andUserloginnameEqualTo(userloginname);
			String encodePassword = Md5Util.encodePassword(password);
			criteria.andPasswordEqualTo(encodePassword);
			List<Syscorpinfor> syscorpinforList = syscorpinforMapper.selectByExample(example);
			if(syscorpinforList != null && syscorpinforList.size()==1) {
				userInfo = syscorpinforList.get(0);
			}
		}
		return userInfo;
	}

	/**
     * 查询报价信息
     * @Title getBankList
     * @param bankName
     * @return List<Equote>
     * @author hannj
     * @date 2018年2月5日
     */
	@Override
	public List<Syscorpinfor> getBankList(String bankName)
			throws ApplicationException {
		try{
			SyscorpinforExample example = new SyscorpinforExample();
			
		   	example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	
		   	Criteria criteria = example.createCriteria();
		   	if (StringUtils.isNotBlank(bankName)) {
		   		criteria.andCorpshortnameLike("%"+bankName+"%");
		   	}
		   	criteria.andCorptypeEqualTo("1");
		   	return syscorpinforMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}


	@Override
	public Boolean checkPassword(String id, String password ) throws ApplicationException {
		Boolean flag = false;
		Syscorpinfor user = syscorpinforMapper.selectByPrimaryKey(Integer.parseInt(id));
		String encodePassword = Md5Util.encodePassword(password);
		if(user != null && encodePassword.equals(user.getPassword())) {
			flag = true;
		}
		return flag;
	}


	@Override
	public Boolean editPassword(Syscorpinfor syscorpinfor) {
		Boolean flag = false;
		Syscorpinfor user = syscorpinforMapper.selectByPrimaryKey(syscorpinfor.getId());
		String encodePassword = Md5Util.encodePassword(syscorpinfor.getPassword());
		user.setPassword(encodePassword);
		int num = syscorpinforMapper.updateByPrimaryKey(user);
		if(num == 1){
			flag = true;
		}
		return flag;
	}



	/**
	 * 查询机构列表
	 * @param collection
	 * @return
	 */
	@Override
	public List<Syscorpinfor> getCollectionList(String collection) {

		try{
			SyscorpinforExample example = new SyscorpinforExample();
			
		   	example.setDistinct(true);
		   	example.setOrderByClause("id desc");
		   	Criteria criteria = example.createCriteria();
		   	 
			criteria.andIdIsNotNull(); 
			criteria.andCorpshortnameLike("%"+collection+"%");
			criteria.andCorptypeEqualTo("2");
		   	 
		   	List<Syscorpinfor> list = syscorpinforMapper.selectByExample(example);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonServiceException("error.membermain.query");
		}
	}
}
