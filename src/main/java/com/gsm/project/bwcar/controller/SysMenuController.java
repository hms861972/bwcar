package com.gsm.project.bwcar.controller;

import com.gsm.project.bwcar.dto.DataGridResult;
import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysMenu;
import com.gsm.project.bwcar.service.SysMenuService;
import com.gsm.project.bwcar.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("/list")
    @ResponseBody
    public DataGridResult findMenu(QueryDTO queryDTO){

        return sysMenuService.findMenu(queryDTO);
    }

    /**
     * 删除功能
     * @param ids
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public R deleteMenu(@RequestBody List<Long> ids){
        return sysMenuService.deleteMenu(ids);
    }

    /**
     * 添加菜单页面的树形菜单查询
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public R select(){
        return sysMenuService.selectMenuTree();
    }

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public R saveMenu(@RequestBody SysMenu sysMenu){
        return sysMenuService.saveMenu(sysMenu);
    }

    @RequestMapping("/info/{menuId}")
    @ResponseBody
    public R findMenuById(@PathVariable("menuId") Long menuId){
        return sysMenuService.findMenuById(menuId);
    }

    @RequestMapping("/update")
    @ResponseBody
    public R updateMenu(@RequestBody SysMenu sysMenu){
        return sysMenuService.updateMenuById(sysMenu);
    }

}
