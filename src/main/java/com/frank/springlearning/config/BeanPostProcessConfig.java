package com.frank.springlearning.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author jianweilin
 * @date 2018/9/20
 */
//@Component
@Slf4j
public class BeanPostProcessConfig implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info(">>> before post process 1 >>>");
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info(">>> after post process 1 >>>");
        return bean;
    }
}
