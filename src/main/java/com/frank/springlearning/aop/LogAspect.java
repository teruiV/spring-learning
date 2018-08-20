package com.frank.springlearning.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author jianweilin
 * @date 2018/7/31
 */
@Aspect
@Slf4j
//@Component
public class LogAspect {

    @Pointcut("execution(* com.frank.springlearning.service.LogService.nodeOnline(..))")
    public void nodeOnline(){};

    @Pointcut("execution(* com.frank.springlearning.service.LogService.nodeOff(..))")
    public void nodeOff(){}

    @Pointcut("execution(* com.frank.springlearning.service.LogService.createRoute(..))")
    public void createRoute(){};

    @Pointcut("nodeOnline() || createRoute()")
    public void online(){};


    @AfterReturning(value = "nodeOnline()", argNames = "joinPoint,object", returning = "object")
    public void nodeOnline(JoinPoint joinPoint, Object object){
        log.info(">>>>> pointcut nodeOnline content : {}>>>>>>>>",joinPoint.getArgs()[0].toString());
    };

    @AfterReturning(value = "nodeOff()", argNames = "joinPoint,serviceList", returning = "serviceList")
    public void nodeOff(JoinPoint joinPoint, Object serviceList){
        log.info(">>>>> pointcut nodeOff return = {} >>>>>>>>", JSON.toJSONString(serviceList));
    };

    @AfterReturning(value = "online()", argNames = "joinPoint,serviceList", returning = "serviceList")
    public void online(JoinPoint joinPoint, Object serviceList){
        log.info(">>>>> combine online = {} >>>>>>>>", JSON.toJSONString(serviceList));
    };
}
