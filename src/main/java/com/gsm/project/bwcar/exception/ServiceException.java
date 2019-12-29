package com.gsm.project.bwcar.exception;

/**
 * 业务处理层异常
 */
public class ServiceException extends SysException {
    public ServiceException() {
        super("业务操作错误!");
    }

    public ServiceException(String errorMsg) {
        super(errorMsg);
    }
}
