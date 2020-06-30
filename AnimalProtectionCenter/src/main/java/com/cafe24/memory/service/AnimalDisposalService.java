package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalDisposal;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.mapper.AnimalDisposalMapper;
import com.cafe24.memory.mapper.ProtectionMapper;


@Service
@Transactional
public class AnimalDisposalService {

	@Autowired private AnimalDisposalMapper animalDisposalMapper;
	@Autowired private ProtectionMapper protectionMapper;
	
	/**
	 * 동물 코드로 검색해 보호 삭제, 공간 비우기
	 * @param send_code
	 * @return
	 */
	public int deleteProtectExitSpace(String send_code) {
		int result = 0;
		
		List<ProtectionSpace> ps = protectionMapper.selectProtectionSpaceByAniInCode(send_code);
		for(int i = 0; i < ps.size(); i++) {
			result = protectionMapper.updateAnimalProtectionExitSpace(ps.get(i).getProtectSpaceCode());				
		}
		result = animalDisposalMapper.deleteAnimalDisposal(send_code);
		return result;
	}
	
	/**
	 * 동물 코드로 처리 삭제(처리취소) - 설채원
	 * @param send_code
	 * @return
	 */
	public int deleteAnimalDisposal(String send_code) {
		return animalDisposalMapper.deleteAnimalDisposal(send_code);
	}
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
