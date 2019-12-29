package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.ActivityCategory;
import com.gsm.project.bwcar.pojo.ActivityCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityCategoryDao {
    long countByExample(ActivityCategoryExample example);

    int deleteByExample(ActivityCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityCategory record);

    int insertSelective(ActivityCategory record);

    List<ActivityCategory> selectByExample(ActivityCategoryExample example);

    ActivityCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityCategory record, @Param("example") ActivityCategoryExample example);

    int updateByExample(@Param("record") ActivityCategory record, @Param("example") ActivityCategoryExample example);

    int updateByPrimaryKeySelective(ActivityCategory record);

    int updateByPrimaryKey(ActivityCategory record);
}