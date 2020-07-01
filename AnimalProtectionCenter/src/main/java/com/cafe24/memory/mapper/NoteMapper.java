package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Note;

@Mapper
public interface NoteMapper {
	public List<Note> selectNote(String recipient_member);
	public List<Note> selectSendNote(String send_member);
}
