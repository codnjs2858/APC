package com.cafe24.memory.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.PetAdoption;
import com.cafe24.memory.mapper.PetAdoptionMapper;

@Service
@Transactional
public class PetAdoptionService {
	
	@Autowired
	PetAdoptionMapper petAdoptionMapper;
	
	public List<PetAdoption> seletectPetAdoption(){
		
		List<PetAdoption> list = petAdoptionMapper.seletectPetAdoption();
		
		return list;
	}
	
	public int insertPetAdoption(PetAdoption petAdoption) {
		
		if("".equals(petAdoption.getPetAdoptionManagementDate())) {
			petAdoption.setPetAdoptionManagementDate(null);
		}if("".equals(petAdoption.getPetAdoptionEndDate())) {
			petAdoption.setPetAdoptionEndDate(null);
		}
		
		int result = petAdoptionMapper.insertPetAdoption(petAdoption);
		
		return result;
		
	}
	
	public int updatePetAdoption(PetAdoption petAdoption) {
		
		if("".equals(petAdoption.getPetAdoptionManagementDate())) {
			petAdoption.setPetAdoptionManagementDate(null);
		}if("".equals(petAdoption.getPetAdoptionEndDate())) {
			petAdoption.setPetAdoptionEndDate(null);
		}
		
		int result = petAdoptionMapper.updatePetAdoption(petAdoption);
		
		return result;
		
	}
	
	public int deletePetAdoption(String petAdoptionCode) {
		
		int result = petAdoptionMapper.deletePetAdoption(petAdoptionCode);
		
		return result;
		
	}
	
	public PetAdoption selectPetAdoption(String petAdoptionCode) {
		
		return petAdoptionMapper.selectPetAdoption(petAdoptionCode);
	}
	
	public List<Map<String, Object>> selectPetAdoptionState(){
		
		return petAdoptionMapper.selectPetAdoptionState();
	}

	public List<PetAdoption> selectPetAdoptionStateList(String petAdoptionState){
		
		return petAdoptionMapper.selectPetAdoptionStateList(petAdoptionState);
	}
}
