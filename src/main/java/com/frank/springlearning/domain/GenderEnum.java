package com.frank.springlearning.domain;

/**
 * @author jianweilin
 * @date 2018/8/19
 */
public enum GenderEnum {
    male("male"),
    female("female");

    private final String value;

    GenderEnum(String value) {
        this.value = value;
    }


    public static GenderEnum get(String gender) {
        for (GenderEnum e : values()) {
            if(e.value.equals(gender)){
                return e;
            }
        }
        return null;
    }



    @Override
    public String toString() {
        return "enum GenderEnum{" +
                "value='" + value + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(GenderEnum.get("male"));

    }
}
