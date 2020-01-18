package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.Car;
import com.gsm.project.bwcar.pojo.CarExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CarDao {
    long countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}