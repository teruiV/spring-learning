package com.frank.springlearning.aop.chain.improve;


import java.util.Arrays;

import java.util.List;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public class ChainClient {
    static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by a");
        }
    }

    static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by b");
        }
    }

    static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by c");
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> handlers = Arrays.asList(new ChainHandlerA(), new ChainHandlerB(), new ChainHandlerC());

        Chain chain = new Chain(handlers);
        chain.process();

    }
}
