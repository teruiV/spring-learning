package com.frank.springlearning.aop.dynamicproxy.cglib;

import com.frank.springlearning.aop.staticproxy.RealSubject;
import com.frank.springlearning.aop.staticproxy.Subject;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CglibProxy());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
