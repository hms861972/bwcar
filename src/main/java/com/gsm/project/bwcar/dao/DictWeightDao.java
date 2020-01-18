package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.DictWeight;
import com.gsm.project.bwcar.pojo.DictWeightExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DictWeightDao {
    long countByExample(DictWeightExample example);

    int deleteByExample(DictWeightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictWeight record);

    int insertSelective(DictWeight record);

    List<DictWeight> selectByExample(DictWeightExample example);

    DictWeight selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictWeight record, @Param("example") DictWeightExample example);

    int updateByExample(@Param("record") DictWeight record, @Param("example") DictWeightExample example);

    int updateByPrimaryKeySelective(DictWeight record);

    int updateByPrimaryKey(DictWeight record);
}