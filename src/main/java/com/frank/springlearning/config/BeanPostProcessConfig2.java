package com.frank.springlearning.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author jianweilin
 * @date 2018/9/20
 */
//@Component
@Slf4j
public class BeanPostProcessConfig2 implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info(">>> before bean post process 2 >>>");
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info(">>> after bean post process 2 >>>");
        return bean;
    }
}
