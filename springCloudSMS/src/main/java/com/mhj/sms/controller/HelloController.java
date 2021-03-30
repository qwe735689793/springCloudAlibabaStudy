package com.mhj.sms.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api("swaggerDemoController相关的api")
@Slf4j
public class HelloController {
    private static String appId;
    @Value(value = "${application.name}")
    public void setAppId(String value){
        appId=value;
    }


    @RequestMapping("/test1")
    public String test1(){
        return appId;
    }


}