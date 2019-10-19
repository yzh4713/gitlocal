package com.cdr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdr.bean.CallDetail;

@Mapper
public interface CallDetailMapper {

	//添加话单数据
	public boolean insert(CallDetail call);
	
}
