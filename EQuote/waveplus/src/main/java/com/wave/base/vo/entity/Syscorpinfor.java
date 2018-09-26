package com.wave.base.vo.entity;

import com.wave.base.vo.BaseVo;
import java.io.Serializable;
import java.util.Date;

public class Syscorpinfor extends BaseVo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.CORPCODE
     *
     * @mbg.generated
     */
    private String corpcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.CORPNAME
     *
     * @mbg.generated
     */
    private String corpname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.CORPSHORTNAME
     *
     * @mbg.generated
     */
    private String corpshortname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.CORPTYPE
     *
     * @mbg.generated
     */
    private String corptype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.PASSWORD
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.STATUS
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.USERLOGINNAME
     *
     * @mbg.generated
     */
    private String userloginname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.ATTRIBUTE2
     *
     * @mbg.generated
     */
    private String attribute2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.ATTRIBUTE3
     *
     * @mbg.generated
     */
    private String attribute3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.CREATEDBY
     *
     * @mbg.generated
     */
    private String createdby;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.CREATIONDATE
     *
     * @mbg.generated
     */
    private Date creationdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.LASTUPDATEBY
     *
     * @mbg.generated
     */
    private String lastupdateby;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSCORPINFOR.LASTUPDATEDATE
     *
     * @mbg.generated
     */
    private Date lastupdatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 4934676238107849831L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.ID
     *
     * @return the value of SYSCORPINFOR.ID
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.ID
     *
     * @param id the value for SYSCORPINFOR.ID
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.CORPCODE
     *
     * @return the value of SYSCORPINFOR.CORPCODE
     *
     * @mbg.generated
     */
    public String getCorpcode() {
        return corpcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.CORPCODE
     *
     * @param corpcode the value for SYSCORPINFOR.CORPCODE
     *
     * @mbg.generated
     */
    public void setCorpcode(String corpcode) {
        this.corpcode = corpcode == null ? null : corpcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.CORPNAME
     *
     * @return the value of SYSCORPINFOR.CORPNAME
     *
     * @mbg.generated
     */
    public String getCorpname() {
        return corpname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.CORPNAME
     *
     * @param corpname the value for SYSCORPINFOR.CORPNAME
     *
     * @mbg.generated
     */
    public void setCorpname(String corpname) {
        this.corpname = corpname == null ? null : corpname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.CORPSHORTNAME
     *
     * @return the value of SYSCORPINFOR.CORPSHORTNAME
     *
     * @mbg.generated
     */
    public String getCorpshortname() {
        return corpshortname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.CORPSHORTNAME
     *
     * @param corpshortname the value for SYSCORPINFOR.CORPSHORTNAME
     *
     * @mbg.generated
     */
    public void setCorpshortname(String corpshortname) {
        this.corpshortname = corpshortname == null ? null : corpshortname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.CORPTYPE
     *
     * @return the value of SYSCORPINFOR.CORPTYPE
     *
     * @mbg.generated
     */
    public String getCorptype() {
        return corptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.CORPTYPE
     *
     * @param corptype the value for SYSCORPINFOR.CORPTYPE
     *
     * @mbg.generated
     */
    public void setCorptype(String corptype) {
        this.corptype = corptype == null ? null : corptype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.PASSWORD
     *
     * @return the value of SYSCORPINFOR.PASSWORD
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.PASSWORD
     *
     * @param password the value for SYSCORPINFOR.PASSWORD
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.STATUS
     *
     * @return the value of SYSCORPINFOR.STATUS
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.STATUS
     *
     * @param status the value for SYSCORPINFOR.STATUS
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.USERLOGINNAME
     *
     * @return the value of SYSCORPINFOR.USERLOGINNAME
     *
     * @mbg.generated
     */
    public String getUserloginname() {
        return userloginname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.USERLOGINNAME
     *
     * @param userloginname the value for SYSCORPINFOR.USERLOGINNAME
     *
     * @mbg.generated
     */
    public void setUserloginname(String userloginname) {
        this.userloginname = userloginname == null ? null : userloginname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.ATTRIBUTE2
     *
     * @return the value of SYSCORPINFOR.ATTRIBUTE2
     *
     * @mbg.generated
     */
    public String getAttribute2() {
        return attribute2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.ATTRIBUTE2
     *
     * @param attribute2 the value for SYSCORPINFOR.ATTRIBUTE2
     *
     * @mbg.generated
     */
    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2 == null ? null : attribute2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.ATTRIBUTE3
     *
     * @return the value of SYSCORPINFOR.ATTRIBUTE3
     *
     * @mbg.generated
     */
    public String getAttribute3() {
        return attribute3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.ATTRIBUTE3
     *
     * @param attribute3 the value for SYSCORPINFOR.ATTRIBUTE3
     *
     * @mbg.generated
     */
    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3 == null ? null : attribute3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.CREATEDBY
     *
     * @return the value of SYSCORPINFOR.CREATEDBY
     *
     * @mbg.generated
     */
    public String getCreatedby() {
        return createdby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.CREATEDBY
     *
     * @param createdby the value for SYSCORPINFOR.CREATEDBY
     *
     * @mbg.generated
     */
    public void setCreatedby(String createdby) {
        this.createdby = createdby == null ? null : createdby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.CREATIONDATE
     *
     * @return the value of SYSCORPINFOR.CREATIONDATE
     *
     * @mbg.generated
     */
    public Date getCreationdate() {
        return creationdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.CREATIONDATE
     *
     * @param creationdate the value for SYSCORPINFOR.CREATIONDATE
     *
     * @mbg.generated
     */
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.LASTUPDATEBY
     *
     * @return the value of SYSCORPINFOR.LASTUPDATEBY
     *
     * @mbg.generated
     */
    public String getLastupdateby() {
        return lastupdateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.LASTUPDATEBY
     *
     * @param lastupdateby the value for SYSCORPINFOR.LASTUPDATEBY
     *
     * @mbg.generated
     */
    public void setLastupdateby(String lastupdateby) {
        this.lastupdateby = lastupdateby == null ? null : lastupdateby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSCORPINFOR.LASTUPDATEDATE
     *
     * @return the value of SYSCORPINFOR.LASTUPDATEDATE
     *
     * @mbg.generated
     */
    public Date getLastupdatedate() {
        return lastupdatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSCORPINFOR.LASTUPDATEDATE
     *
     * @param lastupdatedate the value for SYSCORPINFOR.LASTUPDATEDATE
     *
     * @mbg.generated
     */
    public void setLastupdatedate(Date lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
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
        Syscorpinfor other = (Syscorpinfor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCorpcode() == null ? other.getCorpcode() == null : this.getCorpcode().equals(other.getCorpcode()))
            && (this.getCorpname() == null ? other.getCorpname() == null : this.getCorpname().equals(other.getCorpname()))
            && (this.getCorpshortname() == null ? other.getCorpshortname() == null : this.getCorpshortname().equals(other.getCorpshortname()))
            && (this.getCorptype() == null ? other.getCorptype() == null : this.getCorptype().equals(other.getCorptype()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUserloginname() == null ? other.getUserloginname() == null : this.getUserloginname().equals(other.getUserloginname()))
            && (this.getAttribute2() == null ? other.getAttribute2() == null : this.getAttribute2().equals(other.getAttribute2()))
            && (this.getAttribute3() == null ? other.getAttribute3() == null : this.getAttribute3().equals(other.getAttribute3()))
            && (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
            && (this.getCreationdate() == null ? other.getCreationdate() == null : this.getCreationdate().equals(other.getCreationdate()))
            && (this.getLastupdateby() == null ? other.getLastupdateby() == null : this.getLastupdateby().equals(other.getLastupdateby()))
            && (this.getLastupdatedate() == null ? other.getLastupdatedate() == null : this.getLastupdatedate().equals(other.getLastupdatedate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCorpcode() == null) ? 0 : getCorpcode().hashCode());
        result = prime * result + ((getCorpname() == null) ? 0 : getCorpname().hashCode());
        result = prime * result + ((getCorpshortname() == null) ? 0 : getCorpshortname().hashCode());
        result = prime * result + ((getCorptype() == null) ? 0 : getCorptype().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUserloginname() == null) ? 0 : getUserloginname().hashCode());
        result = prime * result + ((getAttribute2() == null) ? 0 : getAttribute2().hashCode());
        result = prime * result + ((getAttribute3() == null) ? 0 : getAttribute3().hashCode());
        result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
        result = prime * result + ((getCreationdate() == null) ? 0 : getCreationdate().hashCode());
        result = prime * result + ((getLastupdateby() == null) ? 0 : getLastupdateby().hashCode());
        result = prime * result + ((getLastupdatedate() == null) ? 0 : getLastupdatedate().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", corpcode=").append(corpcode);
        sb.append(", corpname=").append(corpname);
        sb.append(", corpshortname=").append(corpshortname);
        sb.append(", corptype=").append(corptype);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", userloginname=").append(userloginname);
        sb.append(", attribute2=").append(attribute2);
        sb.append(", attribute3=").append(attribute3);
        sb.append(", createdby=").append(createdby);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", lastupdateby=").append(lastupdateby);
        sb.append(", lastupdatedate=").append(lastupdatedate);
        sb.append("]");
        return sb.toString();
    }
}