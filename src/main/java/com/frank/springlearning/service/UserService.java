package com.frank.springlearning.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @author jianweilin
 * @date 2018/7/18
 */
@Slf4j
public class UserService {
    public List<String> test_001(){
        log.info("this is a real message");
        return Arrays.asList("1","2");
    }
}
