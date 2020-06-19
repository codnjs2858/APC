package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Gift;
import com.cafe24.memory.mapper.GiftMapper;

@Service
@Transactional
public class GiftService {
	
	@Autowired
	GiftMapper giftMapper;
	
	public List<Gift> selectGift(){
		
		List<Gift> list = giftMapper.selectGift();
		
		return list;
		
	}
	
}
