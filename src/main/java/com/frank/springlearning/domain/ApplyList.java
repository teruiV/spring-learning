package com.frank.springlearning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianweilin
 * @date 2018/7/14
 */
@Data
@AllArgsConstructor
public class ApplyList {
    private List<Apply> applys;
    private Integer totalPage;

    public static List<Apply> initApplys(List<Apply> applys,Integer pageNo,Integer pageSize){
        int startNo = (pageNo - 1) * pageSize;
        if(startNo < 0) {
            startNo = 0;
        }

        if(startNo >= applys.size()){
            return new ArrayList<>();
        }
        int endNo = startNo + pageSize;
        if(endNo >= applys.size()){
            endNo = applys.size();
        }

        return applys.subList(startNo,endNo);
    }

    public static Integer getTotalPage(Integer totalCount,Integer pageSize){
        return (int)Math.ceil(totalCount / (double) pageSize);
    }

    public static ApplyList initApplyList(List<Apply> applys,Integer pageNo,Integer pageSize){
        return new ApplyList(initApplys(applys,pageNo,pageSize),getTotalPage(applys.size(),pageSize));
    }


}
