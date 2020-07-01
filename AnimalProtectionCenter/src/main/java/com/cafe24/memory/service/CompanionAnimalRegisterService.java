package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.CompanionAnimalRegister;
import com.cafe24.memory.mapper.AnimalCenterMapper;
import com.cafe24.memory.mapper.CompanionAnimalRegisterMapper;

@Service
@Transactional
public class CompanionAnimalRegisterService {
	
	@Autowired 
	CompanionAnimalRegisterMapper companionAnimalRegisterMapper;
	
	@Autowired
	AnimalCenterMapper animalCenterMapper;
	
	public List<CompanionAnimalRegister> selectCompanionAnimalRegisterList(){
		
		List<CompanionAnimalRegister> list = companionAnimalRegisterMapper.selectCompanionAnimalRegisterList();
		
		return list;
	}
	
	public List<String> selectMemberAll(){
		
		 List<String> mlist = (List<String>) companionAnimalRegisterMapper.selectMemberAll();
		 
		 return mlist;
	}
	
	public int insertCompanionAnimalRegister(CompanionAnimalRegister cAniReg) {
		
		if("".equals(cAniReg.getCompanionRegisterDate())) {
			cAniReg.setCompanionRegisterDate(null);
		}if("".equals(cAniReg.getCancleCompanionInDate())) {
			cAniReg.setCancleCompanionInDate(null);
		}
	  
		return companionAnimalRegisterMapper.insertCompanionAnimalRegister(cAniReg);
	}
	
	public int updateCompanionAnimalRegister(CompanionAnimalRegister cAniReg) {
		
		if("".equals(cAniReg.getCompanionRegisterDate())) {
			cAniReg.setCompanionRegisterDate(null);
		}if("".equals(cAniReg.getCancleCompanionInDate())) {
			cAniReg.setCancleCompanionInDate(null);
		}
		return companionAnimalRegisterMapper.updateCompanionAnimalRegister(cAniReg);
	}
	
	public AnimalCenter selectCenterAnimal(String send_code){
		
		return animalCenterMapper.selectCenterAnimal(send_code);
	}
	
	public CompanionAnimalRegister selectCompanionAnimalRegister(String companionAnimalRegisterCode) {
		
		return companionAnimalRegisterMapper.selectCompanionAnimalRegister(companionAnimalRegisterCode);
	}
	
	public int deleteCompanionAnimalRegister(String companionAnimalRegisterCode) {
		
		return companionAnimalRegisterMapper.deleteCompanionAnimalRegister(companionAnimalRegisterCode);
		
	}
	
}
