package com.frank.springlearning;

import com.frank.springlearning.http.HttpDemo;

/**
 * @author jianweilin
 * @date 2018/11/23
 */
public class HttpDemo2 {
    public static void test_01(){
        new Thread(() -> HttpDemo.getEndPoints("push-service"),"t6").start();
//        new Thread(() -> HttpDemo.getEndPoints("push-service"),"t7").start();
//        new Thread(() -> HttpDemo.getEndPoints("push-service"),"t8").start();
//        new Thread(() -> HttpDemo.getEndPoints("push-service"),"t9").start();
        new Thread(() -> HttpDemo.getEndPoints("push-service"),"t10").start();
    }

    public static void test_02(){
        new Thread(() -> HttpDemo.getEndPoints2(),"t1").start();
//        new Thread(() -> HttpDemo.getEndPoints2(),"t2").start();
//        new Thread(() -> HttpDemo.getEndPoints2(),"t3").start();
//        new Thread(() -> HttpDemo.getEndPoints2(),"t4").start();
        new Thread(() -> HttpDemo.getEndPoints2(),"t5").start();
    }

    public static void main(String[] args) {
//        test_01();
        test_02();
//            for(int i = 0; i < 5; i++){
//                test_02();
//            }
    }
}
