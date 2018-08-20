package com.frank.springlearning.service;

import com.frank.springlearning.annotation.CreateRouteLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author jianweilin
 * @date 2018/7/31
 */
@Service
@Slf4j
public class LogService {

    public void nodeOnline(String content) {
        log.info("has a node online! content : " + content);
    }

    public List<Integer> nodeOff() {
        log.info(">>>> has a node offline >>>>");
        return Arrays.asList(1, 2, 3, 4);
    }


    public void createRoute() {
        log.info("has a node create route!");
    }

    @CreateRouteLog
    public String createRoute(String content) {
        log.info("has a node create route! content: {}", content);
        return "[result] : Hello World!";
    }
}
