package com.mhj.demo.entity.request;

import lombok.Data;

/**
 * @author  mhj
 * @create  2019/7/2
 * */
@Data
public class LoginRequest {
    private String account;
    private String password;
    private String test;
}
