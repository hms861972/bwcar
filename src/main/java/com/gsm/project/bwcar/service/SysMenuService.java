package com.gsm.project.bwcar.service;

import com.gsm.project.bwcar.dto.DataGridResult;
import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysMenu;
import com.gsm.project.bwcar.utils.R;

import java.util.List;

/**
 * 菜单业务逻辑接口
 */
public interface SysMenuService {

    /**
     * 查询菜单列表
     * @param queryDTO
     * @return
     */
    DataGridResult findMenu(QueryDTO queryDTO);

    /**
     * 删除菜单
     * @param ids
     * @return
     */
    R deleteMenu(List<Long> ids);

    /**
     * 保存新增的菜单
     * @param sysMenu
     * @return
     */
    R saveMenu(SysMenu sysMenu);

    /**
     * 查询所有
     * @return
     */
    R selectMenuTree();

    /**
     * 根据id查询某个菜单
     * @param menuId
     * @return
     */
    R findMenuById(Long menuId);


    R updateMenuById(SysMenu sysMenu);

    List<String> findPermsByUserId(Long userId);
}
