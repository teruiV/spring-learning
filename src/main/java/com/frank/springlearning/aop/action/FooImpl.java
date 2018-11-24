package com.frank.springlearning.aop.action;

/**
 * @author jianweilin
 * @date 2018/10/23
 */
public class FooImpl implements Foo{
    @Override
    public Object bar(Object obj) {
        System.out.println("invoke FooImpl bar method: params = " + obj);
        return obj;
    }
}
