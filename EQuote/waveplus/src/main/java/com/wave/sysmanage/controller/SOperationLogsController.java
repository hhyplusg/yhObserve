package com.wave.sysmanage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wave.base.action.BaseController;
import com.wave.base.action.ClientDatatModel;
import com.wave.common.cnstants.Constants;
import com.wave.common.cnstants.ModulesConstants;
import com.wave.core.plugin.mybatis.PageVo;
import com.wave.sysmanage.service.SOperationLogsInfoService;
import com.wave.sysmanage.vo.SOperationLogsInfoVo;

@Controller
@ResponseBody
public class SOperationLogsController extends BaseController {
	
	@Autowired 
	@Qualifier("iSOperationLogsInfoService")
	private SOperationLogsInfoService iSOperationLogsInfoService; 
	
	/**
	 * 分页获得日志信息，同时包含查询条件
	 * */
	@RequestMapping("getLogInfo")
	public ClientDatatModel<List<SOperationLogsInfoVo>> getLogInfo(HttpServletRequest request,@CookieValue("JSESSIONID") String sessionId,
	        SOperationLogsInfoVo sOperationInfoVo) throws Exception {
	    log.debug("sessionId=" + sessionId);
		ClientDatatModel<List<SOperationLogsInfoVo>> client = new ClientDatatModel<>();
		PageVo pageVo = new PageVo();
		pageVo.setPagenum(sOperationInfoVo.getPagenum());
		pageVo.setPagesize(sOperationInfoVo.getPagesize());
		sOperationInfoVo.setPageVo(pageVo);
		List<SOperationLogsInfoVo> logList = iSOperationLogsInfoService.getLogInfo(sOperationInfoVo);
		
		client.setCode(Constants.CONTROLLER_SUCCE);
		client.setData(logList);
		client.setPagenum(sOperationInfoVo.getPagenum());
		client.setPagesize(sOperationInfoVo.getPagesize());
		client.setTotalResultsCount(sOperationInfoVo.getTotalResultsCount());
		
       
	    // 添加用户操作日志
		super.addOpertationLogs(request,ModulesConstants.OPT_LOGS, ModulesConstants.OPT_LOGS_QUERY,"日志查询");
		return client;
	}
}
