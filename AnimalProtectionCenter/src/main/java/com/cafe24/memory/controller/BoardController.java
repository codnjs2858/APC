package com.cafe24.memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
public class BoardController {

	@GetMapping("/notice")
	public String notice(Model model) {
		return "board/notice";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		return "board/write";
	}
}
