package com.cdr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdr.bean.CrmRecord;
import com.cdr.mapper.CrmRecordMapper;

@Service
public class CrmRecordService {

	@Autowired
	private CrmRecordMapper crmRecordMapper;
	
	public boolean insert(CrmRecord crm) {
		
		return crmRecordMapper.insert(crm);
		
	}
	
}
