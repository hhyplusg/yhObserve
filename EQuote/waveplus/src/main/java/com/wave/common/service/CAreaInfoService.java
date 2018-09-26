package com.wave.common.service;

import java.util.List;

import com.wave.common.vo.SysCAreaManageVo;

public interface CAreaInfoService{

	 /**
     * 根据父节点查询子节点及子节点的子节点
     * @param pid
     * @return
     */
	public List<SysCAreaManageVo> getAreasByPid(String pid);
	/**
     * 根据父节点查询子节点及子节点的子节点
     * @param pid
     * @return
     */
	public List<SysCAreaManageVo> getAreasTreeByPid(String pid);
	/**
	 * 根据下级区划的区划代码查询上级区划
	 * @param childId 下级区划的区划代码
	 * @return
	 */
	public SysCAreaManageVo getCAreaInfoVoByChild(String childAreaCode);
	/**
	 * 根据父节点查询包含子节点的节点
	 * @param pid
	 * @return
	 */
	public List<SysCAreaManageVo> getAreaParentTreeByPid(String pid);
	/**
	 * 根据父节点查询子节点
	 * @param pid
	 * @return
	 */
	public List<SysCAreaManageVo> getChildAreaByPid(String pid);
	/**
	 * 根据区划代码查询区划信息
	 * @param areaCode
	 * @return
	 */
	public SysCAreaManageVo getAreaByAreaCode(String areaCode);
	   /**
     * 根据id查询区划信息
     * @param areaCode
     * @return
     */
    public SysCAreaManageVo getAreaById(String areaCode);
    
    
}