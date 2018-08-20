package com.frank.springlearning.controller;

import com.alibaba.fastjson.JSON;
import com.frank.springlearning.domain.HostStatus;
import com.frank.springlearning.domain.OuterAccessView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jianweilin
 * @date 2018/8/17
 */
@RestController
@Slf4j
public class DirectorController {
    @RequestMapping(value = "/server/types",method = RequestMethod.POST)
    public String getServiceInstanceNodes(@RequestBody HostStatus hostStatus){
        log.info("hostStatus = {}",JSON.toJSONString(hostStatus));
        return JSON.toJSONString(hostStatus);
    }

    @RequestMapping(value = "/server/director",method = RequestMethod.POST)
    public String OnOrOffLine(@RequestBody List<OuterAccessView> outerAccessViewList){
        log.info("outerAccessViewList = {}",JSON.toJSONString(outerAccessViewList));
        return JSON.toJSONString(outerAccessViewList);
    }
}
