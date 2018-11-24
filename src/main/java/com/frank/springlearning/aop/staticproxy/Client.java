package com.frank.springlearning.aop.staticproxy;

/**
 * 静态代理，缺点：如果一个类有100个方法，需要对100个方法进行声明代理；
 * @author jianweilin
 * @date 2018/11/24
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy = new ProxySubject(new RealSubject());
        //proxy.request();
        proxy.hello();
    }
}
