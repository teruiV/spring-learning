package com.frank.springlearning;


import com.frank.springlearning.domain.MyTestBean;
import com.frank.springlearning.service.AwareService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringLearningApplicationTests {


    /**
     * 经历了一下几点：
     * 1. 读取配置文件beanFactoryTest.xml
     * 2. 根据beanFactoryTest.xml中的配置找到对应的类配置，并实例化；
     * 3. 调用实例化后的实例
     */
    @Test
    public void test_001(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        System.out.println(String.format("测试是否加载xml: %s",bean.getTestStr()));
    }

    @Test
    public void test_002(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        AwareService awareService = (AwareService)ctx.getBean("awareService");
        awareService.testAware();
    }
//
//
//    @Test
//    public void test_002(){
//        Integer num = 3;
//        System.out.println(num.equals(3));
//    }
}
