package com.gsm.project.bwcar.exception;

import com.gsm.project.bwcar.utils.R;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class RExceptionHandler {

    @ExceptionHandler(RException.class)
    @ResponseBody
    public R rExp(RException rException){
        R r = new R();
        r.put("code",500);
        r.put("msg",rException.getMsg());
        return r;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R allExp(Exception exception){
        R r = new R();
        r.put("code",500);
        r.put("msg","系统内部异常请联系管理员");
        return r;
    }

    @ExceptionHandler(AuthorizationException.class)
    public String allExp(AuthorizationException authorizationException){
        return "redirect:static/unauthorized.html";
    }
}
