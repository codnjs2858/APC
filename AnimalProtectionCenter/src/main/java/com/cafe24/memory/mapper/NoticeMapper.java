package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Board;

@Mapper
public interface NoticeMapper {
	public int insertNotice(Board notice);
	public List<Board> selectPosts(Board notice);
	public List<Board> selectNotice();
}
