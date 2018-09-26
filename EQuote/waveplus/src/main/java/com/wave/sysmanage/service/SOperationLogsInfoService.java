package com.wave.sysmanage.service;

import java.util.List;

import com.wave.base.service.BaseService;
import com.wave.sysmanage.vo.SOperationLogsInfoVo;

public interface SOperationLogsInfoService extends BaseService {
	public List<SOperationLogsInfoVo> getLogInfo(SOperationLogsInfoVo sOperationInfoVo);
	
	  
   /**
    * 添加操作日志s_operation_logs_info
    * */
    public void addOperationLogs(SOperationLogsInfoVo sOperationLogsInfoVo);	
}
