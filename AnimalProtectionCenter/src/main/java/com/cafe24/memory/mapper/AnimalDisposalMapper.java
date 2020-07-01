package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalDisposal;

@Mapper
public interface AnimalDisposalMapper {
	
	public int updateAnimalDisposal(AnimalDisposal disposal);
	
	/**
	 * 동물 코드로 보고관리 삭제
	 * @param send_code
	 * @return
	 */
	public int deleteProtection(String send_code);
	
	/**
	 * 동물 코드로 처리 삭제(처리취소) - 설채원
	 * @return
	 */
	public int deleteAnimalDisposal(String send_code);
	
	/**
	 * 이름, 연락처로 반환코드 조회
	 * @param reName
	 * @param rePhone
	 * @return
	 */
	public String DisposalReturnCode(String reName, String rePhone);
	
	/**
	 * 회원 아이디로 입양인코드 조회
	 * @param send_id
	 * @return
	 */
	public String DisposalmemberId(String send_id);
	
	/**
	 * 동물 처리 등록 -설채원
	 * @param disposal
	 * @return
	 */
	public int insertAnimalDisposal(AnimalDisposal disposal);
	
	/**
	 * 동물 처리 조회
	 * @return
	 */
	public List<AnimalDisposal> selectDisposal();
	public AnimalDisposal selectDisposal(String send_code);
}
