package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.QuestionExample;
import com.cafe24.memory.mapper.QuestionExampleMapper;

@Service
@Transactional
public class QuestionExampleService {
	
	@Autowired
	private QuestionExampleMapper questionExampleMapper;
	
	public List<QuestionExample> selectQuestionExample(){
		return questionExampleMapper.selectQuestionExample();
	}
}
