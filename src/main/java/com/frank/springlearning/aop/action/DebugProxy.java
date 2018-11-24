package com.frank.springlearning.aop.action;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jianweilin
 * @date 2018/10/23
 */
public class DebugProxy implements InvocationHandler {
    private Object obj;

    public DebugProxy(Object obj) {
        this.obj = obj;
    }

    public static Object newInstance(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new DebugProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            System.out.println("before method " + method.getName());
            result = method.invoke(obj, args);
        }finally {
            System.out.println("after method " + method.getName());
        }
        return result;
    }

    public static void main(String[] args) {
        Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
        foo.bar("测试");
    }
}
