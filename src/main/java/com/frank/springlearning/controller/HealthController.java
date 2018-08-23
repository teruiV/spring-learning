package com.frank.springlearning.controller;

import com.frank.springlearning.domain.GenderEnum;
import com.frank.springlearning.service.RegistryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianweilin
 * @date 2018/8/6
 */
@RestController
@Slf4j
public class HealthController {

    @Autowired
    private RegistryService registryService;

    @RequestMapping("/check")
    public String check(){
        log.info(">>> 【check】spring-learning is healthy! >>>");
        return "【check】spring-learning is healthy!";
    }

    @RequestMapping("/convert")
    public String convert(@RequestParam GenderEnum type,@RequestParam String name){
        log.info("convert type = {}, name = {}",type,name);
        return "success";
    }

}
