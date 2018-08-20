package com.frank.springlearning.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jianweilin
 * @date 2018/7/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable{
    private String status;
    private T content;


    public static <T> ApiResponse<T> fail(T content) {
        return new ApiResponse("fail", content);
    }

    public static <T> ApiResponse<T> success(T content) {
        return new ApiResponse("ok", content);
    }
}
