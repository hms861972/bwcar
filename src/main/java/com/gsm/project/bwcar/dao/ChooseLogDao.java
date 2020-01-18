package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.ChooseLog;
import com.gsm.project.bwcar.pojo.ChooseLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ChooseLogDao {
    long countByExample(ChooseLogExample example);

    int deleteByExample(ChooseLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChooseLog record);

    int insertSelective(ChooseLog record);

    List<ChooseLog> selectByExample(ChooseLogExample example);

    ChooseLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChooseLog record, @Param("example") ChooseLogExample example);

    int updateByExample(@Param("record") ChooseLog record, @Param("example") ChooseLogExample example);

    int updateByPrimaryKeySelective(ChooseLog record);

    int updateByPrimaryKey(ChooseLog record);
}