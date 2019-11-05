package com.cdr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdr.bean.NewCdr;
import com.cdr.mapper.NewCdrMapper;

/**
 * TODO:类功能介绍
 *     
 * @version 2019年11月3日下午1:25:29
 * @author 糟老头子
 */
@Service
public class NewCdrService {

	@Autowired
	private NewCdrMapper newCdrMapper;
	
	public int insert(NewCdr nc) {
		
		return newCdrMapper.insert(nc);
		
	}
	
}
