package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Note;
import com.cafe24.memory.mapper.NoteMapper;

@Service
@Transactional
public class NoteService {
	
	@Autowired
	private NoteMapper noteMapper;
	
	public List<Note> selectNote(String recipient_member){
		return noteMapper.selectNote(recipient_member);
	}
	
	public List<Note> selectSendNote(String send_member){
		return noteMapper.selectSendNote(send_member);
	}
	
	public List<Note> getNote(Note note){
		return noteMapper.getNote(note);
	}
}
