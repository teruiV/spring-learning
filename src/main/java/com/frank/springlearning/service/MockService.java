package com.frank.springlearning.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jianweilin
 * @date 2018/8/22
 */
@Slf4j
@Service
@Setter
public class MockService {

    @Autowired
    private LogService logService;

    public String callLog(String content){
        return logService.createRoute(content);
    }


}
