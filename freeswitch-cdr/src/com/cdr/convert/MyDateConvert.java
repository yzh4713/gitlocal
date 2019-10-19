package com.cdr.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * TODO:��������
 * @version 2019��6��25������7:50:40
 * @author yangzaihua
 * 		�Զ���ת����
 * 			�����ʱ���  string  ת��   date    ��װ��    javabean��
 * 			Converter<String,Date>  
 * 				String  ����Դ
 * 				Date   Ŀ��Դ
 */
public class MyDateConvert implements Converter<String, Date> {

	@Override
	public Date convert(String dateString) {

		// ���ַ��� ת�� date

		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
