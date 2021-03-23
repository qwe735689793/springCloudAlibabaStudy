package com.mhj.demo.controller;

import lombok.Data;

/**
 * @ClassName : CommonException
 * @Description : TODO
 * @Author :
 * @Date : 2020/2/29
 * @Version : 1.0
 **/
@Data
public class CommonException extends Exception {

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    public CommonException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String msg) {
        super(msg);
        this.code = 500;
        this.msg = msg;
    }

    public CommonException(ExceptionConstants constants) {
        super(constants.getMsg());
        this.code = constants.getCode();
        this.msg = constants.getMsg();
    }
}
