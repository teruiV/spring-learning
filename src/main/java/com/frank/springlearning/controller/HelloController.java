package com.frank.springlearning.controller;

import com.alibaba.fastjson.JSON;
import com.frank.springlearning.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author jianweilin
 * @date 2018/6/16
 */
@RestController
@Validated
public class HelloController {
    @RequestMapping(value = "/say/name",method = RequestMethod.POST)
    public String sayHello(@RequestBody @Valid User user){
        return JSON.toJSONString(user);
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
