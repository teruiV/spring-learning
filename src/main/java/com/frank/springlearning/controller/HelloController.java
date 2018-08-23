package com.frank.springlearning.controller;

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
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name){
        return "hello " + name;
    }

    @RequestMapping(value = "/date")
    public String date(@RequestParam Date dateTime){
        return "hello: " + dateTime.getTime();
    }
}
