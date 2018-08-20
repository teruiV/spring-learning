package com.frank.springlearning.domain;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author jianweilin
 * @date 2018/6/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    private Long bdId;

    @NotBlank
    private String bdName;

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new User(1008L,"测试")));
    }
}
