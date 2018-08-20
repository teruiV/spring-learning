package com.frank.springlearning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jianweilin
 * @date 2018/7/16
 */
@Controller
@Slf4j
public class HomeController {
    @RequestMapping(value = "/**",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        log.info(">>>>>> login page >>>>>");
        return model;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        log.info(">>>>>> login page >>>>>");
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/health",method = RequestMethod.GET)
    @ResponseBody
    public String health(){
        log.info(">>> services is healthy! >>>");
        return "services is healthy!";
    }


}
