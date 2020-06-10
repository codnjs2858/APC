package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.PetFood;
import com.cafe24.memory.mapper.PetItemMapper;

@Service
@Transactional
public class PetItemService {
	
	@Autowired
	private PetItemMapper petItemMapper;
	
	public List<PetFood> selectPetFood(){
		return petItemMapper.selectPetFood();
	}
	
}
