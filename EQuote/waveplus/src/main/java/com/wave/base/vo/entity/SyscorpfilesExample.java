package com.wave.base.vo.entity;

import com.wave.base.vo.BaseVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyscorpfilesExample extends BaseVo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 4934676238107849831L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public SyscorpfilesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCorpidIsNull() {
            addCriterion("CORPID is null");
            return (Criteria) this;
        }

        public Criteria andCorpidIsNotNull() {
            addCriterion("CORPID is not null");
            return (Criteria) this;
        }

        public Criteria andCorpidEqualTo(Integer value) {
            addCriterion("CORPID =", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotEqualTo(Integer value) {
            addCriterion("CORPID <>", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidGreaterThan(Integer value) {
            addCriterion("CORPID >", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CORPID >=", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLessThan(Integer value) {
            addCriterion("CORPID <", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLessThanOrEqualTo(Integer value) {
            addCriterion("CORPID <=", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidIn(List<Integer> values) {
            addCriterion("CORPID in", values, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotIn(List<Integer> values) {
            addCriterion("CORPID not in", values, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidBetween(Integer value1, Integer value2) {
            addCriterion("CORPID between", value1, value2, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotBetween(Integer value1, Integer value2) {
            addCriterion("CORPID not between", value1, value2, "corpid");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("FILENAME is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("FILENAME is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("FILENAME =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("FILENAME <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("FILENAME >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("FILENAME >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("FILENAME <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("FILENAME <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("FILENAME like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("FILENAME not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("FILENAME in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("FILENAME not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("FILENAME between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("FILENAME not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlIsNull() {
            addCriterion("FILESTORAGEURL is null");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlIsNotNull() {
            addCriterion("FILESTORAGEURL is not null");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlEqualTo(String value) {
            addCriterion("FILESTORAGEURL =", value, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlNotEqualTo(String value) {
            addCriterion("FILESTORAGEURL <>", value, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlGreaterThan(String value) {
            addCriterion("FILESTORAGEURL >", value, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlGreaterThanOrEqualTo(String value) {
            addCriterion("FILESTORAGEURL >=", value, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlLessThan(String value) {
            addCriterion("FILESTORAGEURL <", value, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlLessThanOrEqualTo(String value) {
            addCriterion("FILESTORAGEURL <=", value, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlLike(String value) {
            addCriterion("FILESTORAGEURL like", value, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlNotLike(String value) {
            addCriterion("FILESTORAGEURL not like", value, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlIn(List<String> values) {
            addCriterion("FILESTORAGEURL in", values, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlNotIn(List<String> values) {
            addCriterion("FILESTORAGEURL not in", values, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlBetween(String value1, String value2) {
            addCriterion("FILESTORAGEURL between", value1, value2, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlNotBetween(String value1, String value2) {
            addCriterion("FILESTORAGEURL not between", value1, value2, "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andAttribute1IsNull() {
            addCriterion("ATTRIBUTE1 is null");
            return (Criteria) this;
        }

        public Criteria andAttribute1IsNotNull() {
            addCriterion("ATTRIBUTE1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttribute1EqualTo(String value) {
            addCriterion("ATTRIBUTE1 =", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1NotEqualTo(String value) {
            addCriterion("ATTRIBUTE1 <>", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1GreaterThan(String value) {
            addCriterion("ATTRIBUTE1 >", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1GreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE1 >=", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1LessThan(String value) {
            addCriterion("ATTRIBUTE1 <", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1LessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE1 <=", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1Like(String value) {
            addCriterion("ATTRIBUTE1 like", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1NotLike(String value) {
            addCriterion("ATTRIBUTE1 not like", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1In(List<String> values) {
            addCriterion("ATTRIBUTE1 in", values, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1NotIn(List<String> values) {
            addCriterion("ATTRIBUTE1 not in", values, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1Between(String value1, String value2) {
            addCriterion("ATTRIBUTE1 between", value1, value2, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1NotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE1 not between", value1, value2, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute2IsNull() {
            addCriterion("ATTRIBUTE2 is null");
            return (Criteria) this;
        }

        public Criteria andAttribute2IsNotNull() {
            addCriterion("ATTRIBUTE2 is not null");
            return (Criteria) this;
        }

        public Criteria andAttribute2EqualTo(String value) {
            addCriterion("ATTRIBUTE2 =", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2NotEqualTo(String value) {
            addCriterion("ATTRIBUTE2 <>", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2GreaterThan(String value) {
            addCriterion("ATTRIBUTE2 >", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2GreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE2 >=", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2LessThan(String value) {
            addCriterion("ATTRIBUTE2 <", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2LessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE2 <=", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2Like(String value) {
            addCriterion("ATTRIBUTE2 like", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2NotLike(String value) {
            addCriterion("ATTRIBUTE2 not like", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2In(List<String> values) {
            addCriterion("ATTRIBUTE2 in", values, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2NotIn(List<String> values) {
            addCriterion("ATTRIBUTE2 not in", values, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2Between(String value1, String value2) {
            addCriterion("ATTRIBUTE2 between", value1, value2, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2NotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE2 not between", value1, value2, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute3IsNull() {
            addCriterion("ATTRIBUTE3 is null");
            return (Criteria) this;
        }

        public Criteria andAttribute3IsNotNull() {
            addCriterion("ATTRIBUTE3 is not null");
            return (Criteria) this;
        }

        public Criteria andAttribute3EqualTo(String value) {
            addCriterion("ATTRIBUTE3 =", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3NotEqualTo(String value) {
            addCriterion("ATTRIBUTE3 <>", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3GreaterThan(String value) {
            addCriterion("ATTRIBUTE3 >", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3GreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE3 >=", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3LessThan(String value) {
            addCriterion("ATTRIBUTE3 <", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3LessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE3 <=", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3Like(String value) {
            addCriterion("ATTRIBUTE3 like", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3NotLike(String value) {
            addCriterion("ATTRIBUTE3 not like", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3In(List<String> values) {
            addCriterion("ATTRIBUTE3 in", values, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3NotIn(List<String> values) {
            addCriterion("ATTRIBUTE3 not in", values, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3Between(String value1, String value2) {
            addCriterion("ATTRIBUTE3 between", value1, value2, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3NotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE3 not between", value1, value2, "attribute3");
            return (Criteria) this;
        }

        public Criteria andCreatedbyIsNull() {
            addCriterion("CREATEDBY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedbyIsNotNull() {
            addCriterion("CREATEDBY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedbyEqualTo(String value) {
            addCriterion("CREATEDBY =", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyNotEqualTo(String value) {
            addCriterion("CREATEDBY <>", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyGreaterThan(String value) {
            addCriterion("CREATEDBY >", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEDBY >=", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyLessThan(String value) {
            addCriterion("CREATEDBY <", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyLessThanOrEqualTo(String value) {
            addCriterion("CREATEDBY <=", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyLike(String value) {
            addCriterion("CREATEDBY like", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyNotLike(String value) {
            addCriterion("CREATEDBY not like", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyIn(List<String> values) {
            addCriterion("CREATEDBY in", values, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyNotIn(List<String> values) {
            addCriterion("CREATEDBY not in", values, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyBetween(String value1, String value2) {
            addCriterion("CREATEDBY between", value1, value2, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyNotBetween(String value1, String value2) {
            addCriterion("CREATEDBY not between", value1, value2, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreationdateIsNull() {
            addCriterion("CREATIONDATE is null");
            return (Criteria) this;
        }

        public Criteria andCreationdateIsNotNull() {
            addCriterion("CREATIONDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreationdateEqualTo(Date value) {
            addCriterion("CREATIONDATE =", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateNotEqualTo(Date value) {
            addCriterion("CREATIONDATE <>", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateGreaterThan(Date value) {
            addCriterion("CREATIONDATE >", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATIONDATE >=", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateLessThan(Date value) {
            addCriterion("CREATIONDATE <", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateLessThanOrEqualTo(Date value) {
            addCriterion("CREATIONDATE <=", value, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateIn(List<Date> values) {
            addCriterion("CREATIONDATE in", values, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateNotIn(List<Date> values) {
            addCriterion("CREATIONDATE not in", values, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateBetween(Date value1, Date value2) {
            addCriterion("CREATIONDATE between", value1, value2, "creationdate");
            return (Criteria) this;
        }

        public Criteria andCreationdateNotBetween(Date value1, Date value2) {
            addCriterion("CREATIONDATE not between", value1, value2, "creationdate");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyIsNull() {
            addCriterion("LASTUPDATEBY is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyIsNotNull() {
            addCriterion("LASTUPDATEBY is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyEqualTo(String value) {
            addCriterion("LASTUPDATEBY =", value, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyNotEqualTo(String value) {
            addCriterion("LASTUPDATEBY <>", value, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyGreaterThan(String value) {
            addCriterion("LASTUPDATEBY >", value, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyGreaterThanOrEqualTo(String value) {
            addCriterion("LASTUPDATEBY >=", value, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyLessThan(String value) {
            addCriterion("LASTUPDATEBY <", value, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyLessThanOrEqualTo(String value) {
            addCriterion("LASTUPDATEBY <=", value, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyLike(String value) {
            addCriterion("LASTUPDATEBY like", value, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyNotLike(String value) {
            addCriterion("LASTUPDATEBY not like", value, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyIn(List<String> values) {
            addCriterion("LASTUPDATEBY in", values, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyNotIn(List<String> values) {
            addCriterion("LASTUPDATEBY not in", values, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyBetween(String value1, String value2) {
            addCriterion("LASTUPDATEBY between", value1, value2, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyNotBetween(String value1, String value2) {
            addCriterion("LASTUPDATEBY not between", value1, value2, "lastupdateby");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIsNull() {
            addCriterion("LASTUPDATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIsNotNull() {
            addCriterion("LASTUPDATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateEqualTo(Date value) {
            addCriterion("LASTUPDATEDATE =", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotEqualTo(Date value) {
            addCriterion("LASTUPDATEDATE <>", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateGreaterThan(Date value) {
            addCriterion("LASTUPDATEDATE >", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("LASTUPDATEDATE >=", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateLessThan(Date value) {
            addCriterion("LASTUPDATEDATE <", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateLessThanOrEqualTo(Date value) {
            addCriterion("LASTUPDATEDATE <=", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIn(List<Date> values) {
            addCriterion("LASTUPDATEDATE in", values, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotIn(List<Date> values) {
            addCriterion("LASTUPDATEDATE not in", values, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateBetween(Date value1, Date value2) {
            addCriterion("LASTUPDATEDATE between", value1, value2, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotBetween(Date value1, Date value2) {
            addCriterion("LASTUPDATEDATE not between", value1, value2, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andFilenameLikeInsensitive(String value) {
            addCriterion("upper(FILENAME) like", value.toUpperCase(), "filename");
            return (Criteria) this;
        }

        public Criteria andFilestorageurlLikeInsensitive(String value) {
            addCriterion("upper(FILESTORAGEURL) like", value.toUpperCase(), "filestorageurl");
            return (Criteria) this;
        }

        public Criteria andAttribute1LikeInsensitive(String value) {
            addCriterion("upper(ATTRIBUTE1) like", value.toUpperCase(), "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute2LikeInsensitive(String value) {
            addCriterion("upper(ATTRIBUTE2) like", value.toUpperCase(), "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute3LikeInsensitive(String value) {
            addCriterion("upper(ATTRIBUTE3) like", value.toUpperCase(), "attribute3");
            return (Criteria) this;
        }

        public Criteria andCreatedbyLikeInsensitive(String value) {
            addCriterion("upper(CREATEDBY) like", value.toUpperCase(), "createdby");
            return (Criteria) this;
        }

        public Criteria andLastupdatebyLikeInsensitive(String value) {
            addCriterion("upper(LASTUPDATEBY) like", value.toUpperCase(), "lastupdateby");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYSCORPFILES
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}