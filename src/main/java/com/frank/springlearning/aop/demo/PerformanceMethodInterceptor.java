package com.frank.springlearning.aop.demo;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**
 * @author jianweilin
 * @date 2018/10/24
 */
@Slf4j
public class PerformanceMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch watch = new StopWatch();
        try{
            log.info("========interceptor start =========");
            watch.start();
            log.info("========interceptor end =========");
            return methodInvocation.proceed();
        }finally {
            watch.stop();
            log.info("watch = {}",watch.toString());
        }
    }
}
