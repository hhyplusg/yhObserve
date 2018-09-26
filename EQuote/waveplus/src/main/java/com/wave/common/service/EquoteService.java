package com.wave.common.service;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.wave.base.vo.entity.Equote;
import com.wave.base.vo.entity.EquotePojo;

public interface EquoteService {
	
	public List<Equote> getAllEquote(String quoteDateStart,String quoteDateEnd,int id) throws ApplicationException;
	
	/**
	 * 增加报价
	 * @param equote
	 * @throws ApplicationException
	 */
	public void saveEquote(Equote equote) throws ApplicationException;
	
	/**
	 * 增加报价
	 * @param equote
	 * @throws ApplicationException
	 */
	public Equote selectByPrimaryKey(Integer id) throws ApplicationException;
	
	/**
	 * 更新报价信息
	 * @param equote
	 * @throws ApplicationException
	 */
	public void updateEquote(Equote equote) throws ApplicationException;
	
	/**
	 * 删除报价信息
	 * @param id 报价ID
	 * @throws ApplicationException
	 */
	public void delEquote(Integer id) throws ApplicationException;
	
	public void delEquote(List<Integer> ids) throws ApplicationException;

	public void saveEquoteByCorp(Equote equote);

}
