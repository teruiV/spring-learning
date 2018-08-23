package com.frank.springlearning.domain;

import lombok.Data;

/**
 * @author jianweilin
 * @date 2018/8/23
 */
@Data
public class User {
    private String userName;
    private Role role;

    public String getUserInfo(){
        return String.format("user role is %s",role.getRoleName());
    }
}
