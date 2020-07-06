package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Commute;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.domain.Vacation;

@Mapper
public interface StaffMapper {
	
	/**
	 * 직원 휴가 삭제
	 * @param send_code
	 * @return
	 */
	public int deleteStaffVacation(String send_code);
	
	/**
	 * 직원 휴가 등록(신청)
	 * @param v
	 * @return
	 */
	public int insertStaffVacation(Vacation v);
	
	/**
	 * 직원 휴가 업데이트(휴가코드,휴가상태)
	 * @param v
	 * @return
	 */
	public int vacationAdmission(Vacation v);
	
	/**
	 * 직원 휴가 리스트
	 * @return
	 */
	public List<Vacation> selectStaffVacation();
	public List<Vacation> selectStaffVacation(String send_code);
	public List<Vacation> selectCompleteVacation();
	
	/**
	 * 근태코드로 근무시간
	 * @param send_code
	 * @return
	 */
	public int selectWorkTime(String send_code);
	
	/**
	 * 직원 출근 
	 * @param send_code - 직원코드
	 * @return
	 */
	public int startWork(Commute com);
	
	/**
	 * 직원 퇴근
	 * @param send_code - 근태코드
	 * @return
	 */
	public int endWork(Commute com);
	/**
	 * 직원 근태 리스트
	 * @return
	 */
	public List<Commute> commuteList();
	
	/**
	 * 직원 조회(리스트) - 설채원
	 * @return
	 */
	public List<Staff> selectStaffList();
	public Staff selectStaffList(String send_code);
	
	/**
	 * 회원 아이디로 직원 검색 - 설채원
	 * @param send_id
	 * @return
	 */
	public Staff selectStaffMember(String send_id);
	
	/**
	 * 직원 퇴사 처리 - 설채원
	 * @param send_code
	 * @return
	 */
	public int retireStaff(String send_code);
	
	/**
	 * 직원 등록 - 설채원
	 * @param staff
	 * @return
	 */
	public int insertStaffMember(Staff staff);
	
	/**
	 * 직원 삭제 - 설채원
	 * @param send_code
	 * @return
	 */
	public int deleteStaff(String send_code);
	
	/**
	 * 직원 수정 - 설채원
	 * @param staff
	 * @return
	 */
	public int updateStaffInfo(Staff staff);
}
