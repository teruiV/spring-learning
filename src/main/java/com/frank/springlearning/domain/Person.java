package com.frank.springlearning.domain;

import lombok.Data;

/**
 * @author jianweilin
 * @date 2018/8/19
 */
@Data
public class Person {
    private String name;
    private GenderEnum type;
}
