package com.wave.common.vo;

import java.io.Serializable;

import com.wave.base.vo.BaseVo;
import com.wave.core.util.StringUtil;

public class SLogsVo extends BaseVo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 9049456622382334486L;

	private String logid;

    private String userno;

    private String optCode;

    private String optType;

    private String optInfo;

    private String optTime;

    private String userIp;
    
    private Integer orgType;
    
    private String areaCode;
    
    public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid == null ? null : logid.trim();
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = StringUtil.sqliteEscape(userno);
    }

    public String getOptCode() {
        return optCode;
    }

    public void setOptCode(String optCode) {
        this.optCode = optCode;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getOptInfo() {
        return optInfo;
    }

    public void setOptInfo(String optInfo) {
        this.optInfo = StringUtil.sqliteEscape(optInfo);
    }

    public String getOptTime() {
        return optTime;
    }

    public void setOptTime(String optTime) {
        this.optTime = optTime;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

	public Integer getOrgType() {
		return orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
    
}