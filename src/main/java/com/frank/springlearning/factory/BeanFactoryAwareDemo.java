package com.frank.springlearning.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * @author jianweilin
 * @date 2018/10/16
 */
@Slf4j
@Service
public class BeanFactoryAwareDemo implements BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void println(){
        Object currentDate = beanFactory.getBean("currentDateFactoryBean");
        log.info("currentDate = {}",currentDate.hashCode());
    }


}
