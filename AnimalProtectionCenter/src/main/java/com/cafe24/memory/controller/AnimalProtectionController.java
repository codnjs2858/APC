package com.cafe24.memory.controller;

import java.util.Calendar;
import java.util.Date;
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

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.Implement;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.ImplementService;
import com.cafe24.memory.service.ProtectionService;

@Controller
@RequestMapping("/protection")
public class AnimalProtectionController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	ProtectionService protectionService;
	
	@Autowired
	AnimalCenterService animalCenterService;
	
	@Autowired
	ImplementService implementService;
	
	@GetMapping("/delProtectionSpace")
	public String delProtectionSpace(
			@RequestParam(name = "protectSpaceCode", required = false) String protectSpaceCode) {
		logger.info("삭제버튼 클릭시 보내는 장소 코드 값 {}", protectSpaceCode);
		protectionService.deleteProtectionSpace(protectSpaceCode);
		
		return "redirect:/protection/animalProtection";
	}
	
	@PostMapping("/addAnimalProtectionSpace")
	public String addAnimalProtectionSpace(ProtectionSpace space) {
		logger.info("보호공간화면에서 보낸 ProtectionSpace {}", space);
		protectionService.insertProtectionSpace(space);
		
		return "redirect:/protection/animalProtection";
	}

	@GetMapping("/addProtectionSpace")
	public String addprotectionSpace(Model model) {
		List<Implement> implementList = implementService.selectImplement();
		logger.info("보호공간 등록 화면에 보낼 시설 데이타베이스 {}", implementList);
		model.addAttribute("implementList", implementList);
		
		return "/animalprotect/animalProtectSpaceInsert";
	}
	
	@GetMapping("/exitAnimalProtection")
	public String exitAnimalProtection(
			 @RequestParam(name = "protectSpaceCode", required = false) String protectSpaceCode
			,@RequestParam(name = "aniProtectionNum", required = false) String aniProtectionNum) {
		System.out.println(protectSpaceCode + " <-- protectSpaceCode exitAnimalProtection() AnimalProtectionController.java");
		System.out.println(aniProtectionNum + " <-- aniProtectionNum exitAnimalProtection() AnimalProtectionController.java");
		protectionService.exitProtectionSpace(protectSpaceCode, aniProtectionNum);
		
		return "redirect:/protection/animalProtection";
	}
	
	@GetMapping("/animalProtection")
	public String animalProtection(Model model,
			@RequestParam(name = "sendSearch", required = false) String sendSearch) {
		System.out.println(sendSearch);
		
		int useCount = protectionService.selectProtectionSpaceUseState("사용중").size();
		int useNotCount = protectionService.selectProtectionSpaceUseState("없음").size();
		int allCount = useCount + useNotCount;
		int haveNotCount = protectionService.selectAnimalHaveNotSpace().size();
		
		List<ProtectionSpace> protectSpaceList = null; 
		if("useing".equals(sendSearch)) {
			protectSpaceList = protectionService.selectProtectionSpaceInAnimal();
		}else if("useNot".equals(sendSearch)) {
			protectSpaceList = protectionService.selectProtectionSpaceOutAnimal();
		}else {
			protectSpaceList = protectionService.selectProtectionSpace();
		}
			
		System.out.println(protectSpaceList);
		model.addAttribute("protectSpaceList", protectSpaceList);
		model.addAttribute("allCount", allCount);
		model.addAttribute("useNotCount", useNotCount);
		model.addAttribute("haveNotCount", haveNotCount);
		model.addAttribute("useCount", useCount);
		
		return "animalprotect/animalProctectSpace";
	}
	
	@GetMapping("/modifyAnimalProtection")
	public String modifyAnimalProtection(Model model, 
			@RequestParam(value = "space", required = false) String space) {
		ProtectionSpace ps = protectionService.modifyProtectionSpaceBySpace(space);
		long dDay = 0;
		
		if(ps != null) {
			if(ps.getAnimalProtect() != null) {
				dDay = getDday(ps.getAnimalProtect().getAnimalProtectExeDate());
			}else {
				ps.setAnimalProtect(new AnimalProtect());
			}
			model.addAttribute("dDay", dDay);
			model.addAttribute("ptSpace", ps);
		}
		
		List<AnimalCenter> animalCenterList = animalCenterService.selectAnimalCenter();
		model.addAttribute("acl", animalCenterList);
 		
		return "animalprotect/animalProtectUpdate";
	}
	
	@PostMapping("/addAnimalProtection")
	public String addAnimalProtection(AnimalProtect animalProtect, @RequestParam(name = "protectDate", required = false) String protectDate) {
		Date exeDate = null;
		if(protectDate != null) {
			int ptDate = Integer.parseInt(protectDate);
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, ptDate);
			
			//String exeDate = format.format(new Date(cal.getTimeInMillis()));
			exeDate = new Date(cal.getTimeInMillis());
		}
		
		animalProtect.setAnimalProtectExeDate(exeDate);
		
		System.out.println(animalProtect + " <-- addAnimalProtection() AnimalProtectionController.java");
		protectionService.insertAniamlProtection(animalProtect);
		
		return "redirect:/protection/animalProtection";
	}
	
	@PostMapping("/animalProtection")
	public String animalProtection(AnimalProtect animalProtect, @RequestParam(name = "protectDate", required = false) String protectDate) {
		Date exeDate = null;
		if(protectDate != null) {
			int ptDate = Integer.parseInt(protectDate);
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, ptDate+1);
			
			//String exeDate = format.format(new Date(cal.getTimeInMillis()));
			exeDate = new Date(cal.getTimeInMillis());
		}
		
		animalProtect.setAnimalProtectExeDate(exeDate);
		
		System.out.println(animalProtect + " <-- animalProtection() AnimalProtectionController.java");
		protectionService.updateAnimalProtectionIn(animalProtect);
		
		return "redirect:/protection/animalProtection";
	}
	
	@GetMapping("/addAnimalProtection")
	public String addAnimalProtection(Model model) {
		List<ProtectionSpace> protectionSpaceUseState = protectionService.selectProtectionSpaceUseState("없음");
		List<AnimalCenter> animalHaveNotSpace = protectionService.selectAnimalHaveNotSpace();
		
		System.out.println(protectionSpaceUseState + " <-- protectionSpaceUseState addAnimalProtection() AnimalProtectionController.java");
		System.out.println(animalHaveNotSpace + " <-- animalHaveNotSpace addAnimalProtection() AnimalProtectionController.java");
		
		model.addAttribute("psus", protectionSpaceUseState);
		model.addAttribute("ahns", animalHaveNotSpace);
		
		return "animalprotect/animalProtectInsert";
	}

	private long getDday(Date date) {
		Calendar today = Calendar.getInstance();
		Calendar exeDate = Calendar.getInstance();
		exeDate.setTime(date);
		
		long result = (exeDate.getTimeInMillis() - today.getTimeInMillis()) / (24 * 60 * 60 * 1000);
		
		return result;
	}
}
