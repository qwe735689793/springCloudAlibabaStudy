package com.mhj.demo.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.mhj.demo.mapper.PlusTest;
import com.mhj.demo.util.RedisUtil;
import com.mhj.demo.entity.request.UserAttitudeRequest;
import com.mhj.demo.service.AnswerService;
import com.mhj.demo.util.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api("swaggerDemoController相关的api")
@Slf4j
public class HelloController {
    @Autowired
    private AnswerService answerService;
    private static String appId;
    @Value(value = "${application.name}")
    public void setAppId(String value){
        appId=value;
    }
    @Autowired
    private RedisUtil redisUtil;
    @ApiOperation(value = "获得活动相关内容",notes = "")
    @ApiImplicitParam(name="activityid",value = "活动id",defaultValue = "")
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object  getHello() throws CommonException  {
        throw new CommonException(ExceptionConstants.SC_FORBIDDEN__EXCEPTION);

    }

    @ApiOperation(value = "说明方法的用途、作用", notes = "方法的备注说明")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "getAnswer")
    public ResultVO getAnswer(){
//        @RequestBody UserAttitudeRequest userAttitudeRequest
        /*测试数据*/
        UserAttitudeRequest userAttitudeRequest=new UserAttitudeRequest();
        userAttitudeRequest.setQuesId("05C177E5B3CA44DF9862E2058C485541");
        userAttitudeRequest.setUserId("6DBA6D1C9F3F41E388DA67B46F88C232");
        System.out.println("2222");
        return answerService.getAnswer(userAttitudeRequest);
    }
    /**
     * 日志打印
     * */
    @RequestMapping(value = "journalTest",method = RequestMethod.GET)
    public ResultVO journalTest(){
        log.trace("日志输出trace");
        log.debug("日志输出debug");
        log.info("日志输出 info");
        log.warn("日志输出warn");
        log.error("日志输出 error");
        return new ResultVO();
    }
    @Autowired
    private PlusTest plusTest;
    /**
     *mybatis-plus测试
     * */
    @RequestMapping(value = "plusTest",method = RequestMethod.POST)
    public ResultVO plusTest(){
        List<Map<String,Object>> List = plusTest.getTestData("05C177E5B3CA44DF9862E2058C485541");
        return new ResultVO(200,List,"成功");
    }

    @RequestMapping("/test1")
    public String test1(){
        return appId;
    }


}