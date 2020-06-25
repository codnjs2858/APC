package com.cafe24.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Question;
import com.cafe24.memory.mapper.QuestionMapper;

@Service
@Transactional
public class QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	public int deleteQuestion(String question_code) {
		return questionMapper.deleteQuestion(question_code);
	}
	
	public List<Question> selectQuestion(){
		return questionMapper.selectQuestion();
	}
	
	public List<Question> selectQuestion(Question question_code){
		return questionMapper.selectQuestion(question_code);
	}
	
	public int updateQuestion(Question question) {
		return questionMapper.updateQuestion(question);
	}

}
