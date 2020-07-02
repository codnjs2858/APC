package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.PetAdoption;

@Mapper
public interface PetAdoptionMapper {
	
	public List<PetAdoption> seletectPetAdoption();
	
	public int insertPetAdoption(PetAdoption petAdoption);
	
	public int updatePetAdoption(PetAdoption petAdoption);
	
	public int deletePetAdoption(String petAdoptionCode);
	
	public PetAdoption selectPetAdoption(String petAdoptionCode);
	
	public List<Map<String, Object>> selectPetAdoptionState();
	
	public List<PetAdoption> selectPetAdoptionStateList(String petAdoptionState);
}
