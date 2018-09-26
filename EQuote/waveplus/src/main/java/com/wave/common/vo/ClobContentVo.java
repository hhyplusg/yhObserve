package com.wave.common.vo;

import com.wave.core.util.StringUtil;

/**
 * @author H
 *
 */
public class ClobContentVo {
	private String id;
	// 机构ID
    private String orgId;
    //区划代码
    private String areaCode; 
	private String bizDataId;
	
	private String content;
	
	private String bizType;
	
	private String updateTime;
	 
    /**
     * @return the updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBizDataId() {
		return bizDataId;
	}

	public void setBizDataId(String bizDataId) {
		this.bizDataId = bizDataId;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = StringUtil.sqliteEscape(content);
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ClobContentVo [id=" + id + ", orgId=" + orgId + ", areaCode=" + areaCode + ", bizDataId=" + bizDataId + ", content=" + content + ", bizType=" + bizType + ", updateTime=" + updateTime + "]";
    }

    /**
     * @return the orgId
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode the areaCode to set
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

	 
	
	
}
