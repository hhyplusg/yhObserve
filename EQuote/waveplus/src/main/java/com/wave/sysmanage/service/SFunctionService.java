package com.wave.sysmanage.service;

import java.util.List;

import com.wave.base.service.BaseService;
import com.wave.sysmanage.vo.SFunctionInfoVo;

public interface SFunctionService extends BaseService {
	/**
	 * 查询页面功能树形
	 * @return
	 */
	public List<SFunctionInfoVo> getFunctionTree();

}
