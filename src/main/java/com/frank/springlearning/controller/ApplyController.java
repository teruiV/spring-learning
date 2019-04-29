package com.frank.springlearning.controller;

import com.alibaba.fastjson.JSON;
import com.frank.springlearning.common.ApiResponse;
import com.frank.springlearning.domain.Apply;
import com.frank.springlearning.domain.ApplyList;
import com.frank.springlearning.domain.ApplyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jianweilin
 * @date 2018/7/14
 */
@RestController
@Slf4j
public class ApplyController {
    @RequestMapping(value = "/apply/list", method = RequestMethod.GET)
    public ApiResponse<ApplyList> applyList(@RequestParam(required = false, defaultValue = "1") Integer pageNo, @RequestParam(required = false, defaultValue = "10") Integer pageSize
            , @RequestParam Integer applyType, @RequestParam(required = false, defaultValue = "") String searchContent) {
        printHeader();
        List<Apply> applies = applyType == 1 ? Apply.initApplyList() : Apply.initApproveList();
        if (!StringUtils.isEmpty(searchContent)) {
            applies = applies.stream().filter(info -> info.getApplyName().contains(searchContent)).collect(Collectors.toList());
        }
        return ApiResponse.success(ApplyList.initApplyList(applies, pageNo, pageSize));
    }

    @RequestMapping(value = "/apply/isAdmin", method = RequestMethod.GET)
    public ApiResponse isAdmin(@RequestParam String mail) {
        printHeader();
        List<String> mailList = Arrays.asList();
        return ApiResponse.success(mailList.contains(mail) ? 1 : 0);
    }

    @RequestMapping(value = "/apply/add", method = RequestMethod.POST)
    public ApiResponse saveApply(@RequestParam String exchangeName, @RequestParam String exchangeType, @RequestParam String queueName, @RequestParam String bindType) {
        printHeader();
        log.info("exchangeName = {}, exchangeType = {} ,queueName = {}, bindType = {}", exchangeName, exchangeType, queueName, bindType);
        return ApiResponse.success("请求成功");
    }


    @RequestMapping(value = "/apply/user/me", method = RequestMethod.GET)
    public ApiResponse<ApplyUser> personalInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ApplyUser applyUser = JSON.parseObject(request.getHeader("X-Dada-User"),ApplyUser.class);
        log.info("applyUser = {}",JSON.toJSONString(applyUser));
        return ApiResponse.success(applyUser);
    }


    private void printHeader(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("URL: {}, X-Dada-User : {}",request.getRequestURI(), request.getHeader("X-Dada-User"));
    }

}
