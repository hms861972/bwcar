package com.gsm.project.bwcar.exception;

/**
 * 请求异常
 */
public class ActionException extends SysException {
    public ActionException() {
        super("请求发生错误!");
    }

    public ActionException(String errorMsg) {
        super(errorMsg);
    }
}
