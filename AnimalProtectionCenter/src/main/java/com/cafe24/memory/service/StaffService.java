package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Commute;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.domain.Vacation;
import com.cafe24.memory.mapper.StaffMapper;

@Service
@Transactional
public class StaffService {
	
	@Autowired private StaffMapper staffMapper;
	
	/**
	 * 직원으로 등록되지 않은 관리자 회원 리스트
	 * @return
	 */
	public List<Member> selectNotStaffLevel(){
		return staffMapper.selectNotStaffLevel();
	}
	
	/**
	 * 직원 휴가 삭제
	 * @param send_code
	 * @return
	 */
	public int deleteStaffVacation(String send_code) {
		return staffMapper.deleteStaffVacation(send_code);
	}
	
	/**
	 * 직원 휴가 등록
	 * @param v
	 * @return
	 */
	public int insertStaffVacation(Vacation v) {
		return staffMapper.insertStaffVacation(v);
	}
	
	/**
	 * 직원 휴가 업데이트(휴가코드,휴가상태)
	 * @param v
	 * @return
	 */
	public int vacationAdmission(Vacation v) {
		return staffMapper.vacationAdmission(v);
	}
	
	/**
	 * 직원 휴가 리스트
	 * @return
	 */
	public List<Vacation> selectStaffVacation(){
		return staffMapper.selectStaffVacation();
	}
	public List<Vacation> selectStaffVacation(String send_code){
		return staffMapper.selectStaffVacation(send_code);
	}
	public List<Vacation> selectCompleteVacation(){
		return staffMapper.selectCompleteVacation();
	}
	
	/**
	 * 근태 코드로 근무시간 셋팅
	 * @param send_code
	 * @return
	 */
	public int selectWorkTime(String send_code) {
		return staffMapper.selectWorkTime(send_code);
	}
	
	/**
	 * 직원 출근
	 * @param send_code - 직원코드
	 * @return
	 */
	public int startWork(Commute com) {
		return staffMapper.startWork(com);
	}
	/**
	 * 직원 퇴근
	 * @param send_code - 근태코드
	 * @return
	 */
	public int endWork(Commute com) {
		return staffMapper.endWork(com);
	}
	
	/**
	 * 직원 근태 리스트
	 * @return
	 */
	public List<Commute> commuteList(){
		return staffMapper.commuteList();
	}
	
	/**
	 * 직원 조회(리스트) - 설채원
	 * @return
	 */
	public List<Staff> selectStaffList(){
		return staffMapper.selectStaffList();
	}
	public Staff selectStaffList(String send_code){
		return staffMapper.selectStaffList(send_code);
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
	 * 직원 퇴직처리
	 * @param send_code
	 * @return
	 */
	public int retireStaff(String send_code) {
		return staffMapper.retireStaff(send_code);
	}
	
	/**
	 * 직원 등록 - 설채원
	 * @param staff
	 * @return
	 */
	public int insertStaffMember(Staff staff) {
		return staffMapper.insertStaffMember(staff);
	}
	/**
	 * 직원 수정
	 * @param staff
	 * @return
	 */
	public int updateStaffInfo(Staff staff) {
		return staffMapper.updateStaffInfo(staff);
	}
	
	/**
	 * 직원 삭제
	 * @param send_code
	 * @return
	 */
	public int deleteStaff(String send_code) {
		return staffMapper.deleteStaff(send_code);
	}
}
