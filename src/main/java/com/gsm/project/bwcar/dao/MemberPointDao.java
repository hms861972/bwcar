package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.MemberPoint;
import com.gsm.project.bwcar.pojo.MemberPointExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberPointDao {
    long countByExample(MemberPointExample example);

    int deleteByExample(MemberPointExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberPoint record);

    int insertSelective(MemberPoint record);

    List<MemberPoint> selectByExample(MemberPointExample example);

    MemberPoint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberPoint record, @Param("example") MemberPointExample example);

    int updateByExample(@Param("record") MemberPoint record, @Param("example") MemberPointExample example);

    int updateByPrimaryKeySelective(MemberPoint record);

    int updateByPrimaryKey(MemberPoint record);
}