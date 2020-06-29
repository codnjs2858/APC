package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalDisposal;
import com.cafe24.memory.mapper.AnimalDisposalMapper;


@Service
@Transactional
public class AnimalDisposalService {

	@Autowired private AnimalDisposalMapper animalDisposalMapper;
	
	/**
	 * 이름, 연락처로 반환코드 조회
	 * @param reName
	 * @param rePhone
	 * @return
	 */
	public String DisposalReturnCode(String reName, String rePhone) {
		return animalDisposalMapper.DisposalReturnCode(reName, rePhone);
	}
	
	/**
	 * 회원 아이디로 입양인코드 조회
	 * @param send_id
	 * @return
	 */
	public String DisposalmemberId(String send_id) {
		return animalDisposalMapper.DisposalmemberId(send_id);
	}
	
	/**
	 * 동물 처리 등록
	 * @param disposal
	 * @return
	 */
	public int insertAnimalDisposal(AnimalDisposal disposal) {
		return animalDisposalMapper.insertAnimalDisposal(disposal);
	}
	
	
	/**
	 * 동물 처리 조회
	 * @param send_code
	 * @return
	 */
	public AnimalDisposal selectDisposal(String send_code){
		return animalDisposalMapper.selectDisposal(send_code);
	}
	public List<AnimalDisposal> selectDisposal(){
		return animalDisposalMapper.selectDisposal();
	}
}
