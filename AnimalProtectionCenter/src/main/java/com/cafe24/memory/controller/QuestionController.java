package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.memory.domain.Question;
import com.cafe24.memory.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired private QuestionService questionService;

	@GetMapping("/question")
	public String question(Model model) {
		model.addAttribute("selectQuestion", questionService.selectQuestion());
		return "question/question";
	}
	
	@GetMapping("/questionExample")
	public String questionExample(Model model) {
		return "question/questionExample";
	}
	
	@GetMapping("/questionDelete")
	public String questionDelete(Question question) {
		questionService.deleteQuestion(question.getQuestion_code());
		return "redirect:question";
	}
}
