package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.Activity;
import com.gsm.project.bwcar.pojo.ActivityExample;
import com.gsm.project.bwcar.pojo.ActivityWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActivityDao {
    long countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityWithBLOBs record);

    int insertSelective(ActivityWithBLOBs record);

    List<ActivityWithBLOBs> selectByExampleWithBLOBs(ActivityExample example);

    List<Activity> selectByExample(ActivityExample example);

    ActivityWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityWithBLOBs record, @Param("example") ActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") ActivityWithBLOBs record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(ActivityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ActivityWithBLOBs record);

    int updateByPrimaryKey(Activity record);
}