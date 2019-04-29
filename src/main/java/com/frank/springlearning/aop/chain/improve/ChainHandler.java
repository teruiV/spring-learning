package com.frank.springlearning.aop.chain.improve;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public abstract class ChainHandler {

    protected abstract void handleProcess();

    public void execute(Chain chain){
        handleProcess();
        chain.process();
    }
}
