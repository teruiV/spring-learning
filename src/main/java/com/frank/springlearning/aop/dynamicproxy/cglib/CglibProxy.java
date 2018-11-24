package com.frank.springlearning.aop.dynamicproxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;
        try{
            System.out.println("cglib before");
            result = proxy.invokeSuper(obj,args);
        }catch (Exception e){
            System.out.printf("ex: %s",e.getMessage());
            throw e;
        }finally {
            System.out.println("cglib after");
        }
        return result;
    }
}
