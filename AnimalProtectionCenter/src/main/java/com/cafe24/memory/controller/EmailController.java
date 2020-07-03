package com.cafe24.memory.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
	@RequestMapping(value="/memberEmail")
	
	public ModelAndView board2(){
		ModelAndView mv = new ModelAndView();
		int ran = new Random().nextInt(900000) + 100000;
		mv.setViewName("test/email");
		mv.addObject("random", ran);
		
		return mv;
	}
}
