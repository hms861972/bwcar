package com.gsm.project.bwcar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.project.bwcar.dao.SysUserDao;
import com.gsm.project.bwcar.dto.DataGridResult;
import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysUser;
import com.gsm.project.bwcar.service.SysUserService;
import com.gsm.project.bwcar.utils.MD5Utils;
import com.gsm.project.bwcar.utils.R;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> findAll() {
        System.out.println("cd:" + sysUserDao.selectSysUserAll().size());
        return sysUserDao.selectSysUserAll();
    }

    @Override
    public DataGridResult findSysUserByPage(QueryDTO queryDTO) {
        //分页插件
        PageHelper.offsetPage(queryDTO.getOffset(), queryDTO.getLimit());
        if (queryDTO.getSort() != null && !queryDTO.getSort().trim().equals("")) {
            queryDTO.setSort("user_id");
        }
        List<SysUser> list = sysUserDao.selectSysUserByPage(queryDTO);
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        //将数据封装到结果对象中返回
        DataGridResult result = new DataGridResult(pageInfo.getTotal(), pageInfo.getList());
        return result;
    }

    @Override
    public R save(SysUser sysUser) {
        //验证用户名唯一
        SysUser count = sysUserDao.selectUserByName(sysUser.getUsername());
        if (count != null) {
            return R.error("用户名已存在!");
        }
        sysUser.setCreateTime(new Date());
        String newPass = MD5Utils.md5(sysUser.getPassword(), sysUser.getUsername(), 1024);
        sysUser.setPassword(newPass);
        int resultCount = sysUserDao.insertSelective(sysUser);
        if (resultCount <= 0) {
            return R.error("新增用户失败!");
        }
        return R.ok();
    }

    @Override
    public R findUserById(Long userId) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(userId);
        if (sysUser != null) {
            return R.ok().put("user", sysUser);
        }
        return R.error("用户ID不存在!");
    }

    @Override
    public R deleteByIds(List<Long> ids) {

        if (ids == null || ids.size() <= 0) {
            return R.error(R.OPERATION_ERROR_CODE, "删除失败,必须传入主键!");
        }

        int resultCount = sysUserDao.deleteUserByIds(ids);

        if (resultCount != ids.size()) {
            return R.error(R.OPERATION_ERROR_CODE, "删除存在错误,请检查!");
        }
        return R.ok();
    }

    @Override
    public Workbook exportUser() {
        //1，创建了一个空的excel文件
        Workbook workbook = new HSSFWorkbook();
        //2,填充数据：创建sheet
        Sheet sheet = workbook.createSheet("某某公司的员工信息");
        //标题数组
        String titles[] = {"用户id", "用户名", "邮箱", "电话", "创建时间"};
        String colums[] = {"userId", "username", "email", "mobile", "createTime"};
        List<Map<String, Object>> maps = sysUserDao.exportUser();
        Row rowTile = sheet.createRow(0);
        //标题行
        for (int i = 0; i < titles.length; i++) {
            Cell cell = rowTile.createCell(i);
            cell.setCellValue(titles[i]);
        }
        //遍历数据填充到单元格
        for (int i = 0; i < maps.size(); i++) {
            //一条记录应该创建一个Row对象 这里从第二行开始所以+1
            Row row = sheet.createRow(i + 1);//这个是空的，需要填充数据
            //填充单元格
            for (int j = 0; j < titles.length; j++) {
                Cell cell = row.createCell(j);
                //获取用户id的值
                Map<String, Object> rowValue = maps.get(i);
                //循环动态设置多个字段的值
                Object o = rowValue.get(colums[j]);//这里获取的值可以是"userId"..
                //这里也就是为什么查询数据库使用map封装的原因。
                cell.setCellValue(o + "");
            }
        }
        return workbook;
    }

    @Override
    public SysUser findUserByUsername(String username) {
        return sysUserDao.selectUserByName(username);
    }
}
