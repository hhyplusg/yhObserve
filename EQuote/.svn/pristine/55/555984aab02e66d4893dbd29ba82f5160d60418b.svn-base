package com.wave.common.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wave.common.dao.SLogsMapper;
import com.wave.common.service.SLogsService;
import com.wave.common.vo.SLogsVo;
@Service("sLogsService")
public class SLogsServiceImpl implements SLogsService {
	@Resource(name="SLogsMapper")
	SLogsMapper sLogsMapper;
	@Override
	public Integer addDeleteLogs(SLogsVo sLogsVo) {
		int i = sLogsMapper.insert(sLogsVo);
		return i;
	}

}
