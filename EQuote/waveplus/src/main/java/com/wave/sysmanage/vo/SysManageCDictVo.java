package com.wave.sysmanage.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.wave.core.util.DateUtil;
import com.wave.core.util.StringUtil;
@Alias("SysManageCDictVo")
public class SysManageCDictVo implements Serializable {
    /**
	 * serialVersionUID = 2479798161273563836L;
	 */
	private static final long serialVersionUID = 2479798161273563836L;

	private String id;

	private Integer sortSerialNo;

    private String pid;
    
    private String value;

    private String dictType;

    private String dictKey;

    private String dictValue;
    
    private String dictValue2;

    private String otherSysKey;
    
    private String checkId;

    private String otherSysValue;
    
    private String otherSysValue2;

    private String remark;

    private String status;

    private String isSysUsed;

    private String creater;

    private String createTime;

    private String updater;

    private String updateTime;
    

    public Integer getSortSerialNo() {
		return sortSerialNo;
	}



	public void setSortSerialNo(Integer sortSerialNo) {
		this.sortSerialNo = sortSerialNo;
	}

	@Override
	public String toString() {
		return "SysManageCDictVo [id=" + id + ", sortSerialNo=" + sortSerialNo
				+ ", pid=" + pid + ", value=" + value + ", dictType="
				+ dictType + ", dictKey=" + dictKey + ", dictValue="
				+ dictValue + ", dictValue2=" + dictValue2 + ", otherSysKey="
				+ otherSysKey + ", checkId=" + checkId + ", otherSysValue="
				+ otherSysValue + ", otherSysValue2=" + otherSysValue2
				+ ", remark=" + remark + ", status=" + status + ", isSysUsed="
				+ isSysUsed + ", creater=" + creater + ", createtime="
				+ createTime + ", updater=" + updater + ", updateTime="
				+ updateTime + "]";
	}



	public String getCheckId() {
		return checkId;
	}



	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}



	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = StringUtil.sqliteEscape(value);
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey == null ? null : dictKey.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : StringUtil.sqliteEscape(dictValue);
    }
    
    public String getDictValue2() {
        return dictValue2;
    }

    public void setDictValue2(String dictValue2) {
        this.dictValue2 = dictValue2 == null ? null : StringUtil.sqliteEscape(dictValue2);
    }

    public String getOtherSysKey() {
        return otherSysKey;
    }

    public void setOtherSysKey(String otherSysKey) {
        this.otherSysKey = otherSysKey == null ? null : otherSysKey.trim();
    }

    public String getOtherSysValue() {
        return otherSysValue;
    }

    public void setOtherSysValue(String otherSysValue) {
        this.otherSysValue = otherSysValue == null ? null : StringUtil.sqliteEscape(otherSysValue);
    }
    
    public String getOtherSysValue2() {
        return otherSysValue2;
    }

    public void setOtherSysValue2(String otherSysValue2) {
        this.otherSysValue2 = otherSysValue2 == null ? null : StringUtil.sqliteEscape(otherSysValue2);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : StringUtil.sqliteEscape(remark);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsSysUsed() {
        return isSysUsed;
    }

    public void setIsSysUsed(String isSysUsed) {
        this.isSysUsed = isSysUsed == null ? null : isSysUsed.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getCreatetime() {
    	 if (this.createTime == null || this.createTime == "null") {
             this.createTime = DateUtil.getTimeStamp();
         }
         return createTime;
    }

    public void setCreatetime(String createtime) {
        this.createTime = createtime == null ? null : createtime.trim();
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
        
    }

    public String getUpdateTime() {
    	if (this.updateTime == null  || this.updateTime == "null") {
            this.updateTime = DateUtil.getTimeStamp();
        }
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}