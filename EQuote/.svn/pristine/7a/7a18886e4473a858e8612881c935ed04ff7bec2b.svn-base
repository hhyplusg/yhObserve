package com.wave.sysmanage.vo;

import com.wave.base.vo.BaseVo;
import com.wave.core.plugin.mybatis.PageVo;
import com.wave.core.util.DateUtil;
import com.wave.core.util.StringUtil;
/**
 * 
 * @author lenovo
 *
 */
public class SOperationLogsInfoVo extends BaseVo{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7469754552877121272L;

	private String id;

    private String userName;

    private String userIp;

    private String bizName;

    private String optFunctionName;

    private String optInfo;

    private String optTime;
    
    private String optTimeView;

    private String logType;
    
    private PageVo pageVo;
    
    private String startTime;
    
    private String endTime;
    
    private String keyWord;   
    
    
    
    
    /**
     * 构造函数
     */
    public SOperationLogsInfoVo() {
    }
    /**
     * 添加操作日志
     * SOperationLogsInfoVo构造函数
     * @param id UUID
     * @param userName 用户名称
     * @param userIp 用户IP
     * @param bizName 业务模块名称
     * @param optFunctionName 操作工作名称
     * @param logType 日志类型 O：操作日志 S:系统日志
     * @param optInfo 操作内容 
     */
	public SOperationLogsInfoVo(String id, String userName, 
	        String userIp, String bizName, String optFunctionName, 
	        String logType, String optInfo) {
        super();
        this.id = id;
        this.userName = userName;
        this.userIp = userIp;
        this.bizName = bizName;
        this.optFunctionName = optFunctionName;
        this.optInfo = optInfo; 
        this.logType = logType;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getBizName() {
		return bizName;
	}
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
	public String getOptFunctionName() {
		return optFunctionName;
	}
	public void setOptFunctionName(String optFunctionName) {
		this.optFunctionName = optFunctionName;
	}
	public String getOptInfo() {
		return optInfo;
	}
	public void setOptInfo(String optInfo) {
		this.optInfo = optInfo;
	}
	public String getOptTime() {
		
		return optTime;
	}
	public void setOptTime(String optTime) {
		this.optTime = optTime;
	}
	public String getOptTimeView() {
		return optTimeView;
	}
	public void setOptTimeView(String optTimeView) {
		this.optTimeView = optTimeView;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public PageVo getPageVo() {
		return pageVo;
	}
	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}
	public String getStartTime() {
		if(StringUtil.isNotNull(startTime)) {
			return DateUtil.format(DateUtil.parse(this.startTime),"yyyy-MM-dd");
		}
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		if(StringUtil.isNotNull(endTime)) {
			return DateUtil.format(DateUtil.parse(this.endTime),"yyyy-MM-dd");
		}
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	@Override
	public String toString() {
		return "SOperationLogsInfoVo [id=" + id + ", userName=" + userName
				+ ", userIp=" + userIp + ", bizName=" + bizName
				+ ", optFunctionName=" + optFunctionName + ", optInfo="
				+ optInfo + ", optTime=" + optTime + ", optTimeView="
				+ optTimeView + ", logType=" + logType + ", pageVo=" + pageVo
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", keyWord=" + keyWord + ", getPagesize()=" + getPagesize()
				+ ", getTotalResultsCount()=" + getTotalResultsCount()
				+ ", getPagenum()=" + getPagenum() + ", getCreater()="
				+ getCreater() + ", getCreateTime()=" + getCreateTime()
				+ ", getUpdater()=" + getUpdater() + ", getUpdateTime()="
				+ getUpdateTime() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}