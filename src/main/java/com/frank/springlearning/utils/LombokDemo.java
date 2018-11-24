package com.frank.springlearning.utils;

/**
 * @author jianweilin
 * @date 2018/11/10
 */

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LombokDemo {
    private static final ThreadLocal<Long> GENERATE_REQUIRE_ID = new ThreadLocal<>();

    private Long requireId;
    private String name;

    public Long generateRequireId(){
        Long id = GENERATE_REQUIRE_ID.get();
        id = id == null ? 0 : id + 1;
        GENERATE_REQUIRE_ID.set(id);
        log.info(">>>> generate require id end require_id = {}  >>>>", GENERATE_REQUIRE_ID.get());
        return GENERATE_REQUIRE_ID.get();
    }
    public LombokDemo getNewInstance(){
        return LombokDemo.builder().requireId(generateRequireId()).name("测试-").build();
//        return new LombokDemo(generateRequireId(),"测试-");
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static void main(String[] args) {
        LombokDemo demo1 = new LombokDemo().getNewInstance();
        LombokDemo demo2 = new LombokDemo().getNewInstance();
        LombokDemo demo3 = new LombokDemo().getNewInstance();
        LombokDemo demo4 = new LombokDemo().getNewInstance();
        LombokDemo demo5 = new LombokDemo().getNewInstance();
        System.out.println(demo1);
        System.out.println(demo2);
        System.out.println(demo3);
        System.out.println(demo4);
        System.out.println(demo5);
//        log.info("demo1 = {}",demo1);
//        log.info("demo2 = {}",demo2);
//        log.info("demo3 = {}",demo3);
//        log.info("demo4 = {}",demo4);
//        log.info("demo5 = {}",demo5);
    }
}
