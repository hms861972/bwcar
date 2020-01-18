package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.CarManufacturer;
import com.gsm.project.bwcar.pojo.CarManufacturerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CarManufacturerDao {
    long countByExample(CarManufacturerExample example);

    int deleteByExample(CarManufacturerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarManufacturer record);

    int insertSelective(CarManufacturer record);

    List<CarManufacturer> selectByExample(CarManufacturerExample example);

    CarManufacturer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarManufacturer record, @Param("example") CarManufacturerExample example);

    int updateByExample(@Param("record") CarManufacturer record, @Param("example") CarManufacturerExample example);

    int updateByPrimaryKeySelective(CarManufacturer record);

    int updateByPrimaryKey(CarManufacturer record);
}