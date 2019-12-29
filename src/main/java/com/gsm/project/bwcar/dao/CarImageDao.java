package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.CarImage;
import com.gsm.project.bwcar.pojo.CarImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarImageDao {
    long countByExample(CarImageExample example);

    int deleteByExample(CarImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarImage record);

    int insertSelective(CarImage record);

    List<CarImage> selectByExample(CarImageExample example);

    CarImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarImage record, @Param("example") CarImageExample example);

    int updateByExample(@Param("record") CarImage record, @Param("example") CarImageExample example);

    int updateByPrimaryKeySelective(CarImage record);

    int updateByPrimaryKey(CarImage record);
}