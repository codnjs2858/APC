package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Notice;

@Mapper
public interface NoticeMapper {
	public List<Notice> selectNotice();
}
