package com.frank.springlearning.aop.chain.improve;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public class Chain {
    private java.util.List<ChainHandler> handlers;

    private int index = 0;

    public Chain(java.util.List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void process(){
        if(index >= handlers.size()){
            return;
        }
        handlers.get(index++).execute(this);
    }
}
