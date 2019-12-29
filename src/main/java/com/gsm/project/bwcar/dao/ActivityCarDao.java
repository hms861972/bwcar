package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.ActivityCar;
import com.gsm.project.bwcar.pojo.ActivityCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityCarDao {
    long countByExample(ActivityCarExample example);

    int deleteByExample(ActivityCarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityCar record);

    int insertSelective(ActivityCar record);

    List<ActivityCar> selectByExample(ActivityCarExample example);

    ActivityCar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityCar record, @Param("example") ActivityCarExample example);

    int updateByExample(@Param("record") ActivityCar record, @Param("example") ActivityCarExample example);

    int updateByPrimaryKeySelective(ActivityCar record);

    int updateByPrimaryKey(ActivityCar record);
}