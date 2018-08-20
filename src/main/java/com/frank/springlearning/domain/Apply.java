package com.frank.springlearning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/7/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apply {
    private Integer applyNo;
    private String title;
    private String processName;
    private String applyName;
    private String roleName;
    private String cityName;
    private String applyTime;
    private String handleName;
    private String operateStatus;

    private static String formatContent(String content, Integer applyNo) {
        return String.format("%s - %d", content, applyNo);
    }

    private static String initCreateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static List<Apply> initApplyList() {
        return IntStream.range(0, 15).boxed().map(num -> new Apply(num,
                formatContent("标题", num),
                formatContent("流程名称", num),
                formatContent("申请名称", num),
                formatContent("城市经理", num),
                formatContent("上海", num),
                initCreateTime(),
                formatContent("申请人", num),
                "待审批")).collect(Collectors.toList());
    }

    public static List<Apply> initApproveList() {
        return IntStream.range(16, 30).boxed().map(num -> new Apply(num,
                formatContent("审核-标题", num),
                formatContent("审核-流程名称", num),
                formatContent("审核-申请名称", num),
                formatContent("审核-城市经理", num),
                formatContent("审核-上海", num),
                initCreateTime(),
                formatContent("审核-申请人", num),
                "审核-待审批")).collect(Collectors.toList());
    }

    public static Apply initApply(String name) {
        Apply apply = new Apply();
        apply.setApplyName(name);
        return apply;
    }
}
