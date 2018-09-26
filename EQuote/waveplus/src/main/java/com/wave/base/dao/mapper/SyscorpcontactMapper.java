package com.wave.base.dao.mapper;

import com.wave.base.vo.entity.Syscorpcontact;
import com.wave.base.vo.entity.SyscorpcontactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyscorpcontactMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    long countByExample(SyscorpcontactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    int deleteByExample(SyscorpcontactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    int insert(Syscorpcontact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    int insertSelective(Syscorpcontact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    List<Syscorpcontact> selectByExample(SyscorpcontactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    Syscorpcontact selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Syscorpcontact record, @Param("example") SyscorpcontactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Syscorpcontact record, @Param("example") SyscorpcontactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Syscorpcontact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPCONTACT
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Syscorpcontact record);
}