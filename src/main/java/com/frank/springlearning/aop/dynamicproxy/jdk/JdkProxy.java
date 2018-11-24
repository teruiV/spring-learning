package com.frank.springlearning.aop.dynamicproxy.jdk;



import com.frank.springlearning.aop.staticproxy.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public class JdkProxy implements InvocationHandler {
    private RealSubject realSubject;

    public JdkProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try{
            System.out.println("before");
            result = method.invoke(realSubject,args);
        }catch (Exception e){
            System.out.printf("ex: %s\n",e.getMessage());
            throw e;
        }finally {
            System.out.println("after");
        }
        return result;
    }
}
