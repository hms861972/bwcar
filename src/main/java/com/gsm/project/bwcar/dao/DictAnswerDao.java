package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.DictAnswer;
import com.gsm.project.bwcar.pojo.DictAnswerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DictAnswerDao {
    long countByExample(DictAnswerExample example);

    int deleteByExample(DictAnswerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictAnswer record);

    int insertSelective(DictAnswer record);

    List<DictAnswer> selectByExample(DictAnswerExample example);

    DictAnswer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictAnswer record, @Param("example") DictAnswerExample example);

    int updateByExample(@Param("record") DictAnswer record, @Param("example") DictAnswerExample example);

    int updateByPrimaryKeySelective(DictAnswer record);

    int updateByPrimaryKey(DictAnswer record);
}