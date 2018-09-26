package com.test.vo.entity;

import com.wave.base.vo.BaseVo;
import java.io.Serializable;

public class JInnerOrgRec extends BaseVo implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.ID
	 * @mbg.generated
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.inner_org_id
	 * @mbg.generated
	 */
	private String innerOrgId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.inner_org_encode
	 * @mbg.generated
	 */
	private String innerOrgEncode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.area_code
	 * @mbg.generated
	 */
	private String areaCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.org_id
	 * @mbg.generated
	 */
	private String orgId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.org_name
	 * @mbg.generated
	 */
	private String orgName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.other_name
	 * @mbg.generated
	 */
	private String otherName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.org_sname
	 * @mbg.generated
	 */
	private String orgSname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.org_level_id
	 * @mbg.generated
	 */
	private String orgLevelId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.piwen_id
	 * @mbg.generated
	 */
	private String piwenId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.pw_code
	 * @mbg.generated
	 */
	private String pwCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.org_category_id
	 * @mbg.generated
	 */
	private String orgCategoryId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.inner_org_category_id
	 * @mbg.generated
	 */
	private String innerOrgCategoryId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.inner_org_category_sub_id
	 * @mbg.generated
	 */
	private String innerOrgCategorySubId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.telphone
	 * @mbg.generated
	 */
	private String telphone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.xz_count
	 * @mbg.generated
	 */
	private Integer xzCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.gq_count
	 * @mbg.generated
	 */
	private Integer gqCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.other_count
	 * @mbg.generated
	 */
	private Integer otherCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.approved_leader_count
	 * @mbg.generated
	 */
	private Integer approvedLeaderCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.approved_vice_lead_count
	 * @mbg.generated
	 */
	private Integer approvedViceLeadCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.approved_not_lead_count
	 * @mbg.generated
	 */
	private Integer approvedNotLeadCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.approved_not_vice_lead_count
	 * @mbg.generated
	 */
	private Integer approvedNotViceLeadCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.remark
	 * @mbg.generated
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.status
	 * @mbg.generated
	 */
	private String status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column j_inner_org_rec.createtime
	 * @mbg.generated
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table j_inner_org_rec
	 * @mbg.generated
	 */
	private static final long serialVersionUID = 4934676238107849831L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.ID
	 * @return  the value of j_inner_org_rec.ID
	 * @mbg.generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.ID
	 * @param id  the value for j_inner_org_rec.ID
	 * @mbg.generated
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.inner_org_id
	 * @return  the value of j_inner_org_rec.inner_org_id
	 * @mbg.generated
	 */
	public String getInnerOrgId() {
		return innerOrgId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.inner_org_id
	 * @param innerOrgId  the value for j_inner_org_rec.inner_org_id
	 * @mbg.generated
	 */
	public void setInnerOrgId(String innerOrgId) {
		this.innerOrgId = innerOrgId == null ? null : innerOrgId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.inner_org_encode
	 * @return  the value of j_inner_org_rec.inner_org_encode
	 * @mbg.generated
	 */
	public String getInnerOrgEncode() {
		return innerOrgEncode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.inner_org_encode
	 * @param innerOrgEncode  the value for j_inner_org_rec.inner_org_encode
	 * @mbg.generated
	 */
	public void setInnerOrgEncode(String innerOrgEncode) {
		this.innerOrgEncode = innerOrgEncode == null ? null : innerOrgEncode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.area_code
	 * @return  the value of j_inner_org_rec.area_code
	 * @mbg.generated
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.area_code
	 * @param areaCode  the value for j_inner_org_rec.area_code
	 * @mbg.generated
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode == null ? null : areaCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.org_id
	 * @return  the value of j_inner_org_rec.org_id
	 * @mbg.generated
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.org_id
	 * @param orgId  the value for j_inner_org_rec.org_id
	 * @mbg.generated
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.org_name
	 * @return  the value of j_inner_org_rec.org_name
	 * @mbg.generated
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.org_name
	 * @param orgName  the value for j_inner_org_rec.org_name
	 * @mbg.generated
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.other_name
	 * @return  the value of j_inner_org_rec.other_name
	 * @mbg.generated
	 */
	public String getOtherName() {
		return otherName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.other_name
	 * @param otherName  the value for j_inner_org_rec.other_name
	 * @mbg.generated
	 */
	public void setOtherName(String otherName) {
		this.otherName = otherName == null ? null : otherName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.org_sname
	 * @return  the value of j_inner_org_rec.org_sname
	 * @mbg.generated
	 */
	public String getOrgSname() {
		return orgSname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.org_sname
	 * @param orgSname  the value for j_inner_org_rec.org_sname
	 * @mbg.generated
	 */
	public void setOrgSname(String orgSname) {
		this.orgSname = orgSname == null ? null : orgSname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.org_level_id
	 * @return  the value of j_inner_org_rec.org_level_id
	 * @mbg.generated
	 */
	public String getOrgLevelId() {
		return orgLevelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.org_level_id
	 * @param orgLevelId  the value for j_inner_org_rec.org_level_id
	 * @mbg.generated
	 */
	public void setOrgLevelId(String orgLevelId) {
		this.orgLevelId = orgLevelId == null ? null : orgLevelId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.piwen_id
	 * @return  the value of j_inner_org_rec.piwen_id
	 * @mbg.generated
	 */
	public String getPiwenId() {
		return piwenId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.piwen_id
	 * @param piwenId  the value for j_inner_org_rec.piwen_id
	 * @mbg.generated
	 */
	public void setPiwenId(String piwenId) {
		this.piwenId = piwenId == null ? null : piwenId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.pw_code
	 * @return  the value of j_inner_org_rec.pw_code
	 * @mbg.generated
	 */
	public String getPwCode() {
		return pwCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.pw_code
	 * @param pwCode  the value for j_inner_org_rec.pw_code
	 * @mbg.generated
	 */
	public void setPwCode(String pwCode) {
		this.pwCode = pwCode == null ? null : pwCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.org_category_id
	 * @return  the value of j_inner_org_rec.org_category_id
	 * @mbg.generated
	 */
	public String getOrgCategoryId() {
		return orgCategoryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.org_category_id
	 * @param orgCategoryId  the value for j_inner_org_rec.org_category_id
	 * @mbg.generated
	 */
	public void setOrgCategoryId(String orgCategoryId) {
		this.orgCategoryId = orgCategoryId == null ? null : orgCategoryId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.inner_org_category_id
	 * @return  the value of j_inner_org_rec.inner_org_category_id
	 * @mbg.generated
	 */
	public String getInnerOrgCategoryId() {
		return innerOrgCategoryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.inner_org_category_id
	 * @param innerOrgCategoryId  the value for j_inner_org_rec.inner_org_category_id
	 * @mbg.generated
	 */
	public void setInnerOrgCategoryId(String innerOrgCategoryId) {
		this.innerOrgCategoryId = innerOrgCategoryId == null ? null : innerOrgCategoryId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.inner_org_category_sub_id
	 * @return  the value of j_inner_org_rec.inner_org_category_sub_id
	 * @mbg.generated
	 */
	public String getInnerOrgCategorySubId() {
		return innerOrgCategorySubId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.inner_org_category_sub_id
	 * @param innerOrgCategorySubId  the value for j_inner_org_rec.inner_org_category_sub_id
	 * @mbg.generated
	 */
	public void setInnerOrgCategorySubId(String innerOrgCategorySubId) {
		this.innerOrgCategorySubId = innerOrgCategorySubId == null ? null : innerOrgCategorySubId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.telphone
	 * @return  the value of j_inner_org_rec.telphone
	 * @mbg.generated
	 */
	public String getTelphone() {
		return telphone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.telphone
	 * @param telphone  the value for j_inner_org_rec.telphone
	 * @mbg.generated
	 */
	public void setTelphone(String telphone) {
		this.telphone = telphone == null ? null : telphone.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.xz_count
	 * @return  the value of j_inner_org_rec.xz_count
	 * @mbg.generated
	 */
	public Integer getXzCount() {
		return xzCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.xz_count
	 * @param xzCount  the value for j_inner_org_rec.xz_count
	 * @mbg.generated
	 */
	public void setXzCount(Integer xzCount) {
		this.xzCount = xzCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.gq_count
	 * @return  the value of j_inner_org_rec.gq_count
	 * @mbg.generated
	 */
	public Integer getGqCount() {
		return gqCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.gq_count
	 * @param gqCount  the value for j_inner_org_rec.gq_count
	 * @mbg.generated
	 */
	public void setGqCount(Integer gqCount) {
		this.gqCount = gqCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.other_count
	 * @return  the value of j_inner_org_rec.other_count
	 * @mbg.generated
	 */
	public Integer getOtherCount() {
		return otherCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.other_count
	 * @param otherCount  the value for j_inner_org_rec.other_count
	 * @mbg.generated
	 */
	public void setOtherCount(Integer otherCount) {
		this.otherCount = otherCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.approved_leader_count
	 * @return  the value of j_inner_org_rec.approved_leader_count
	 * @mbg.generated
	 */
	public Integer getApprovedLeaderCount() {
		return approvedLeaderCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.approved_leader_count
	 * @param approvedLeaderCount  the value for j_inner_org_rec.approved_leader_count
	 * @mbg.generated
	 */
	public void setApprovedLeaderCount(Integer approvedLeaderCount) {
		this.approvedLeaderCount = approvedLeaderCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.approved_vice_lead_count
	 * @return  the value of j_inner_org_rec.approved_vice_lead_count
	 * @mbg.generated
	 */
	public Integer getApprovedViceLeadCount() {
		return approvedViceLeadCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.approved_vice_lead_count
	 * @param approvedViceLeadCount  the value for j_inner_org_rec.approved_vice_lead_count
	 * @mbg.generated
	 */
	public void setApprovedViceLeadCount(Integer approvedViceLeadCount) {
		this.approvedViceLeadCount = approvedViceLeadCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.approved_not_lead_count
	 * @return  the value of j_inner_org_rec.approved_not_lead_count
	 * @mbg.generated
	 */
	public Integer getApprovedNotLeadCount() {
		return approvedNotLeadCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.approved_not_lead_count
	 * @param approvedNotLeadCount  the value for j_inner_org_rec.approved_not_lead_count
	 * @mbg.generated
	 */
	public void setApprovedNotLeadCount(Integer approvedNotLeadCount) {
		this.approvedNotLeadCount = approvedNotLeadCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.approved_not_vice_lead_count
	 * @return  the value of j_inner_org_rec.approved_not_vice_lead_count
	 * @mbg.generated
	 */
	public Integer getApprovedNotViceLeadCount() {
		return approvedNotViceLeadCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.approved_not_vice_lead_count
	 * @param approvedNotViceLeadCount  the value for j_inner_org_rec.approved_not_vice_lead_count
	 * @mbg.generated
	 */
	public void setApprovedNotViceLeadCount(Integer approvedNotViceLeadCount) {
		this.approvedNotViceLeadCount = approvedNotViceLeadCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.remark
	 * @return  the value of j_inner_org_rec.remark
	 * @mbg.generated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.remark
	 * @param remark  the value for j_inner_org_rec.remark
	 * @mbg.generated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.status
	 * @return  the value of j_inner_org_rec.status
	 * @mbg.generated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.status
	 * @param status  the value for j_inner_org_rec.status
	 * @mbg.generated
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column j_inner_org_rec.createtime
	 * @return  the value of j_inner_org_rec.createtime
	 * @mbg.generated
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column j_inner_org_rec.createtime
	 * @param createtime  the value for j_inner_org_rec.createtime
	 * @mbg.generated
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table j_inner_org_rec
	 * @mbg.generated
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		JInnerOrgRec other = (JInnerOrgRec) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getInnerOrgId() == null ? other.getInnerOrgId() == null
						: this.getInnerOrgId().equals(other.getInnerOrgId()))
				&& (this.getInnerOrgEncode() == null ? other.getInnerOrgEncode() == null
						: this.getInnerOrgEncode().equals(other.getInnerOrgEncode()))
				&& (this.getAreaCode() == null ? other.getAreaCode() == null
						: this.getAreaCode().equals(other.getAreaCode()))
				&& (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
				&& (this.getOrgName() == null ? other.getOrgName() == null
						: this.getOrgName().equals(other.getOrgName()))
				&& (this.getOtherName() == null ? other.getOtherName() == null
						: this.getOtherName().equals(other.getOtherName()))
				&& (this.getOrgSname() == null ? other.getOrgSname() == null
						: this.getOrgSname().equals(other.getOrgSname()))
				&& (this.getOrgLevelId() == null ? other.getOrgLevelId() == null
						: this.getOrgLevelId().equals(other.getOrgLevelId()))
				&& (this.getPiwenId() == null ? other.getPiwenId() == null
						: this.getPiwenId().equals(other.getPiwenId()))
				&& (this.getPwCode() == null ? other.getPwCode() == null : this.getPwCode().equals(other.getPwCode()))
				&& (this.getOrgCategoryId() == null ? other.getOrgCategoryId() == null
						: this.getOrgCategoryId().equals(other.getOrgCategoryId()))
				&& (this.getInnerOrgCategoryId() == null ? other.getInnerOrgCategoryId() == null
						: this.getInnerOrgCategoryId().equals(other.getInnerOrgCategoryId()))
				&& (this.getInnerOrgCategorySubId() == null ? other.getInnerOrgCategorySubId() == null
						: this.getInnerOrgCategorySubId().equals(other.getInnerOrgCategorySubId()))
				&& (this.getTelphone() == null ? other.getTelphone() == null
						: this.getTelphone().equals(other.getTelphone()))
				&& (this.getXzCount() == null ? other.getXzCount() == null
						: this.getXzCount().equals(other.getXzCount()))
				&& (this.getGqCount() == null ? other.getGqCount() == null
						: this.getGqCount().equals(other.getGqCount()))
				&& (this.getOtherCount() == null ? other.getOtherCount() == null
						: this.getOtherCount().equals(other.getOtherCount()))
				&& (this.getApprovedLeaderCount() == null ? other.getApprovedLeaderCount() == null
						: this.getApprovedLeaderCount().equals(other.getApprovedLeaderCount()))
				&& (this.getApprovedViceLeadCount() == null ? other.getApprovedViceLeadCount() == null
						: this.getApprovedViceLeadCount().equals(other.getApprovedViceLeadCount()))
				&& (this.getApprovedNotLeadCount() == null ? other.getApprovedNotLeadCount() == null
						: this.getApprovedNotLeadCount().equals(other.getApprovedNotLeadCount()))
				&& (this.getApprovedNotViceLeadCount() == null ? other.getApprovedNotViceLeadCount() == null
						: this.getApprovedNotViceLeadCount().equals(other.getApprovedNotViceLeadCount()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getCreater() == null ? other.getCreater() == null
						: this.getCreater().equals(other.getCreater()))
				&& (this.getCreatetime() == null ? other.getCreatetime() == null
						: this.getCreatetime().equals(other.getCreatetime()))
				&& (this.getUpdater() == null ? other.getUpdater() == null
						: this.getUpdater().equals(other.getUpdater()))
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null
						: this.getUpdateTime().equals(other.getUpdateTime()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table j_inner_org_rec
	 * @mbg.generated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getInnerOrgId() == null) ? 0 : getInnerOrgId().hashCode());
		result = prime * result + ((getInnerOrgEncode() == null) ? 0 : getInnerOrgEncode().hashCode());
		result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
		result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
		result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
		result = prime * result + ((getOtherName() == null) ? 0 : getOtherName().hashCode());
		result = prime * result + ((getOrgSname() == null) ? 0 : getOrgSname().hashCode());
		result = prime * result + ((getOrgLevelId() == null) ? 0 : getOrgLevelId().hashCode());
		result = prime * result + ((getPiwenId() == null) ? 0 : getPiwenId().hashCode());
		result = prime * result + ((getPwCode() == null) ? 0 : getPwCode().hashCode());
		result = prime * result + ((getOrgCategoryId() == null) ? 0 : getOrgCategoryId().hashCode());
		result = prime * result + ((getInnerOrgCategoryId() == null) ? 0 : getInnerOrgCategoryId().hashCode());
		result = prime * result + ((getInnerOrgCategorySubId() == null) ? 0 : getInnerOrgCategorySubId().hashCode());
		result = prime * result + ((getTelphone() == null) ? 0 : getTelphone().hashCode());
		result = prime * result + ((getXzCount() == null) ? 0 : getXzCount().hashCode());
		result = prime * result + ((getGqCount() == null) ? 0 : getGqCount().hashCode());
		result = prime * result + ((getOtherCount() == null) ? 0 : getOtherCount().hashCode());
		result = prime * result + ((getApprovedLeaderCount() == null) ? 0 : getApprovedLeaderCount().hashCode());
		result = prime * result + ((getApprovedViceLeadCount() == null) ? 0 : getApprovedViceLeadCount().hashCode());
		result = prime * result + ((getApprovedNotLeadCount() == null) ? 0 : getApprovedNotLeadCount().hashCode());
		result = prime * result
				+ ((getApprovedNotViceLeadCount() == null) ? 0 : getApprovedNotViceLeadCount().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
		result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
		result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
		result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table j_inner_org_rec
	 * @mbg.generated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", innerOrgId=").append(innerOrgId);
		sb.append(", innerOrgEncode=").append(innerOrgEncode);
		sb.append(", areaCode=").append(areaCode);
		sb.append(", orgId=").append(orgId);
		sb.append(", orgName=").append(orgName);
		sb.append(", otherName=").append(otherName);
		sb.append(", orgSname=").append(orgSname);
		sb.append(", orgLevelId=").append(orgLevelId);
		sb.append(", piwenId=").append(piwenId);
		sb.append(", pwCode=").append(pwCode);
		sb.append(", orgCategoryId=").append(orgCategoryId);
		sb.append(", innerOrgCategoryId=").append(innerOrgCategoryId);
		sb.append(", innerOrgCategorySubId=").append(innerOrgCategorySubId);
		sb.append(", telphone=").append(telphone);
		sb.append(", xzCount=").append(xzCount);
		sb.append(", gqCount=").append(gqCount);
		sb.append(", otherCount=").append(otherCount);
		sb.append(", approvedLeaderCount=").append(approvedLeaderCount);
		sb.append(", approvedViceLeadCount=").append(approvedViceLeadCount);
		sb.append(", approvedNotLeadCount=").append(approvedNotLeadCount);
		sb.append(", approvedNotViceLeadCount=").append(approvedNotViceLeadCount);
		sb.append(", remark=").append(remark);
		sb.append(", status=").append(status);
		sb.append(", createtime=").append(createtime);
		sb.append("]");
		return sb.toString();
	}
}