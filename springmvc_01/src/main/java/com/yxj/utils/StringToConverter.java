package com.yxj.utils;

import com.sun.org.apache.bcel.internal.generic.IFNULL;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/9
 * @version: 1.0
 */
public class StringToConverter implements Converter<String, Date> {

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Date convert(String source) {
        if (source == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
