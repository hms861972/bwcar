package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.MemberCar;
import com.gsm.project.bwcar.pojo.MemberCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberCarDao {
    long countByExample(MemberCarExample example);

    int deleteByExample(MemberCarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberCar record);

    int insertSelective(MemberCar record);

    List<MemberCar> selectByExample(MemberCarExample example);

    MemberCar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberCar record, @Param("example") MemberCarExample example);

    int updateByExample(@Param("record") MemberCar record, @Param("example") MemberCarExample example);

    int updateByPrimaryKeySelective(MemberCar record);

    int updateByPrimaryKey(MemberCar record);
}