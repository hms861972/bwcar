package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.OperateLog;
import com.gsm.project.bwcar.pojo.OperateLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OperateLogDao {
    long countByExample(OperateLogExample example);

    int deleteByExample(OperateLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OperateLog record);

    int insertSelective(OperateLog record);

    List<OperateLog> selectByExample(OperateLogExample example);

    OperateLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OperateLog record, @Param("example") OperateLogExample example);

    int updateByExample(@Param("record") OperateLog record, @Param("example") OperateLogExample example);

    int updateByPrimaryKeySelective(OperateLog record);

    int updateByPrimaryKey(OperateLog record);
}