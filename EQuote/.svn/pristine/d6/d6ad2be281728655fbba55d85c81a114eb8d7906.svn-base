package com.wave.sysmanage.vo;


import com.wave.base.vo.BaseVo;
import com.wave.core.util.StringUtil;
//@Alias("SRoleVo")
public class SRoleVo extends BaseVo{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5847585936643926004L;

	private String roleCode;

    private String roleName;

    private String remark;

    private String status;

    private String areaCode;

    private int roleType;
    
    private String copyRole;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : StringUtil.sqliteEscape(roleName);
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

	public String getCopyRole() {
		return copyRole;
	}

	public void setCopyRole(String copyRole) {
		this.copyRole = copyRole;
	}
    
}