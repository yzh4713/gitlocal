package com.cdr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdr.bean.CallDetail;
import com.cdr.mapper.CallDetailMapper;

@Service
public class CallDetailService {

	@Autowired
	private CallDetailMapper callDetailMapper;
	
	public boolean insert(CallDetail call) {
		
		return callDetailMapper.insert(call);
		
	}
	
}
