package com.frank.springlearning;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jianweilin
 * @date 2018/10/28
 */
@Slf4j
public class ThreadJoinDemo {

    public void loadData() {
        log.info(">>>> thread: {} load Data start >>>>", Thread.currentThread().getName());

        Thread syncTask = new Thread(() -> {
            log.info(">>> thread: {}, this is join thread", Thread.currentThread().getName());
        });
        syncTask.start();

        try {
            log.info(">>>> thread: {}, thread is join start >>>>", Thread.currentThread().getName());
            syncTask.join();
            log.info(">>>> thread: {}, thread is join end >>>>", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(">>>> thread: {} load Data end >>>>", Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10; i ++){
            new ThreadJoinDemo().loadData();
            log.info("\n");
        }

    }
}
