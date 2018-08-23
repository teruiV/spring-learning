package com.frank.springlearning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 有好几种方式
 * @author jianweilin
 * @date 2018/8/20
 */
@Service
@Slf4j
public class AnnotationService {
    @PostConstruct
    public void init(){
      log.info(">>>>> [annotation service] init >>>>>");
    }

    @PreDestroy
    public void destory(){
        log.info(">>>>> [annotation service] destory >>>>>");
    }

    public String annotion(){
        log.info(">>>>> [annotation service] anotation method >>>>>");
        return "success";
    }
}
