package com.frank.springlearning.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jianweilin
 * @date 2018/8/20
 */
@Component
public class StringToDateConverter implements Converter<String,Date>{
    private SimpleDateFormat sdf;

    public StringToDateConverter() {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Nullable
    @Override
    public Date convert(String s) {
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
