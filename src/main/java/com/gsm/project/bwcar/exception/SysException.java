package com.gsm.project.bwcar.exception;

/**
 * 系统异常
 */
public class SysException extends Exception {
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public SysException() {
    }

    public SysException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public SysException(String message, Throwable cause, String errorMsg) {
        super(message, cause);
        this.errorMsg = errorMsg;
    }

    public SysException(Throwable cause) {
        super(cause);
    }
}
