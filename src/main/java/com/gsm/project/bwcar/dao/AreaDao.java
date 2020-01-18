package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.Area;
import com.gsm.project.bwcar.pojo.AreaExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AreaDao {
    long countByExample(AreaExample example);

    int deleteByExample(AreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectByExample(AreaExample example);

    Area selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}