package com.frank.springlearning.aop.staticproxy;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public class ProxySubject implements Subject{
    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("before");
        realSubject.request();
        System.out.println("after");
    }

    @Override
    public void hello() {
        System.out.println("before");
        realSubject.hello();
        System.out.println("after");
    }
}
