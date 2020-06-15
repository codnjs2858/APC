package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.CompanionAnimalRegister;
import com.cafe24.memory.mapper.CompanionAnimalRegisterMapper;

@Service
@Transactional
public class CompanionAnimalRegisterService {
	
	@Autowired 
	CompanionAnimalRegisterMapper companionAnimalRegisterMapper;
	
	public List<CompanionAnimalRegister> selectCompanionAnimalRegisterList(){
		
		List<CompanionAnimalRegister> list = companionAnimalRegisterMapper.selectCompanionAnimalRegisterList();
		
		return list;
	}
	
	public List<String> selectMemberAll(){
		
		 List<String> mlist = (List<String>) companionAnimalRegisterMapper.selectMemberAll();
		
		 return mlist;
	}
	
	public int companionAnimalRegisterInsert(CompanionAnimalRegister
	  companionAnimalRegister) {
	  
	  int result = companionAnimalRegisterMapper.addCompanionAnimalRegisterInsert(
	  companionAnimalRegister);
	  
	  return result;
	  
	  }
	 
}
