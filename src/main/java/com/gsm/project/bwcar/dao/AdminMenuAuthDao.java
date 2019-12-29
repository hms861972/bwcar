package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.AdminMenuAuth;
import com.gsm.project.bwcar.pojo.AdminMenuAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMenuAuthDao {
    long countByExample(AdminMenuAuthExample example);

    int deleteByExample(AdminMenuAuthExample example);

    int deleteByPrimaryKey(Short id);

    int insert(AdminMenuAuth record);

    int insertSelective(AdminMenuAuth record);

    List<AdminMenuAuth> selectByExample(AdminMenuAuthExample example);

    AdminMenuAuth selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") AdminMenuAuth record, @Param("example") AdminMenuAuthExample example);

    int updateByExample(@Param("record") AdminMenuAuth record, @Param("example") AdminMenuAuthExample example);

    int updateByPrimaryKeySelective(AdminMenuAuth record);

    int updateByPrimaryKey(AdminMenuAuth record);
}