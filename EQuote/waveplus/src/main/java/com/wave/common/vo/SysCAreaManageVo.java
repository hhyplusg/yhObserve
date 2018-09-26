package com.wave.common.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.wave.base.vo.BaseVo;
import com.wave.core.util.StringUtil;

@Alias("SysCAreaManageVo")
public class SysCAreaManageVo extends BaseVo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8018442876642902856L;
	
	private String areaShortName;
	
	private String id;

    private String pid;

    private String provinceCode;

    private String cityCode;

    private String countyCode;

    private String areaCode;

    private String areaName;

    private String areaFullName;
    
    private String orgLevelId;

    private String description;

    private Integer sortSerialNo;

    private String totalFuzzySwitch;

    private String dingbiandaorenSwitch;
    
    private String strictnessPostCountWhitch;

    private String yongbianApprovedSwitch;

    private String yongbianApprovedAcceptance;

    private String yongbianApprovedReview;

    private String yongbianApprovedApproval;

    private String orgApprovedSwitch;

    private String orgApprovedAcceptance;

    private String orgApprovedReview;

    private String orgApprovedApproval;

    private String staffApprovedSwitch;

    private String staffApprovedAcceptance;

    private String staffApprovedReview;

    private String staffApprovedApproval;

    private String remark;

    private String status;
    
    private List<SysCAreaManageVo> child;
    
    private String check;
    
    private String approvalStatus;

     
    
    public String getOrgLevelId() {
		return orgLevelId;
	}

	public void setOrgLevelId(String orgLevelId) {
		this.orgLevelId = orgLevelId;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SysCAreaManageVo [id=" + id + ", pid=" + pid + ", provinceCode=" + provinceCode + ", cityCode=" + cityCode + ", countyCode=" + countyCode + ", areaCode=" + areaCode + ", areaName=" + areaName + ", areaFullName=" + areaFullName + ", description=" + description + ", sortSerialNo=" + sortSerialNo + ", totalFuzzySwitch=" + totalFuzzySwitch + ", dingbiandaorenSwitch="
                + dingbiandaorenSwitch + ", strictnessPostCountWhitch=" + strictnessPostCountWhitch + ", yongbianApprovedSwitch=" + yongbianApprovedSwitch + ", yongbianApprovedAcceptance=" + yongbianApprovedAcceptance + ", yongbianApprovedReview=" + yongbianApprovedReview + ", yongbianApprovedApproval=" + yongbianApprovedApproval + ", orgApprovedSwitch=" + orgApprovedSwitch
                + ", orgApprovedAcceptance=" + orgApprovedAcceptance + ", orgApprovedReview=" + orgApprovedReview + ", orgApprovedApproval=" + orgApprovedApproval + ", staffApprovedSwitch=" + staffApprovedSwitch + ", staffApprovedAcceptance=" + staffApprovedAcceptance + ", staffApprovedReview=" + staffApprovedReview + ", staffApprovedApproval=" + staffApprovedApproval + ", remark=" + remark
                + ", status=" + status + ", child=" + child + ", creater=" + creater + ", createtime=" + createTime + ", updater=" + updater + ", updateTime=" + updateTime + ", check=" + check + ", approvalStatus=" + approvalStatus + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    /**
     * @return the strictnessPostCountWhitch
     */
    public String getStrictnessPostCountWhitch() {
        return strictnessPostCountWhitch;
    }

    /**
     * @param strictnessPostCountWhitch the strictnessPostCountWhitch to set
     */
    public void setStrictnessPostCountWhitch(String strictnessPostCountWhitch) {
        this.strictnessPostCountWhitch = strictnessPostCountWhitch;
    }

    /**
     * @return the check
     */
    public String getCheck() {
        return check;
    }

    /**
     * @param check the check to set
     */
    public void setCheck(String check) {
        this.check = check;
    }

    /**
     * @return the approvalStatus
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * @param approvalStatus the approvalStatus to set
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
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

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : StringUtil.sqliteEscape(areaName);
    }

    public String getAreaFullName() {
        return areaFullName;
    }

    public void setAreaFullName(String areaFullName) {
        this.areaFullName = areaFullName == null ? null : StringUtil.sqliteEscape(areaFullName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSortSerialNo() {
        return sortSerialNo;
    }

    public void setSortSerialNo(Integer sortSerialNo) {
        this.sortSerialNo = sortSerialNo;
    }

    public String getTotalFuzzySwitch() {
        return totalFuzzySwitch;
    }

    public void setTotalFuzzySwitch(String totalFuzzySwitch) {
        this.totalFuzzySwitch = totalFuzzySwitch == null ? null : totalFuzzySwitch.trim();
    }

    public String getDingbiandaorenSwitch() {
        return dingbiandaorenSwitch;
    }

    public void setDingbiandaorenSwitch(String dingbiandaorenSwitch) {
        this.dingbiandaorenSwitch = dingbiandaorenSwitch == null ? null : dingbiandaorenSwitch.trim();
    }

    public String getYongbianApprovedSwitch() {
        return yongbianApprovedSwitch;
    }

    public void setYongbianApprovedSwitch(String yongbianApprovedSwitch) {
        this.yongbianApprovedSwitch = yongbianApprovedSwitch == null ? null : yongbianApprovedSwitch.trim();
    }

    public String getYongbianApprovedAcceptance() {
        return yongbianApprovedAcceptance;
    }

    public void setYongbianApprovedAcceptance(String yongbianApprovedAcceptance) {
        this.yongbianApprovedAcceptance = yongbianApprovedAcceptance == null ? null : yongbianApprovedAcceptance.trim();
    }

    public String getYongbianApprovedReview() {
        return yongbianApprovedReview;
    }

    public void setYongbianApprovedReview(String yongbianApprovedReview) {
        this.yongbianApprovedReview = yongbianApprovedReview == null ? null : yongbianApprovedReview.trim();
    }

    public String getYongbianApprovedApproval() {
        return yongbianApprovedApproval;
    }

    public void setYongbianApprovedApproval(String yongbianApprovedApproval) {
        this.yongbianApprovedApproval = yongbianApprovedApproval == null ? null : yongbianApprovedApproval.trim();
    }

    public String getOrgApprovedSwitch() {
        return orgApprovedSwitch;
    }

    public void setOrgApprovedSwitch(String orgApprovedSwitch) {
        this.orgApprovedSwitch = orgApprovedSwitch == null ? null : orgApprovedSwitch.trim();
    }

    public String getOrgApprovedAcceptance() {
        return orgApprovedAcceptance;
    }

    public void setOrgApprovedAcceptance(String orgApprovedAcceptance) {
        this.orgApprovedAcceptance = orgApprovedAcceptance == null ? null : orgApprovedAcceptance.trim();
    }

    public String getOrgApprovedReview() {
        return orgApprovedReview;
    }

    public void setOrgApprovedReview(String orgApprovedReview) {
        this.orgApprovedReview = orgApprovedReview == null ? null : orgApprovedReview.trim();
    }

    public String getOrgApprovedApproval() {
        return orgApprovedApproval;
    }

    public void setOrgApprovedApproval(String orgApprovedApproval) {
        this.orgApprovedApproval = orgApprovedApproval == null ? null : orgApprovedApproval.trim();
    }

    public String getStaffApprovedSwitch() {
        return staffApprovedSwitch;
    }

    public void setStaffApprovedSwitch(String staffApprovedSwitch) {
        this.staffApprovedSwitch = staffApprovedSwitch == null ? null : staffApprovedSwitch.trim();
    }

    public String getStaffApprovedAcceptance() {
        return staffApprovedAcceptance;
    }

    public void setStaffApprovedAcceptance(String staffApprovedAcceptance) {
        this.staffApprovedAcceptance = staffApprovedAcceptance == null ? null : staffApprovedAcceptance.trim();
    }

    public String getStaffApprovedReview() {
        return staffApprovedReview;
    }

    public void setStaffApprovedReview(String staffApprovedReview) {
        this.staffApprovedReview = staffApprovedReview == null ? null : staffApprovedReview.trim();
    }

    public String getStaffApprovedApproval() {
        return staffApprovedApproval;
    }

    public void setStaffApprovedApproval(String staffApprovedApproval) {
        this.staffApprovedApproval = staffApprovedApproval == null ? null : staffApprovedApproval.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public List<SysCAreaManageVo> getChild() {
		return child;
	}

	public void setChild(List<SysCAreaManageVo> child) {
		this.child = child;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAreaShortName() {
		return areaShortName;
	}

	public void setAreaShortName(String areaShortName) {
		this.areaShortName = areaShortName;
	}
	
	
    
}