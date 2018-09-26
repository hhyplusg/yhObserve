package com.wave.sysmanage.dao;

import java.util.List;

import com.wave.base.dao.BaseDao;
import com.wave.sysmanage.vo.ScutcheonVo;

public interface ScutcheonMapper extends BaseDao {
	/**
	 * 查询标牌信息
	 * @return
	 */
	List<ScutcheonVo> selectScutcheons();
	
	ScutcheonVo selectScutcheon();
	
	/**
	 * 新增标牌信息
	 * @param scutcheonVo
	 * @return
	 */
	int insert(ScutcheonVo scutcheonVo);
	/**
	 * 更新标牌信息
	 * @param scutcheonVo
	 * @return
	 */
	int update(ScutcheonVo scutcheonVo);

}
