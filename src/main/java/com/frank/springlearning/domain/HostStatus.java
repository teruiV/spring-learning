package com.frank.springlearning.domain;

import lombok.Data;

import java.util.List;

/**
 * @author jianweilin
 * @date 2018/8/17
 */
@Data
public class HostStatus {
    private List<String> srv;
    private int enter;
}
