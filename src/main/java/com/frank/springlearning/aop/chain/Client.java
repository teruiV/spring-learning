package com.frank.springlearning.aop.chain;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public class Client {
    static class HandleA extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by a");
        }
    }

    static class HandleB extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by b");
        }
    }

    static class HandleC extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by c");
        }
    }

    public static void main(String[] args) {
        Handler handlerA = new HandleA();
        Handler handlerB = new HandleB();
        Handler handlerC = new HandleC();

        // 每次都需要这样设置依赖关系，比较繁琐
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.execute();
    }
}
