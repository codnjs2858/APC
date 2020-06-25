package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Board;

@Mapper
public interface ReviewBoardMapper {
	public int insertReviewBoard(Board review);
	public List<Board> selectPostsReviewBoard(Board review);
	public List<Board> selectReviewBoard();
}
