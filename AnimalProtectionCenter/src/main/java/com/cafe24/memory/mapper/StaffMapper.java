package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Staff;

@Mapper
public interface StaffMapper {
	
	/**
	 * 직원 전체 조회(리스트) - 설채원
	 * @return
	 */
	public List<Staff> selectStaffList();
	
	/**
	 * 회원 아이디로 직원 검색 - 설채원
	 * @param send_id
	 * @return
	 */
	public Staff selectStaffMember(String send_id);
	
	/**
	 * 직원 등록
	 * @param staff
	 * @return
	 */
	public int insertStaffMember(Staff staff);
}
