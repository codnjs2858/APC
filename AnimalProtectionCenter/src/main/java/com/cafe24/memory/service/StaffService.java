package com.cafe24.memory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.mapper.StaffMapper;

@Service
@Transactional
public class StaffService {
	
	@Autowired private StaffMapper staffMapper;
	
	public Staff selectStaffMember(String send_id) {
		return staffMapper.selectStaffMember(send_id);
	}

}
