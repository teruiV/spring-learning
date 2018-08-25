package com.frank.springlearning.applicationContext;

import com.frank.springlearning.domain.MyTestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jianweilin
 * @date 2018/8/25
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        MyTestBean myTestBean = (MyTestBean)applicationContext.getBean("myTestBean");
        log.info("myTestBean = {}",myTestBean.getTestStr());

        // 注销容器
        ((AbstractApplicationContext) applicationContext).registerShutdownHook();
    }
}
