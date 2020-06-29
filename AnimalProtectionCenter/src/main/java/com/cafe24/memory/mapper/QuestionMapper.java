package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Question;

@Mapper
public interface QuestionMapper {
	public List<Question> selectQuestion(Question question_code);
	public List<Question> selectQuestion();
	public int updateQuestion(Question question);
}
