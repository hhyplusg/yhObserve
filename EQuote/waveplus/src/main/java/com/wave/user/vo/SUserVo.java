package com.wave.user.vo;

import java.io.Serializable;
import java.util.List;

import com.wave.base.vo.BaseVo;
import com.wave.common.vo.SysCAreaManageVo;
import com.wave.core.util.ConfigUtil;
import com.wave.core.util.Md5Util;
import com.wave.core.util.StringUtil; 
import com.wave.sysmanage.vo.SFunctionInfoVo;
/**
 * 系统用户登陆接口用字段VO
 * */
//@Alias("SUserVo")
public class SUserVo extends BaseVo implements Serializable{
    /**
     * serialVersionUID = -8092001532558168478L;
     */
    private static final long serialVersionUID = -8092001532558168478L;
    // 用户对应的系统功能信息
    private List<SFunctionInfoVo> functionInfoVoList; 
     
    // 用户对应的区划信息
    private SysCAreaManageVo cAreaInfoVo;
    
    private String userId;

    private String areaCode;

    private String orgId;

    private String userLonginName;

    private String userName;

    private String password;

    private String tel;

    private String sex;

    private String lastLoginTime;

    private Integer loginCount;

    private String status;
    /*
     * 系统版本号，用于系统登陆时显示的系统版本号
     */
    private String sysVersion;
    
    private String warnTime; 
    /**
     * @return the sysVersion
     */
    public String getSysVersion() {
        return ConfigUtil.getString("SYS_VERSION");
    }
 

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SUserVo [functionInfoVoList=" + functionInfoVoList + ",  userId=" + userId + ", areaCode=" + areaCode + ", orgId=" + orgId + ", userLonginName=" + userLonginName + ", userName=" + userName + ", password=" + password + ", tel=" + tel + ", sex=" + sex + ", lastLoginTime=" + lastLoginTime + ", loginCount=" + loginCount + ", status=" + status
                + ", sysVersion=" + sysVersion + ", getPagesize()=" + getPagesize() + ", getTotalResultsCount()=" + getTotalResultsCount() + ", getPagenum()=" + getPagenum() + ", getCreater()=" + getCreater() + ", getCreatetime()=" + getCreateTime() + ", getUpdater()=" + getUpdater() + ", getUpdateTime()=" + getUpdateTime() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + "]";
    }
 

    /**
     * @return the functionInfoVoList
     */
    public List<SFunctionInfoVo> getFunctionInfoVoList() {
        return functionInfoVoList;
    }

    /**
     * @param functionInfoVoList the functionInfoVoList to set
     */
    public void setFunctionInfoVoList(List<SFunctionInfoVo> functionInfoVoList) {
        this.functionInfoVoList = functionInfoVoList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getUserLonginName() {
        return userLonginName;
    }

    public void setUserLonginName(String userLonginName) {
        this.userLonginName = userLonginName == null ? null : userLonginName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = StringUtil.sqliteEscape(userName);
    }

    public String getPassword() {
        return Md5Util.encodePassword(password);
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = StringUtil.sqliteEscape(tel);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.trim();
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return the cAreaInfoVo
     */
    public SysCAreaManageVo getcAreaInfoVo() {
        return cAreaInfoVo;
    }

    /**
     * @param cAreaInfoVo the cAreaInfoVo to set
     */
    public void setcAreaInfoVo(SysCAreaManageVo cAreaInfoVo) {
        this.cAreaInfoVo = cAreaInfoVo;
    }

    /**
     * @param sysVersion the sysVersion to set
     */
    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}
 
    
}