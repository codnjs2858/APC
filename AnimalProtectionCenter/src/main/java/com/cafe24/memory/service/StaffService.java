package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.mapper.StaffMapper;

@Service
@Transactional
public class StaffService {
	
	@Autowired private StaffMapper staffMapper;
	
	/**
	 * 직원 전체 조회(리스트) - 설채원
	 * @return
	 */
	public List<Staff> selectStaffList(){
		return staffMapper.selectStaffList();
	}
	
	/**
	 * 회원 아이디로 직원 조회 - 설채원
	 * @param send_id
	 * @return
	 */
	public Staff selectStaffMember(String send_id) {
		return staffMapper.selectStaffMember(send_id);
	}

	/**
	 * 직원 등록 - 설채원
	 * @param staff
	 * @return
	 */
	public int insertStaffMember(Staff staff) {
		return staffMapper.insertStaffMember(staff);
	}
}
