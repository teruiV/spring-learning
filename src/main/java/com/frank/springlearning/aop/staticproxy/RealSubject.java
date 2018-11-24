package com.frank.springlearning.aop.staticproxy;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real object: request method");
    }

    @Override
    public void hello() {
        System.out.println("real object: hello method");
    }
}
