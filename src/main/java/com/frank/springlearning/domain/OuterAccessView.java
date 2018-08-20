package com.frank.springlearning.domain;

import lombok.Data;

/**
 * @author jianweilin
 * @date 2018/8/17
 */
@Data
public class OuterAccessView {
    private String service;
    private String address;
    private Integer port;
    private boolean available;
    private String route;
    private long timestamp;
}
