package com.gsm.project.bwcar.service;

import com.gsm.project.bwcar.dto.DataGridResult;
import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysUser;
import com.gsm.project.bwcar.utils.R;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface SysUserService {

    public List<SysUser> findAll();

    public DataGridResult findSysUserByPage(QueryDTO queryDTO);

    R save(SysUser sysUser);

    R findUserById(Long userId);

    R deleteByIds(List<Long> ids);

    Workbook exportUser();
}
