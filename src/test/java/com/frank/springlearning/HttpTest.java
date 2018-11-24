package com.frank.springlearning;

import com.frank.springlearning.http.HttpDemo;
import org.junit.Test;

/**
 * @author jianweilin
 * @date 2018/11/23
 */
public class HttpTest {
    @Test
    public void test_001(){
        for(int i = 0; i < 10; i++){
            HttpDemo.getEndPoints("bdms-api");
        }
    }

    @Test
    public void test_002(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpDemo.getEndPoints("bdms-api");
            }
        }).start();
//        new Thread(() -> HttpDemo2.getEndPoints("bdms-api"),"t1").start();
//        new Thread(() -> HttpDemo2.getEndPoints("bdms-api"),"t2").start();
//        new Thread(() -> HttpDemo2.getEndPoints("bdms-api"),"t3").start();
//        new Thread(() -> HttpDemo2.getEndPoints("bdms-api"),"t4").start();
    }
}
