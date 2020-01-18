package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.SdkInterfaceParm;
import com.gsm.project.bwcar.pojo.SdkInterfaceParmExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SdkInterfaceParmDao {
    long countByExample(SdkInterfaceParmExample example);

    int deleteByExample(SdkInterfaceParmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SdkInterfaceParm record);

    int insertSelective(SdkInterfaceParm record);

    List<SdkInterfaceParm> selectByExample(SdkInterfaceParmExample example);

    SdkInterfaceParm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkInterfaceParm record, @Param("example") SdkInterfaceParmExample example);

    int updateByExample(@Param("record") SdkInterfaceParm record, @Param("example") SdkInterfaceParmExample example);

    int updateByPrimaryKeySelective(SdkInterfaceParm record);

    int updateByPrimaryKey(SdkInterfaceParm record);
}