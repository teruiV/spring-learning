package com.frank.springlearning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author jianweilin
 * @date 2018/6/16
 */
@RestController
@Validated
public class HelloController {
    @Value("${systemName}")
    public String systemName;

    @RequestMapping("/value")
    public String value(){
        return systemName;
    }

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name){
        return "hello " + name;
    }

    @RequestMapping(value = "/date")
    public String date(@RequestParam Date dateTime){
        return "hello: " + dateTime.getTime();
    }
}
