package com.gsm.project.bwcar.pojo.vo;

import com.gsm.project.bwcar.pojo.SysMenu;

/**
 * 页面的菜单类数据
 */
public class SysMenuVo extends SysMenu {

    //上级菜单名称
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
