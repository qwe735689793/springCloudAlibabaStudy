package com.mhj.demo.controller;

/**
 * describe:
 *
 * @author
 * @date 2020/03/12
 */
public enum ExceptionConstants {

    /**
     * 参数异常
     */
    PARAM_EXCEPTION(400, "参数异常"),

    /**
     * 未授权
     */
    SC_UNAUTHORIZED_EXCEPTION(401,"未授权"),

    /**
     * 拒绝访问
     */
    SC_FORBIDDEN__EXCEPTION(403,"拒绝访问"),

    /**
     * 服务器异常
     */
    SC_INTERNAL_SERVER_ERROR(500, "服务器异常"),

    /**
     * ip 锁定
     */
    IP_LOCK(4001,"ip 锁定"),

    /**
     * 参数验签未通过
     */
    PARAM_CHECK_ERROR(4002,"参数验签未通过"),

    /**
     * 参数验签未通过重复
     */
    PARAM_REPEAT_ERROR(4003,"参数重复，验证未通过"),
    ;

    private int code;

    private String msg;

    ExceptionConstants(int code) {
        this.code = code;
    }

    ExceptionConstants(String msg) {
        this.msg = msg;
    }

    ExceptionConstants(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
