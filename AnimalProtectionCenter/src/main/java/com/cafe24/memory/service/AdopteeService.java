package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Adoptee;
import com.cafe24.memory.mapper.AdopteeMapper;

@Service
@Transactional
public class AdopteeService {
	
	@Autowired 
	AdopteeMapper adopteeMapper;
	
	public List<Adoptee> selectAdoptee(){
		
		 List<Adoptee> list = adopteeMapper.selectAdoptee(); 
		
		 return list;
	}
	
	public int insertAdoptee(Adoptee adt) {
		
		int result = adopteeMapper.insertAdoptee(adt);
		
		return result;
		
	}
}


