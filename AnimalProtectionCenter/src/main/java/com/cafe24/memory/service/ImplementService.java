package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Implement;
import com.cafe24.memory.mapper.ImplementMapper;

@Service
@Transactional
public class ImplementService {

	@Autowired
	ImplementMapper implementMapper;
	
	public Implement selectImplementByCode(String implementCode) {
		return implementMapper.selectImplementByCode(implementCode);
	}
	
	public List<Implement> selectImplement(){
		return implementMapper.selectImplement();
	}
	
}
