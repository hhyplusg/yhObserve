package com.wave.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wave.base.service.impl.BaseServiceImpl;
import com.wave.common.dao.CAreaInfoMapper;
import com.wave.common.service.CAreaInfoService;
import com.wave.common.vo.SysCAreaManageVo;
@Service("cAreaInfoService")
public class CAreaInfoServiceImpl extends BaseServiceImpl implements CAreaInfoService  {
	
	@Resource(name="CAreaInfoMapper")
    CAreaInfoMapper cAreaInfoMapper;
	
	/**
	 *  根据父节点查询子节点及子节点的子节点
	 * @param cDictVoList
	 * @return
	 */
	public List<SysCAreaManageVo> getAreasByPid(String pid){
		List<SysCAreaManageVo> cAreaRoot = cAreaInfoMapper.getAreasById(pid);
	    List<SysCAreaManageVo> cAreaMapList = cAreaInfoMapper.getAreasByPid(pid);
	    if(cAreaMapList.size()>0){
	    	cAreaRoot.get(0).setChild(cAreaMapList);
	    	for (SysCAreaManageVo SysCAreaManageVo : cAreaMapList) {
	    		if(SysCAreaManageVo.getCountyCode().equals("00")){
	    			List<SysCAreaManageVo> cAreaChildList = cAreaInfoMapper.getAreasByPid(SysCAreaManageVo.getId());
	    			SysCAreaManageVo.setChild(cAreaChildList);
	    		}
			}
    	}
		return cAreaRoot;
	}
	/**
	 *  根据父节点查询子节点及子节点的子节点
	 * @param cDictVoList
	 * @return
	 */
	public List<SysCAreaManageVo> getAreasTreeByPid(String pid){
		List<SysCAreaManageVo> cAreaRoot = cAreaInfoMapper.getAreasById(pid);
	    List<SysCAreaManageVo> cAreaMapList = cAreaInfoMapper.getAreasByPid(pid);
	    if(cAreaMapList.size()>0){
	    	cAreaRoot.addAll(cAreaMapList);
	    	for (SysCAreaManageVo SysCAreaManageVo : cAreaMapList) {
	    		if(SysCAreaManageVo.getCountyCode().equals("00")){
	    			List<SysCAreaManageVo> cAreaChildList = cAreaInfoMapper.getAreasByPid(SysCAreaManageVo.getId());
	    			cAreaRoot.addAll(cAreaChildList);
	    		}
			}
    	}
		return cAreaRoot;
	}
	/**
	 * 根据父节点查询包含子节点的节点
	 * @param cDictVoList
	 * @return
	 */
	public List<SysCAreaManageVo> getAreaParentTreeByPid(String pid){
		List<SysCAreaManageVo> cAreaRoot = cAreaInfoMapper.getAreasById(pid);
	    List<SysCAreaManageVo> cAreaMapList = cAreaInfoMapper.getAreasByPid(pid);
	    if(cAreaMapList.size()>0){
	    	List<SysCAreaManageVo> parent = new ArrayList<SysCAreaManageVo>();
	    	for (SysCAreaManageVo SysCAreaManageVo : cAreaMapList) {
	    		if(SysCAreaManageVo.getCountyCode().equals("00")){
		    		parent.add(SysCAreaManageVo);
	    		}
			}
	    	cAreaRoot.get(0).setChild(parent);
    	}
		return cAreaRoot;
	}
	/**
	 * 根据父节点查询子节点
	 * @param cDictVoList
	 * @return
	 */
	public List<SysCAreaManageVo> getChildAreaByPid(String pid){
	    List<SysCAreaManageVo> cAreaMapList = cAreaInfoMapper.getAreasByPid(pid);
		return cAreaMapList;
	}
	/**
	 * 根据下级区划的区划代码查询上级区划
	 * @param childId 下级区划的区划代码
	 * @return
	 */
	public SysCAreaManageVo getCAreaInfoVoByChild(String childAreaCode){
		List<SysCAreaManageVo> list = cAreaInfoMapper.getCAreaInfoVoByChild(childAreaCode);
		if(list!=null&&list.size()>0){ 
			return list.get(0);
		}else{
			return new SysCAreaManageVo();
		}
	}
	/**
	 * 根据id查询区划信息
	 * @param areaCode
	 * @return
	 */
	public SysCAreaManageVo getAreaById(String id){
		List<SysCAreaManageVo> list = cAreaInfoMapper.getAreasById(id);
		if(list.size()>0){
			return list.get(0);
		}
		return new SysCAreaManageVo();
	}
	   /**
     * 根据区划代码查询区划信息
     * @param areaCode
     * @return
     */
    public SysCAreaManageVo getAreaByAreaCode(String areaCode){
        List<SysCAreaManageVo> list = cAreaInfoMapper.getAreasByAreaCode(areaCode);
        if(list.size()>0){
            return list.get(0);
        }
        return new SysCAreaManageVo();
    }
	
}