package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Board;
import com.cafe24.memory.mapper.ReviewBoardMapper;

@Service
@Transactional
public class ReviewBoardService {
	
	@Autowired
	private ReviewBoardMapper reviewBoardMapper;
	
	public int insertReviewBoard(Board review) {
		int result = reviewBoardMapper.insertReviewBoard(review);
		return result;
	}
	public List<Board> selectPostsReviewBoard(Board review){
		return reviewBoardMapper.selectPostsReviewBoard(review);
	}
	public List<Board> selectReviewBoard(){
		return reviewBoardMapper.selectReviewBoard();
	}

}
