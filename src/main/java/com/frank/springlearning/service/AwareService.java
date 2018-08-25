package com.frank.springlearning.service;

import com.frank.springlearning.domain.MyTestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Arrays;

/**
 * @author jianweilin
 * @date 2018/8/18
 */
@Slf4j
public class AwareService implements InitializingBean,DisposableBean,BeanFactoryAware,BeanNameAware,ApplicationContextAware{
    private MyTestBean myTestBean;

    public AwareService(MyTestBean myTestBean) {
        this.myTestBean = myTestBean;
    }

    @Override
    public void destroy() throws Exception {
        log.info("[aware] destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[aware] init");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("[aware] bean is singleton : {}",beanFactory.isSingleton("awareService"));
    }

    @Override
    public void setBeanName(String name) {
        log.info("[aware] beanName is {}",name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("[aware] application define beans = {}", Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }
//
//    @Nullable
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info("[aware] before process");
//        return bean;
//    }
//
//    @Nullable
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        log.info("[aware] after process");
//        return bean;
//    }
}
