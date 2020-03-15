package com.yxj.ssm_demo.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/11
 * @version: 1.0
 */
public class StringToDate implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (source == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("字符转日期出现错误");
        }
    }
}
