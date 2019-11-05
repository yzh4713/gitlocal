package com.cdr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdr.bean.CrmRecord;

@Mapper
public interface CrmRecordMapper {

	//添加话单数据	
	public boolean insert(CrmRecord cr);
	
}
