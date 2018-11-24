package com.frank.springlearning.factory;

import java.util.Date;

/**
 * @author jianweilin
 * @date 2018/10/15
 */
public class CurrentDateDisplayer {
    private Date currentDay;

    public CurrentDateDisplayer() {
    }

    public CurrentDateDisplayer(Date currentDay) {
        this.currentDay = currentDay;
    }

    public Date getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Date currentDay) {
        this.currentDay = currentDay;
    }
}
