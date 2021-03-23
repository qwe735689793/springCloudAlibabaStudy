package com.mhj.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/12/1 20:53
 **/
@Component
@Aspect
@Order(value = -100)
@Slf4j
public class AspectTest {

//    @Pointcut("execution(* com.mhj.demo.controller..*.*(..))")
//    private void skssysAspect(){
//
//
//    }

//    @Around("execution(* com.mhj.demo.controller..*.*(..))")
//    public Object roundAsp(ProceedingJoinPoint pj){
//        System.out.println("前置通知");
//
//        Object proceed = null;
//        try {
//            Object[] args = pj.getArgs();
//            System.out.println("原参数为："+args[0]);
//            args[0]=1;
//            System.out.println("修改后入参参数为："+ pj.getArgs()[0]);
//            //如果需要重新设置参数，则调用proceed的有参方法，否则直接调用无参方法即可
//            proceed = pj.proceed(args);
//        } catch (Throwable throwable) {
//            System.out.println("异常");
//            throwable.printStackTrace();
//        }
//
//        System.out.println("后");
//
//        return proceed;
//    }

//
//    @After("skssysAspect()")
//    public void soutTest(){
//        log.info("切面测试");
//    }
}
