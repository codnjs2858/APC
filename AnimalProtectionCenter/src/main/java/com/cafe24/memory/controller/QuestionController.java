package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
public class QuestionController {

	@GetMapping("/question")
	public String question(Model model) {
		return "question/question";
	}
	
	@GetMapping("/questionExample")
	public String questionExample(Model model) {
		return "question/questionExample";
	}
}
