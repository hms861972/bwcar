package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.SdkInterface;
import com.gsm.project.bwcar.pojo.SdkInterfaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdkInterfaceDao {
    long countByExample(SdkInterfaceExample example);

    int deleteByExample(SdkInterfaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SdkInterface record);

    int insertSelective(SdkInterface record);

    List<SdkInterface> selectByExample(SdkInterfaceExample example);

    SdkInterface selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkInterface record, @Param("example") SdkInterfaceExample example);

    int updateByExample(@Param("record") SdkInterface record, @Param("example") SdkInterfaceExample example);

    int updateByPrimaryKeySelective(SdkInterface record);

    int updateByPrimaryKey(SdkInterface record);
}