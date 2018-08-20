package com.frank.springlearning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jianweilin
 * @date 2018/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyUser {
    private String dept;
    private String email;
    private String phone;
    private String username;
}
