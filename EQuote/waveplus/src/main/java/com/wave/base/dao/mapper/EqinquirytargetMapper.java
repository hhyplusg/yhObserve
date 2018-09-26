package com.wave.base.dao.mapper;

import com.wave.base.vo.entity.Eqinquirytarget;
import com.wave.base.vo.entity.EqinquirytargetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EqinquirytargetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    long countByExample(EqinquirytargetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    int deleteByExample(EqinquirytargetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    int insert(Eqinquirytarget record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    int insertSelective(Eqinquirytarget record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    List<Eqinquirytarget> selectByExample(EqinquirytargetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    Eqinquirytarget selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Eqinquirytarget record, @Param("example") EqinquirytargetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Eqinquirytarget record, @Param("example") EqinquirytargetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Eqinquirytarget record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EQINQUIRYTARGET
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Eqinquirytarget record);
}