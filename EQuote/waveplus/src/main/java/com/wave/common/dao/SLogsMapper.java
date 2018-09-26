package com.wave.common.dao;

import org.springframework.dao.DataAccessException;

import com.wave.common.vo.SLogsVo;

public interface SLogsMapper {
    int deleteByPrimaryKey(String logid) throws DataAccessException;

    int insert(SLogsVo record) throws DataAccessException;

    int insertSelective(SLogsVo record) throws DataAccessException;

    SLogsVo selectByPrimaryKey(String logid) throws DataAccessException;

    int updateByPrimaryKeySelective(SLogsVo record) throws DataAccessException;

    int updateByPrimaryKey(SLogsVo record) throws DataAccessException;
}