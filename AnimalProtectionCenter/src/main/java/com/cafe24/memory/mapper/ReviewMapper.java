package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Review;

@Mapper
public interface ReviewMapper {
	
	public List<Review> selectReview();
	
}
