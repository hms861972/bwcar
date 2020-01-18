package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysMenu;
import com.gsm.project.bwcar.pojo.SysMenuExample;

import java.util.List;
import java.util.Map;

import com.gsm.project.bwcar.pojo.vo.SysMenuVo;
import org.apache.ibatis.annotations.Param;

public interface SysMenuDao {
    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    /**
     * 查询菜单集合
     *
     * @param queryDTO
     * @return
     */
    List<SysMenuVo> findMenuByPage(QueryDTO queryDTO);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteMenuByIds(List<Long> ids);

    List<SysMenu> selectMenuTree();

    /**
     * 根据用户Id查询用户的菜单权限
     *
     * @param userId
     * @return
     */
    List<String> selectPermsByUserId(@Param("userId") Long userId);

    List<Map<String,Object>> findDirMenuByUserId(@Param("userId") Long userId);

    List<Map<String,Object>> findMenuNotButtonByUserId(@Param("userId") Long userId,@Param("parentId") Long parentId);

}