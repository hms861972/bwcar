package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.MemberTag;
import com.gsm.project.bwcar.pojo.MemberTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberTagDao {
    long countByExample(MemberTagExample example);

    int deleteByExample(MemberTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberTag record);

    int insertSelective(MemberTag record);

    List<MemberTag> selectByExample(MemberTagExample example);

    MemberTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberTag record, @Param("example") MemberTagExample example);

    int updateByExample(@Param("record") MemberTag record, @Param("example") MemberTagExample example);

    int updateByPrimaryKeySelective(MemberTag record);

    int updateByPrimaryKey(MemberTag record);
}