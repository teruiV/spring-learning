package com.frank.springlearning.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author jianweilin
 * @date 2018/10/15
 */
public class App {

    public static void main(String[] args) {
        XmlBeanFactory container = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        Date currentDay = (Date)container.getBean("currentDateFactoryBean");
        Object currentDay2 = container.getBean("currentDateFactoryBean");
        Object currentDay3 = container.getBean("&currentDateFactoryBean");
        Assert.isTrue(currentDay2 instanceof Date,"currentDays is not Date instance");
        Assert.isTrue(currentDay3 instanceof FactoryBean,"currentDay3 is not Date FactoryBean");
        Assert.isTrue(currentDay3 instanceof CurrentDateFactoryBean,"currentDay3 is not Date currentDateFactoryBean");
        System.out.println("current Time = " + currentDay.getTime());
    }
}
