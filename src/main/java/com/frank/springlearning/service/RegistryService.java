package com.frank.springlearning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author jianweilin
 * @date 2018/8/14
 */
@Slf4j
@Service
public class RegistryService /*implements BeanPostProcessor */{
//    @Nullable
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info(">>>>>>> [before] beanName {}>>>>>>>>>",beanName);
//        return bean;
//    }
//
//    @Nullable
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        log.info(">>>>>>> [after] beanName {}>>>>>>>>>",beanName);
//        return bean;
//    }

    public void registry(){
        log.info(">>>>>> [registry service test method] >>>>>>>>");
    }

    public static void main(String[] args) {
//        BeanFactory beanFactory =
    }
}
