package com.cafe24.memory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.Implement;
import com.cafe24.memory.service.ImplementService;

@Controller
@RequestMapping("/implement")
public class ImplementController {
	
	private final static Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	private ImplementService impleMentServer;
	
	@PostMapping("/implementList")
	public String implement() {
		
		return "implement/implementList";
	}
	
	@GetMapping("/implementList")
	public String implement(Model model) {
		List<Implement> impleList = impleMentServer.selectImplement();
		Implement im = null;
		for(int i = 0; i < impleList.size(); i++) {
			im = impleList.get(i);
			impleMentServer.modifyImplement(im);
		}
		logger.info("시설 리스트 {}", impleList);
		model.addAttribute("impleList", impleList);
		
		return "implement/implementList";
	}
	
	@PostMapping("/implementUpdate")
	public String implementUpdate(Implement implement) {
		logger.info("시설 수정 화면에서 보낸 시설 {}", implement);
		int result = impleMentServer.modifyImplement(implement);
		logger.info("시설 수정 처리 결과값 {}", result);
		
		return "redirect:/implement/implementList";
	}
	
	@GetMapping("/implementUpdate")
	public String implementUpdate(Model model,
			@RequestParam(name = "sendCode", required = false) String sendCode) {
		logger.info("시설 리스트에서 보낸 코드 {}", sendCode);
		Implement implement = impleMentServer.selectImplementByCode(sendCode);
		logger.info("시설 리스트에서 보낸 코드로 찾은 시설 {}", implement);
		model.addAttribute("implement", implement);
		
		return "implement/implementUpdate";
	}
	
	@GetMapping("/implementInsert")
	public String implementInsert() {
		
		return "implement/implementInsert";
	}
	
	@GetMapping("/implementDelete")
	public String implementDelete(@RequestParam(name = "implementCode", required = false) String implementCode) {
		logger.info("implementCode {}", implementCode);
		
		return "redirect:/implement/implementList";
	}
	
}
