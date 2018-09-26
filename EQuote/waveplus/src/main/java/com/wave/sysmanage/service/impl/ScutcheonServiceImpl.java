package com.wave.sysmanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wave.base.service.impl.BaseServiceImpl;
import com.wave.core.util.StringUtil;
import com.wave.core.util.UUIDUtils;
import com.wave.sysmanage.dao.ScutcheonMapper;
import com.wave.sysmanage.service.ScutcheonService;
import com.wave.sysmanage.vo.ScutcheonVo;
@Service("iScutcheonService")
public class ScutcheonServiceImpl extends BaseServiceImpl implements ScutcheonService {
	
	@Resource(name="scutcheonMapper")
	private ScutcheonMapper scutcheonMapper;
	
	/**
	 * 查询标牌信息
	 */
	@Override
	public ScutcheonVo getScutcheon() {
		ScutcheonVo scutcheonVo = scutcheonMapper.selectScutcheon();
		return scutcheonVo;
	}
	/**
	 * 保存标牌信息
	 */
	@Override
	public int saveScutcheon(ScutcheonVo scutcheonVo) {
		List<ScutcheonVo> list = scutcheonMapper.selectScutcheons();
		int result = 0;
		if(StringUtil.isNotEmpty(list) && list.size() > 0){
			result = scutcheonMapper.update(scutcheonVo);
		}else{
			scutcheonVo.setId(UUIDUtils.getUUID());
			result = scutcheonMapper.insert(scutcheonVo);
		}
		return result;
	}
}
