package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.SysLog;
import com.gsm.project.bwcar.pojo.SysLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogDao {
    long countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}