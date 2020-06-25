package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Board;
import com.cafe24.memory.mapper.NoticeMapper;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	public int insertNotice(Board notice) {
		int result = noticeMapper.insertNotice(notice);
		return result;
	}
	public List<Board> selectPosts(Board notice){
		return noticeMapper.selectPosts(notice);
	}
	public List<Board> selectNotice(){
		return noticeMapper.selectNotice();
	}

}
