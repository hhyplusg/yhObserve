package com.wave.base.dao.mapper;

import com.wave.base.vo.entity.Syscorpinfor;
import com.wave.base.vo.entity.SyscorpinforExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyscorpinforMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    long countByExample(SyscorpinforExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    int deleteByExample(SyscorpinforExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    int insert(Syscorpinfor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    int insertSelective(Syscorpinfor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    List<Syscorpinfor> selectByExample(SyscorpinforExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    Syscorpinfor selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Syscorpinfor record, @Param("example") SyscorpinforExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Syscorpinfor record, @Param("example") SyscorpinforExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Syscorpinfor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYSCORPINFOR
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Syscorpinfor record);
}