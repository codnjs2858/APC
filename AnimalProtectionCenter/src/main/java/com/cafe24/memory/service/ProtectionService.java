package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.mapper.ProtectionMapper;

@Service
@Transactional
public class ProtectionService {

	@Autowired
	ProtectionMapper protectionMapper;
	
	public List<ProtectionSpace> selectProtectionSpace() {
		return protectionMapper.selectProtectionSpace();
	}
	
}
