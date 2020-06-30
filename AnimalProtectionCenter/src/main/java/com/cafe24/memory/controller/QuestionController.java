package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.domain.Question;
import com.cafe24.memory.domain.QuestionExample;
import com.cafe24.memory.service.QuestionExampleService;
import com.cafe24.memory.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired private QuestionService questionService;
	@Autowired private QuestionExampleService questionExampleService;

	@GetMapping("/question")
	public String question(Model model) {
		model.addAttribute("selectQuestion", questionService.selectQuestion());
		return "question/question";
	}
	
	@GetMapping("/questionExample")
	public String questionExample(Model model) {
		model.addAttribute("selectQuestionExample", questionExampleService.selectQuestionExample());
		return "question/questionExample";
	}
	
	@GetMapping("/questionUpdate")
	public String questionUpdate(Model model, Question question) {
		List<Question> questionList = questionService.selectQuestion(question);
		model.addAttribute("val", questionList.get(0));
		return "question/questionUpdate";
	}
	
	@PostMapping("/questionUpdate")
	public String questionUpdate(Question question) {
		questionService.updateQuestion(question);
		return "redirect:/question/question";
	}
	
	@GetMapping("/questionExampleUpdate")
	public String questionExampleUpdate(Model model, QuestionExample questionExample) {
		List<QuestionExample> questionExampleList = questionExampleService.selectQuestionExample(questionExample);
		model.addAttribute("val", questionExampleList.get(0));
		return "question/questionExampleUpdate";
	}
	
	@PostMapping("/questionExampleUpdate")
	public String questionExampleUpdate(QuestionExample questionExample) {
		questionExampleService.updateQuestionExample(questionExample);
		return "redirect:/question/questionExample";
	}
	
}
