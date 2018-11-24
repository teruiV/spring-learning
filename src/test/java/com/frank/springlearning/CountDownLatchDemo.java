package com.frank.springlearning;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author jianweilin
 * @date 2018/10/28
 */
@Slf4j
public class CountDownLatchDemo {
    public void loadData(){
        CountDownLatch latch = new CountDownLatch(1);
        log.info(">>>>  thread:{} start >>>>",Thread.currentThread().getName());
        new Thread(() -> {
            try{
                log.info("thread: {}, thread content : xxxx",Thread.currentThread().getName());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                latch.countDown();
            }
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(">>>>  thread:{} end >>>>",Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new CountDownLatchDemo().loadData();
    }
}
