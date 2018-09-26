package com.wave.sysmanage.vo;

import java.util.ArrayList;
import java.util.List;

import com.wave.base.vo.BaseVo;
import com.wave.core.plugin.mybatis.PageVo;

public class SelectUserConditionVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6097211061941773045L;
	
	private String areaCode;
	
	private String cityCode;
	
	private String countyCode;
	
	private String sysCode;
	
	private String orgId;
	
	private String orgEncode;
	
	private String userName;
	
	private String userLoginName;
	
	private String orgName;
	
	private String status;
	
	private int searchNext;
	
	private int searchSysUser;
	
	private int searchOrgUser;
	
	private List<String> areaList = new ArrayList<String>();
	
	private List<String> orgList = new ArrayList<String>();
	
	private PageVo pageVo;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	public String getOrgEncode() {
		return orgEncode;
	}

	public void setOrgEncode(String orgEncode) {
		this.orgEncode = orgEncode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSearchNext() {
		return searchNext;
	}

	public void setSearchNext(int searchNext) {
		this.searchNext = searchNext;
	}

	public int getSearchSysUser() {
		return searchSysUser;
	}

	public void setSearchSysUser(int searchSysUser) {
		this.searchSysUser = searchSysUser;
	}

	public int getSearchOrgUser() {
		return searchOrgUser;
	}

	public void setSearchOrgUser(int searchOrgUser) {
		this.searchOrgUser = searchOrgUser;
	}
	
	public List<String> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
	}

	public List<String> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<String> orgList) {
		this.orgList = orgList;
	}

	public PageVo getPageVo() {
		return pageVo;
	}

	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}
	
}
