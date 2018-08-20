package com.frank.springlearning.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author jianweilin
 * @date 2018/8/1
 */
@Component
@Aspect
@Slf4j
public class OperateLogAspect {
    @Pointcut("@annotation(com.frank.springlearning.annotation.CreateRouteLog)")
    public void createRouteLog() {
    }

//    @AfterReturning(value = "createRouteLog()", argNames = "joinPoint,response", returning = "response")
//    public void createRouteLog(JoinPoint joinPoint, Object response) {
//        log.info(">>>> aspect create route log >>>>");
//    }

    @Around("createRouteLog()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        log.info(">>>>>> 【around】create log before >>>>>");
        Object result = pjp.proceed();
        log.info(">>>>>> 【around】create log after: result = {} >>>>>", result);
        return result;

    }
}
