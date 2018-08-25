package com.frank.springlearning.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;

import java.util.Arrays;

/**
 * @author jianweilin
 * @date 2018/5/21
 */
@Slf4j
public class MyTestBean implements InitializingBean, DisposableBean,ApplicationContextAware,BeanNameAware,BeanFactoryAware,BeanPostProcessor{
    private String testStr = "testStr";

    public String getTestStr(){
        return testStr;
    }

    public void setTestStr(String testStr){
        this.testStr = testStr;
    }

    @Override
    public void destroy() throws Exception {
        log.info(">>>>> [testBean]destory myTestBean >>>>>");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(">>>>> [testBean] init >>>>>>");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("[testBean] bean is singleton = {}",beanFactory.isSingleton("myTestBean"));
    }

    @Override
    public void setBeanName(String name) {
        log.info("[testBean] beanName is  {}",name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("[testBean] application define beans : {}", Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("[{}] postProcessBefore", beanName);
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("[{}] postProcessAfter ",beanName );
        return bean;
    }
}
