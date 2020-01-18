package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.Tag;
import com.gsm.project.bwcar.pojo.TagExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TagDao {
    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}