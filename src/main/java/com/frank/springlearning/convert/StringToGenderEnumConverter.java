package com.frank.springlearning.convert;

import com.frank.springlearning.domain.GenderEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author jianweilin
 * @date 2018/8/19
 */
@Component
public class StringToGenderEnumConverter implements Converter<String,GenderEnum> {

    @Override
    public GenderEnum convert(String source) {
        return GenderEnum.get(source);
    }
}
