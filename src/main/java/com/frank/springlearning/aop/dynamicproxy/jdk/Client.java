package com.frank.springlearning.aop.dynamicproxy.jdk;

import com.frank.springlearning.aop.staticproxy.RealSubject;
import com.frank.springlearning.aop.staticproxy.Subject;

import java.lang.reflect.Proxy;

/**
 * 1. Proxy.newProxyInstance
 * 2. newInstance
 *
 * show proxy generate class file:
 * System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
 * @author jianweilin
 * @date 2018/11/24
 */
public class Client {
    public static void main(String[] args) {

        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[]{Subject.class},new JdkProxy(new RealSubject()));
        subject.hello();

    }
}
