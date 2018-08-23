package com.frank.springlearning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author jianweilin
 * @date 2018/8/21
 */
@Service
@Slf4j
public class ContainerService/* implements InstantiationAwareBeanPostProcessor*/ {

//    @Nullable
//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        log.info("[container {}] process before init", beanName);
//        return null;
//    }
//
//    @Override
//    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        log.info("[container {}] process after init", beanName);
//        return true;
//    }
//
//    @Nullable
//    @Override
//    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
//        log.info("[container {}] process property values", beanName);
//        return pvs;
//    }
//
//    @Nullable
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info("[container {}] process before init override", beanName);
//        return bean;
//    }
//
//    @Nullable
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        log.info("[container {}] process after init override", beanName);
//        return bean;
//    }

    public String echo() {
        log.info(">>>> [container] echo method >>>>");
        return "success";
    }
}
