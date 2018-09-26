package com.wave.sysmanage.vo;

import java.util.List;

public class AreaRoleTreeVo {
	

    private String treeCode;
    
    private String treePid;

    private String treeName;
    
    private String roleType;
    
    private String remark;
    
    private String updater;
    
    private String updatetime;
    
    private List<AreaRoleTreeVo> roleList;

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}
	
	public String getTreePid() {
		return treePid;
	}

	public void setTreePid(String treePid) {
		this.treePid = treePid;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdatetime() {
		/*try {
			if(StringUtil.isNotEmpty(updatetime))
				updatetime = DateUtil.changeDateFormat("yyyyMMdd hh:mm:ss", "yyyy-MM-dd hh:mm:ss", updatetime.substring(0,19));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public List<AreaRoleTreeVo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<AreaRoleTreeVo> roleList) {
		this.roleList = roleList;
	}

}
