package com.cdr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdr.bean.NewCdr;

/**
 * TODO:类功能介绍
 *     
 * @version 2019年11月3日下午1:21:20
 * @author 糟老头子
 */
@Mapper
public interface NewCdrMapper {

	// 添加话单数据
	public int insert(NewCdr nc);

}
