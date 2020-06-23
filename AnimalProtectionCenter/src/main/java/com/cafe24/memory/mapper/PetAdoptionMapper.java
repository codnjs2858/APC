package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.PetAdoption;

@Mapper
public interface PetAdoptionMapper {
	
	public List<PetAdoption> seletectPetAdoption();
	
	public int insertPetAdoption(PetAdoption petAdoption);
	
	public int updatePetAdoption(PetAdoption petAdoption);
	
	public int deletePetAdoption(PetAdoption petAdoption);
}
