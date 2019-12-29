package com.gsm.project.bwcar.controller;

import com.gsm.project.bwcar.dto.DataGridResult;
import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysUser;
import com.gsm.project.bwcar.pojo.vo.UserVo;
import com.gsm.project.bwcar.service.SysUserService;
import com.gsm.project.bwcar.utils.R;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller()
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<SysUser> findAll(){
        return sysUserService.findAll();
    }
    @RequestMapping("/list")
    @ResponseBody
    public DataGridResult findSysUserByPage(QueryDTO queryDTO){
        return sysUserService.findSysUserByPage(queryDTO);
    }

    /**
     * 登录控制
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public R login(@RequestBody UserVo user){
        System.out.println(user);
        return R.ok();
    }

    @RequestMapping("/save")
    @ResponseBody
    public R save(@RequestBody SysUser sysUser){

        return sysUserService.save(sysUser);
    }
    @RequestMapping("/info/{userId}")
    @ResponseBody
    public R updataInfo(@PathVariable Long userId){
        return sysUserService.findUserById(userId);
    }

    @RequestMapping("/del")
    @ResponseBody
    public R deleteByIds(@RequestBody List<Long> ids){
        return sysUserService.deleteByIds(ids);
    }
    @RequestMapping("/export")
    public void exportUser(HttpServletResponse response){
        Workbook workbook = sysUserService.exportUser();
        try {
            //设置响应头
            response.setContentType("application/octet-stream");//所有文件都支持
            String fileName = "员工信息.xls";
            fileName = URLEncoder.encode(fileName,"utf-8");
            response.setHeader("content-disposition","attachment;filename="+fileName);
            //文件下载
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
