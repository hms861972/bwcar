package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysUser;
import com.gsm.project.bwcar.pojo.SysUserExample;
import java.util.List;
import java.util.Map;

import com.gsm.project.bwcar.utils.R;
import org.apache.ibatis.annotations.Param;

public interface SysUserDao {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectSysUserAll();

    List<SysUser> selectSysUserByPage(QueryDTO queryDTO);

    SysUser selectUserByName(String username);

    int deleteUserByIds(List<Long> ids);

    List<Map<String, Object>> exportUser();
}