package com.gsm.project.bwcar.utils;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static final Integer OPERATION_ERROR_CODE = -200;

    //初始化，默认code键对应的值是零
    public R() {
        super.put("code", 0);
    }

    //设置参数
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    //操作成功
    public static R ok() {
        return new R();
    }

    //把map添加进去
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    //错误信息
    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }


}
