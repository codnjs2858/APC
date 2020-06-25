package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.QuestionExample;

@Mapper
public interface QuestionExampleMapper {
	public List<QuestionExample> selectQuestionExample();
	public List<QuestionExample> selectQuestionExample(QuestionExample question_example_code);
	public int updateQuestionExample(QuestionExample questionExample);
}
