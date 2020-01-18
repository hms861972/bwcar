package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.ActivityInterface;
import com.gsm.project.bwcar.pojo.ActivityInterfaceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActivityInterfaceDao {
    long countByExample(ActivityInterfaceExample example);

    int deleteByExample(ActivityInterfaceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityInterface record);

    int insertSelective(ActivityInterface record);

    List<ActivityInterface> selectByExample(ActivityInterfaceExample example);

    ActivityInterface selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityInterface record, @Param("example") ActivityInterfaceExample example);

    int updateByExample(@Param("record") ActivityInterface record, @Param("example") ActivityInterfaceExample example);

    int updateByPrimaryKeySelective(ActivityInterface record);

    int updateByPrimaryKey(ActivityInterface record);
}