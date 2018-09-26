package com.wave.base.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.wave.core.util.DateUtil;
/**
 * 公用实体类
 * @author lky
 *
 */
public class BaseVo extends Vo implements Serializable,Comparable<Object>  {
 
    protected static final long serialVersionUID = 1208232909974083736L;
    
	protected int pagesize = 10; //每页显示记录数 
	protected int totalResultsCount;	//总记录数
	protected int pagenum;	//当前页
	
    protected String creater;

    protected String createTime;

    protected String updater;

    protected String updateTime;

    
    public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalResultsCount() {
		return totalResultsCount;
	}

	public void setTotalResultsCount(int totalResultsCount) {
		this.totalResultsCount = totalResultsCount;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreateTime() {
        if (this.createTime == null || this.createTime.toLowerCase() == "null") {
            this.createTime = DateUtil.getTimeStamp();
        }
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateTime() {
        if (this.updateTime == null  || this.updateTime.toLowerCase()  == "null") {
            this.updateTime = DateUtil.getTimeStamp();
        }
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    } 
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this)
                .append("updateTime", this.updateTime)
                .append("creater",this.creater)
                .append("updater", this.updater)
                .append("createTime",this.createTime).toString();
    }

    /**
     * @see java.lang.Comparable#compareTo(Object)
     */
    public int compareTo(Object object) {
        BaseVo myClass = (BaseVo) object;
        return new CompareToBuilder()
                .append(this.updater,myClass.updater)
                .append(this.updateTime,myClass.updateTime)
                .append(this.createTime, myClass.createTime)
                .append(this.creater, myClass.creater).toComparison();
    }
}
