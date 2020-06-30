package com.cafe24.memory.controller;

import java.util.List;
import java.util.Map;

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

import com.cafe24.memory.domain.CenterReturn;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.CenterReturnService;

@Controller
@RequestMapping("/centerreturn")
public class CenterReturnController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	CenterReturnService centerReturnService;
	
	@GetMapping("/centerReturnDelete")
	public String centerReturnDelete(@RequestParam(name="centerReturnCode" ,required = false)
									String centerReturnCode) {
		centerReturnService.deleteCenterReturn(centerReturnCode);
		
		return "redirect:/centerreturn/centerReturnList";
		
	}
	
	@PostMapping("centerReturnInsert")
	public String centerReturnInsert(CenterReturn centerReturn ,Staff staff) {
		
		centerReturn.setStaff(staff);
		centerReturnService.insertCenterReturn(centerReturn);
		
		return "redirect:/centerreturn/centerReturnList";
		
	}
	
	@GetMapping("centerReturnInsert")
	public String centerReturnInsert(Model model) {
	
		return "centerreturn/centerReturnInsert";
	}
	
	@GetMapping("centerReturnList")
	public String centerReturnList(Model model, @RequestParam(name="sendType", required = false)
												String sendType) {
		List<Map<String, Object>> petType = centerReturnService.selectPetTypeCount();
		System.out.println(petType);
		
		model.addAttribute("petType", petType);
		model.addAttribute("CRL", centerReturnService.selectCenterReturn());
	
		return "centerreturn/centerReturnList";
	}

	@GetMapping("centerReturnUpdate")
	public String centerReturnUpdate(@RequestParam(name="centerReturnCode" ,required = false)
									String centerReturnCode, Model model) {
		CenterReturn centerReturn = centerReturnService.selectCenterReturnCode(centerReturnCode);
		model.addAttribute("CR" , centerReturn);
		
		logger.info("{}", model);
		
		return "centerreturn/centerReturnUpdate";
	}
	
	@PostMapping("centerReturnUpdate")
	public String centerReturnUpdate(CenterReturn centerReturn) {
		
		centerReturnService.updateCenterReturn(centerReturn);
	
		return "redirect:/centerreturn/centerReturnList";
	}	
}
