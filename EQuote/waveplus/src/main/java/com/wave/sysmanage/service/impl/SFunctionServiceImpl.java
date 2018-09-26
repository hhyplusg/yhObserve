package com.wave.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wave.base.service.impl.BaseServiceImpl;
import com.wave.sysmanage.dao.SFunctionManageMapper;
import com.wave.sysmanage.service.SFunctionService;
import com.wave.sysmanage.vo.SFunctionInfoVo;
@Service("sFunctionService")
public class SFunctionServiceImpl extends BaseServiceImpl implements SFunctionService {
	@Resource(name="SFunctionManageMapper")
	SFunctionManageMapper sFunctionInfoMapper;
	public List<SFunctionInfoVo> getFunctionTree(){
		List<SFunctionInfoVo> menuList = sFunctionInfoMapper.selectFunctionByTypeAndPid("10", "0");
		List<SFunctionInfoVo> indexList = new ArrayList<SFunctionInfoVo>();
		for (SFunctionInfoVo sFunctionInfoVo : menuList) {
			List<SFunctionInfoVo> functionList = sFunctionInfoMapper.selectFunctionByTypeAndPid("20", sFunctionInfoVo.getId());
			if(functionList.size()>0){
				sFunctionInfoVo.setFunctionList(functionList);
			}
		}
		for(SFunctionInfoVo sFunctionInfoVo : indexList){
			menuList.remove(sFunctionInfoVo);
		}
		return menuList;
	}
}
