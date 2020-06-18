package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Question;

@Mapper
public interface QuestionMapper {
	public int deleteQuestion(String question_code);
	public List<Question> selectQuestion();
}
