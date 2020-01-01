package com.gsm.project.bwcar.service;

import java.util.List;

/**
 * @Author: hms
 * @data: 2020-01-01 22:48:00
 * @Description:用户角色业务逻辑开发层
 */
public interface SysRoleService {

    /**
     * 根据用户Id查询角色名称
     * @param userId
     * @return
     */
    public List<String> findRoleNameByUserId(Long userId);
}
