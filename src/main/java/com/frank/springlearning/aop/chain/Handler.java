package com.frank.springlearning.aop.chain;

/**
 * @author jianweilin
 * @date 2018/11/24
 */
public abstract class Handler {
    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void execute(){
        handleProcess();
        if(successor != null){
            successor.execute();
        }
    }
    protected abstract void handleProcess();


}
