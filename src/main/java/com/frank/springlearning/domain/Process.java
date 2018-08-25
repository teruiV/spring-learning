package com.frank.springlearning.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Arrays;

/**
 * @author jianweilin
 * @date 2018/8/25
 */
@Slf4j
public class Process implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("[process] bean is singgleton: {}",beanFactory.isSingleton("process"));
    }

    @Override
    public void setBeanName(String name) {
        log.info("[process] beanName is {}",name);
    }

    @Override
    public void destroy() throws Exception {
        log.info("[process] destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[process] init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("[process] application define beans = {}", Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }
}
