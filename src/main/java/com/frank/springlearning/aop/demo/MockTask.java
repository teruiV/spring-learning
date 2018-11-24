package com.frank.springlearning.aop.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jianweilin
 * @date 2018/10/24
 */
@Slf4j
public class MockTask implements ITask{
    @Override
    public void execute() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task executed");
    }

    @Override
    public void println() {
        log.info("println method");
    }
}
