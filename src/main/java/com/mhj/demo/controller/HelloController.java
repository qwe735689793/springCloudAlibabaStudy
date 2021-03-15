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
    /*
    * 短信服务测试
    * */
    @RequestMapping(value = "messageTest",method = RequestMethod.POST)
    public ResultVO messageTest(){
        //连接阿里云 使用对用的id 和密码  忘记了重置
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI4G9MGEKoytCe8zC3MNUT",
                "Ufqn9deafUddTm8pbntkYSJhZIP062");
        //构建请求
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        //参数  手机号码  验证码 使用的模板签名

        request.putQueryParameter("PhoneNumbers", "18059882212");    //给什么手机号发送
        request.putQueryParameter("SignName", "小缪学java");       //选择什么签名
        request.putQueryParameter("TemplateCode", "SMS_203186696"); //模板
        //验证码
        HashMap<String,Object> map =new HashMap<>();
        map.put("code",1234);
        request.putQueryParameter("TemplateParam", JSON.toJSONString(map));//必须要是字符串
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new ResultVO(200,"短信测是","成功");
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