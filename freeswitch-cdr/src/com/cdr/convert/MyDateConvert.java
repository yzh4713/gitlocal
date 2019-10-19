package com.cdr.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * TODO:方法描述
 * @version 2019年6月25日下午7:50:40
 * @author yangzaihua
 * 		自定义转换器
 * 			请求的时候把  string  转成   date    封装到    javabean中
 * 			Converter<String,Date>  
 * 				String  请求源
 * 				Date   目标源
 */
public class MyDateConvert implements Converter<String, Date> {

	@Override
	public Date convert(String dateString) {

		// 把字符串 转成 date

		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
