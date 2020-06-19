package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Review;
import com.cafe24.memory.mapper.ReviewMapper;

@Service
@Transactional
public class ReviewService {
	
	@Autowired
	ReviewMapper reviewMapper;
	
	public List<Review> selectReview(){
		
		List<Review> list = reviewMapper.selectReview();
		
		return list;
		
	}
}
