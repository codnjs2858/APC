package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalDisposal;

@Mapper
public interface AnimalDisposalMapper {
	
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
	
	public List<AnimalDisposal> selectDisposal();
	
	public AnimalDisposal selectDisposal(String send_code);
}
