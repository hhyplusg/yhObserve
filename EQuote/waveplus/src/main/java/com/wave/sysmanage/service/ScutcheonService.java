package com.wave.sysmanage.service;

import com.wave.base.service.BaseService;
import com.wave.sysmanage.vo.ScutcheonVo;

public interface ScutcheonService extends BaseService {
	/**
	 * 查询标牌信息
	 * @return
	 */
	ScutcheonVo getScutcheon();
	/**
	 * 保存标牌信息
	 * @param scutcheonVo
	 * @return
	 */
	int saveScutcheon(ScutcheonVo scutcheonVo);
}
