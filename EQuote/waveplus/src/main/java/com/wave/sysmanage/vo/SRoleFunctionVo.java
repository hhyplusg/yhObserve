package com.wave.sysmanage.vo;

public class SRoleFunctionVo {
    private String functionId;

    private String roleId;

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId == null ? null : functionId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

	@Override
	public String toString() {
		return "SRoleFunctionVo [functionId=" + functionId + ", roleId="
				+ roleId + "]";
	}
}