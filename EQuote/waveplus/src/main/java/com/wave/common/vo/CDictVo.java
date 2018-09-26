package com.wave.common.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.wave.core.util.StringUtil;
@Alias("CDictVo")
public class CDictVo implements Serializable {
    /**
     * serialVersionUID = 5221813027658072229L;
     */
    private static final long serialVersionUID = 5221813027658072229L;
    private String pid;
    private String id;
    private String dictType;
    private String dictKey;
    private String dictValue;
    private String centralitySysKey;
    private String centralitySysValue;
    @Override
    public String toString() {
        return "CDictVo [pid=" + pid + ", id=" + id + ", dictType=" + dictType + ", dictKey=" + dictKey + ", dictValue=" + dictValue + ", centralitySysKey=" + centralitySysKey + ", centralitySysValue=" + centralitySysValue + "]";
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDictType() {
        return dictType;
    }
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
    public String getDictKey() {
        return dictKey;
    }
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }
    public String getDictValue() {
        return dictValue;
    }
    public void setDictValue(String dictValue) {
        this.dictValue = StringUtil.sqliteEscape(dictValue);
    }
    public String getCentralitySysKey() {
        return centralitySysKey;
    }
    public void setCentralitySysKey(String centralitySysKey) {
        this.centralitySysKey = centralitySysKey;
    }
    public String getCentralitySysValue() {
        return centralitySysValue;
    }
    public void setCentralitySysValue(String centralitySysValue) {
        this.centralitySysValue = StringUtil.sqliteEscape(centralitySysValue);
    }
    
 
}