package com.cafe24.memory.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Staff;

@Mapper
public interface StaffMapper {
	
	public Staff selectStaffMember(String send_id);
}
