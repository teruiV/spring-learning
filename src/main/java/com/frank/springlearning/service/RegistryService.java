package com.frank.springlearning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * @author jianweilin
 * @date 2018/8/14
 */
@Slf4j
@Service
public class RegistryService implements BeanPostProcessor {
    @Autowired
    private LogService logService;

    public RegistryService(LogService logService) {
        this.logService = logService;
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info(">>>>>>> [before] beanName {}>>>>>>>>>", beanName);
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info(">>>>>>> [after] beanName {}>>>>>>>>>", beanName);
        return bean;
    }

    public void registry() {
        log.info(">>>>>> [registry service test method] >>>>>>>>");
    }


    public String mock(String content) {
        log.info(">>>>>> registry mock before >>>>>>>");
        log.info(">>>> log createRoute method: {} >>>>>", logService.createRoute(content));
        log.info(">>>>>> registry mock after >>>>>>>");
        return "success";
    }

    public static void main(String[] args) {
//        BeanFactory beanFactory =
    }
}
