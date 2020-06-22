package com.cafe24.memory.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalProtect;
import com.cafe24.memory.domain.ProtectionSpace;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.ProtectionService;

@Controller
public class AnimalProtectionController {
	
	@Autowired
	ProtectionService protectionService;
	
	@Autowired
	AnimalCenterService animalCenterService;

	@GetMapping("/exitAnimalProtection")
	public String exitAnimalProtection(
			 @RequestParam(name = "protectSpaceCode", required = false) String protectSpaceCode
			,@RequestParam(name = "aniProtectionNum", required = false) String aniProtectionNum) {
		System.out.println(protectSpaceCode + " <-- protectSpaceCode exitAnimalProtection() AnimalProtectionController.java");
		System.out.println(aniProtectionNum + " <-- aniProtectionNum exitAnimalProtection() AnimalProtectionController.java");
		protectionService.exitProtectionSpace(protectSpaceCode, aniProtectionNum);
		
		return "redirect:/animalProtection";
	}
	
	@PostMapping("/insertCodeCheck")
	@ResponseBody
	public String modifyAnimalProtection(@RequestParam(name = "btnNamePet") String petName) {
		System.out.println(petName);
		String result = "N";
		
		AnimalProtect ap = protectionService.selectAnimalProtect(petName);
		if(ap != null) {
			result = "Y";
		}
		
		return result;
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
		
		return "redirect:/animalProtection";
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
		
		return "redirect:/animalProtection";
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
