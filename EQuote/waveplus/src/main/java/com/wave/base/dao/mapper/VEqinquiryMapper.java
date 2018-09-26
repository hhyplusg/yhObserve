package com.wave.base.dao.mapper;

import com.wave.base.vo.entity.VEqinquiry;
import com.wave.base.vo.entity.VEqinquiryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VEqinquiryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_eqinquiry
     *
     * @mbg.generated
     */
    long countByExample(VEqinquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_eqinquiry
     *
     * @mbg.generated
     */
    int deleteByExample(VEqinquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_eqinquiry
     *
     * @mbg.generated
     */
    int insert(VEqinquiry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_eqinquiry
     *
     * @mbg.generated
     */
    int insertSelective(VEqinquiry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_eqinquiry
     *
     * @mbg.generated
     */
    List<VEqinquiry> selectByExample(VEqinquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_eqinquiry
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VEqinquiry record, @Param("example") VEqinquiryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_eqinquiry
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VEqinquiry record, @Param("example") VEqinquiryExample example);
}