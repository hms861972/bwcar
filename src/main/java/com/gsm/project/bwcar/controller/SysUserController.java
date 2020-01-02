package com.gsm.project.bwcar.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.gsm.project.bwcar.dto.DataGridResult;
import com.gsm.project.bwcar.dto.QueryDTO;
import com.gsm.project.bwcar.pojo.SysUser;
import com.gsm.project.bwcar.pojo.vo.UserVo;
import com.gsm.project.bwcar.service.SysUserService;
import com.gsm.project.bwcar.utils.MD5Utils;
import com.gsm.project.bwcar.utils.R;
import com.gsm.project.bwcar.utils.ShiroUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller()
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private DefaultKaptcha kaptcha;

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

    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response){
        // 缓存设置-设置不缓存（可选操作）
        response.setHeader("Cache-Control","no-store, no-cache");
        // 设置响应内容
        response.setContentType("image/jpg");
        //生成验证码
        String text = kaptcha.createText();//文本
        //生成图片
        BufferedImage image = kaptcha.createImage(text);
        //验证码存储到shiro的 session
        ShiroUtils.setKaptcha(text);
        try {
            //返回到页面
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录控制
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public R login(@RequestBody UserVo user){
        //比对验证码
        String serverKaptcha = ShiroUtils.getKaptcha();
        if(!serverKaptcha.equalsIgnoreCase(user.getCaptcha())){
            return R.error("验证码错误");
        }
        Subject subject = SecurityUtils.getSubject();
        String newPass = MD5Utils.md5(user.getPassword(),user.getUsername(),1024);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),newPass);
        if(user.isRememberMe()){
            token.setRememberMe(true);
        }
        subject.login(token);
        //会去调用自定义的realm
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
