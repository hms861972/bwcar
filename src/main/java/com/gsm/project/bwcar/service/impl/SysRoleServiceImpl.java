package com.gsm.project.bwcar.service.impl;

import com.gsm.project.bwcar.dao.SysRoleDao;
import com.gsm.project.bwcar.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<String> findRoleNameByUserId(Long userId) {
        return sysRoleDao.selectRoleNameByUserId(userId);
    }
}
