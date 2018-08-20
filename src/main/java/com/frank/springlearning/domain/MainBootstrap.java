package com.frank.springlearning.domain;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author jianweilin
 * @date 2018/6/4
 */
public class MainBootstrap {
    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        System.out.println(String.format("测试是否加载xml: %s",bean.getTestStr()));
    }
}