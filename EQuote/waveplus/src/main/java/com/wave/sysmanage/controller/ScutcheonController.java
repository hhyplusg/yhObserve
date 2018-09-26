package com.wave.sysmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wave.base.action.BaseController;
import com.wave.base.action.ClientDatatModel;
import com.wave.common.cnstants.Constants;
import com.wave.sysmanage.service.ScutcheonService;
import com.wave.sysmanage.vo.ScutcheonVo;

@Controller
@ResponseBody
public class ScutcheonController extends BaseController {
	
	@Autowired
	private ScutcheonService iScutcheonService;
	
	/**
	 * 查询标牌信息
	 * @return
	 */
	@RequestMapping("showScutcheon")
	public ClientDatatModel<ScutcheonVo> showScutcheon(){
		ClientDatatModel<ScutcheonVo> client = new ClientDatatModel<ScutcheonVo>();
		ScutcheonVo scutcheonVo = iScutcheonService.getScutcheon();
		client.setCode(Constants.CONTROLLER_SUCCE);
		client.setData(scutcheonVo);
		return client;
	}
	
	/**
	 * 保存标牌信息
	 * @param scutcheonVo
	 * @return
	 */
	@RequestMapping("saveScutcheon")
	public ClientDatatModel<String> saveScutcheon(@RequestBody ScutcheonVo scutcheonVo){
		ClientDatatModel<String> client = new ClientDatatModel<String>();
		iScutcheonService.saveScutcheon(scutcheonVo);
		client.setCode(Constants.CONTROLLER_SUCCE);
		return client;
	}
}
