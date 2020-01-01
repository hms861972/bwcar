package com.gsm.project.bwcar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.project.bwcar.dao.SysMenuDao;
import com.gsm.project.bwcar.dto.DataGridResult;
import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysMenu;
import com.gsm.project.bwcar.pojo.vo.SysMenuVo;
import com.gsm.project.bwcar.service.SysMenuService;
import com.gsm.project.bwcar.utils.R;
import com.mchange.v2.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;


    @Override
    public DataGridResult findMenu(QueryDTO queryDTO) {
        //分页插件
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        //判断排序查询是否为空
        if (queryDTO.getSort() !=null && !queryDTO.equals("")){
            queryDTO.setSort("menu_id");
        }
        //查询数据
        List<SysMenuVo> sysMenuVoList = sysMenuDao.findMenuByPage(queryDTO);
        //创建分页查询获取结果的信息
        PageInfo pageInfo = new PageInfo(sysMenuVoList);
        //将数据封装到结果对象中返回
        DataGridResult result = new DataGridResult(pageInfo.getTotal(),pageInfo.getList());
        return result;
    }

    @Override
    public R deleteMenu(List<Long> ids) {
        //判断是否传入主键
        if (ids == null || ids.size()<=0){
            return R.error(R.OPERATION_ERROR_CODE,"删除必须传入主键ID");
        }
        //系统菜单不能删除
        for(Long id : ids){
            if(id<=50){
                return R.error("系统菜单不能删除!");
            }
        }
        //调用删除方法
        int result = sysMenuDao.deleteMenuByIds(ids);
        if (result>0){
            return R.ok();
        }
        return R.error("删除失败!");
    }

    @Override
    public R saveMenu(SysMenu sysMenu) {
        int result = sysMenuDao.insert(sysMenu);
        if (result<=0){
            return R.error(R.OPERATION_ERROR_CODE,"新增失败!");
        }
        return R.ok();
    }

    @Override
    public R selectMenuTree() {
        List<SysMenu> list = sysMenuDao.selectMenuTree();
        //添加一个根目录
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuId(0L);
        sysMenu.setType(0);
        sysMenu.setParentId(-1L);
        sysMenu.setName("一级菜单");
        list.add(sysMenu);
        return R.ok().put("menuList",list);
    }

    @Override
    public R findMenuById(Long id) {
        SysMenu sysMenu = sysMenuDao.selectByPrimaryKey(id);
        return R.ok().put("menu",sysMenu);
    }

    @Override
    public R updateMenuById(SysMenu sysMenu) {
        if (sysMenu.getMenuId()==null){
            return R.error(R.OPERATION_ERROR_CODE,"修改主键不能为空!");
        }

        int i = sysMenuDao.updateByPrimaryKeySelective(sysMenu);

        return i>0?R.ok():R.error(R.OPERATION_ERROR_CODE,"修改失败!");
    }

    @Override
    public List<String> findPermsByUserId(Long userId) {
        List<String> ret = sysMenuDao.selectPermsByUserId(userId);
        Set<String> set = new HashSet<String>();
        for(String s : ret){
            if (s != null && !s.equals("")){
                String[] split = s.split(",");
                for(String s1 : split){
                    set.add(s1);
                }
            }
        }
        List<String> perms = new ArrayList<String>();
        perms.addAll(set);
        return perms;
    }


}
