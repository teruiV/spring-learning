package com.frank.springlearning.aop.demo;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author jianweilin
 * @date 2018/10/24
 */
public class App {
    public static void main(String[] args) {
        MockTask task = new MockTask();
        ProxyFactory weaver = new ProxyFactory(task);
        weaver.setInterfaces(new Class[]{ITask.class});
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedNames("execute","println");
        advisor.setAdvice(new PerformanceMethodInterceptor());
        weaver.addAdvisor(advisor);
        ITask proxyObject = (ITask) weaver.getProxy();
        proxyObject.execute();
        proxyObject.println();
    }
}
