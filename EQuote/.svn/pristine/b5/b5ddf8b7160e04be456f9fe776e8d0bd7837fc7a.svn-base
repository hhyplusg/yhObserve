package com.wave.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wave.base.constant.BaseConstants;
import com.wave.base.service.impl.BaseServiceImpl;
import com.wave.core.util.DateUtil;
import com.wave.sysmanage.dao.SOperationLogsInfoMapper;
import com.wave.sysmanage.service.SOperationLogsInfoService;
import com.wave.sysmanage.vo.SOperationLogsInfoVo;
@Service("iSOperationLogsInfoService")
public class SOperationLogsInfoServiceImpl extends BaseServiceImpl implements SOperationLogsInfoService {
	
	@Autowired
	private SOperationLogsInfoMapper sOperationLogsInfoMapper;
	@Override
	public List<SOperationLogsInfoVo> getLogInfo(SOperationLogsInfoVo sOperationInfoVo) {
		log.debug(sOperationInfoVo);
		return sOperationLogsInfoMapper.getLogListInfo(sOperationInfoVo);
	}
	
    /**
     * 添加操作日志s_operation_logs_info
     * */
    @Override
    public void addOperationLogs(SOperationLogsInfoVo sOperationInfoVo) {
    	sOperationInfoVo.setOptTime(DateUtil.getNowDate("yyyy-MM-dd HH:mm:ss"));
        if (log.isDebugEnabled()) {
            log.debug("addOperationLogs is start");
            log.debug("传入参数=" + BaseConstants.CRLF + sOperationInfoVo);
        }
        sOperationLogsInfoMapper.insert(sOperationInfoVo);
        log.debug("addOperationLogs is end");
    } 

}
