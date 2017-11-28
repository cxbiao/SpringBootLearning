package com.bryan;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//日期转换器
public class MyDateFormatter implements Formatter<Date> {

    private  SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return sf.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return  sf.format(date);
    }
}
