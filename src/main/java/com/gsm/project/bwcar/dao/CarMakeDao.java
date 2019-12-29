package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.CarMake;
import com.gsm.project.bwcar.pojo.CarMakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarMakeDao {
    long countByExample(CarMakeExample example);

    int deleteByExample(CarMakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarMake record);

    int insertSelective(CarMake record);

    List<CarMake> selectByExample(CarMakeExample example);

    CarMake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarMake record, @Param("example") CarMakeExample example);

    int updateByExample(@Param("record") CarMake record, @Param("example") CarMakeExample example);

    int updateByPrimaryKeySelective(CarMake record);

    int updateByPrimaryKey(CarMake record);
}