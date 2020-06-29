package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.mapper.ProtectionMapper;

@Service
@Transactional
public class ProtectionService {

	@Autowired
	ProtectionMapper protectionMapper;
	
	public int deleteProtectionSpace(String protectionSpaceCode) {
		return protectionMapper.deleteProtectionSpace(protectionSpaceCode);
	}
	
	public int insertProtectionSpace(ProtectionSpace protectionSpace) {
		return protectionMapper.insertProtectionSpace(protectionSpace);
	}
	
	/**
	 * 보호공간에서 빼낼때 보호공간관리에 미보호로 해주고 보호공간에서 빼야함 - 손충기
	 * @param protectionSpaceCode
	 * @param animalProtectionNum
	 * @return
	 */
	public int exitProtectionSpace(String protectionSpaceCode, String animalProtectionNum) {
		int result = 0;
		
		result += protectionMapper.updateAnimalProtectionExitSpace(protectionSpaceCode);
		result += protectionMapper.updateAnimalProtectionExit(animalProtectionNum);
		
		return result;
	}
	
	public List<AnimalCenter> selectAnimalHaveNotSpace(){
		return protectionMapper.selectAnimalHaveNotSpace();
	}
	
	public List<ProtectionSpace> selectProtectionSpaceUseState(String state) {
		return protectionMapper.selectProtectionSpaceUseState(state);
	}
	
	public List<ProtectionSpace> selectProtectionSpaceOutAnimal(){
		return protectionMapper.selectProtectionSpaceOutAnimal();
	}
	
	public List<ProtectionSpace> selectProtectionSpaceInAnimal(){
		return protectionMapper.selectProtectionSpaceInAnimal();
	}
	
	/**
	 * 센터등록된 동물을 보호관리에 등록시킴 - 손충기
	 * 보호공간에서 우선 등록코드로 찾아보고 없으면 넣고 보호공간에도 넣어 준다.
	 * @param animalProtect
	 * @return
	 */
	public int insertAniamlProtection(AnimalProtect animalProtect) {
		int result = 0;
		
		AnimalProtect ap = protectionMapper.selectAnimalProtect(animalProtect.getAnimalInsertCode());
		
		if(ap == null) {
			//보호관리 넣음
			result += protectionMapper.insertAniamlProtection(animalProtect);			
		}
		//보호공간에 넣어줌
		result += protectionMapper.updateAnimalProtectionInSpace(animalProtect);
		
		return result;
	}
	
	public ProtectionSpace modifyProtectionSpaceBySpace(String space) {
		ProtectionSpace ps = selectProtectionSpaceByCode(space);
		AnimalProtect ap = selectAnimalProtect(ps.getAnimalInsertCode());
		ps.setAnimalProtect(ap);
		
		return ps;
	}
	
	/**
	 * 보호관리에 등록함 - 손충기
	 * 등록전에 보호공간에 있는지 없는지를 보고
	 * 보호관리에 미보호로 있느지 없는지를 보고 
	 * 넣어줌
	 * @param animalProtect
	 * @return
	 */
	public int updateAnimalProtectionIn(AnimalProtect animalProtect) {
		List<ProtectionSpace> ps = protectionMapper.selectProtectionSpaceByAniInCode(animalProtect.getAnimalInsertCode());
		List<AnimalProtect> ap = protectionMapper.selectAnimalNotProtect(animalProtect.getAnimalInsertCode());
		int result = 0;
		System.out.println(animalProtect + " <-- animalProtect updateAnimalProtectionIn() ProtectionService.java");
		System.out.println(ap + " <-- animalProtect updateAnimalProtectionIn() ProtectionService.java");
		System.out.println(ps + " <-- ProtectionService.java");
		
		//보호공간에 있는지 없는지를 체크
		if(ps != null && ps.size() != 0) {
			for(int i = 0; i < ps.size(); i++) {
				result += protectionMapper.updateAnimalProtectionExitSpace(ps.get(i).getProtectSpaceCode());				
			}
		//보호관리가 미보호인 상태를 체크
		}else if(ap != null && ap.size() == 0){
			result += protectionMapper.insertAniamlProtection(animalProtect);
		}
		
		System.out.println(animalProtect + " <-- animalProtect updateAnimalProtectionIn() ProtectionService.java");
		//보호공간에 넣어줌
		result += protectionMapper.updateAnimalProtectionInSpace(animalProtect);
		
		return result;
	}
	
	public ProtectionSpace selectProtectionSpaceByCode(String proSpaceCode) {
		return protectionMapper.selectProtectionSpaceByCode(proSpaceCode);
	}
	
	public List<ProtectionSpace> selectProtectionSpace() {
		return protectionMapper.selectProtectionSpace();
	}
	
	public AnimalProtect selectAnimalProtect(String animalNum) {
		return protectionMapper.selectAnimalProtect(animalNum);
	}
	
}
