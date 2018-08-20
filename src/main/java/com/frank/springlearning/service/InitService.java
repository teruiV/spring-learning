package com.frank.springlearning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author jianweilin
 * @date 2018/8/20
 */

@Service
@Slf4j
public class InitService implements InitializingBean, DisposableBean, ApplicationContextAware {
    private String filterPhone;

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        filterPhone = "18817394112";
    }

    public String getFilterPhone() {
        getBeanName();
        return filterPhone;
    }

    @Override
    public void destroy() throws Exception {
        log.info("销毁 initService!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        log.info("init application context.");
    }

    public void getBeanName() {
        LogService logService = (LogService) applicationContext.getBean("logService");
        log.info("[result] = {}",logService.nodeOff());
        log.info(">>>> get bean name >>>>");
    }
}
