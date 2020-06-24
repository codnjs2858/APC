package com.cafe24.memory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.ReportManger;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalHealthService;

@Controller
@RequestMapping("/animalcenter")
public class AnimalCenterController {
	@Autowired AnimalHealthService animalHealthService;
	@Autowired private AnimalCenterService animalCenterService;
	
	//animal center inset
	@GetMapping("/animalcenterinsert")
	public String insertAnimalCenterForm() {
		return "animalcenter/animalCenterInsert";
	}
	
	@PostMapping("/animalcenterinsert")
	public String insertAnimalCenter(Model model, AnimalType atype, Staff staff, AnimalCenter animal,SearchReportAnimal searchRe) {
		String reCode = searchRe.getSearchReportCode();
		ReportManger rm = new ReportManger();
		if( reCode != null || !"".equals(reCode)) {
			rm.setAcceptCode(animalCenterService.searchReportManager(reCode));
		}
		animal.setReportManger(rm);
		
		animal.setStaff(staff);
		animal.setAnimalType(atype);
		animalCenterService.insertAnimalCenter(animal);
		return "redirect:/animalcenter/animalcenterlist";
	}
	
	//animal center list 
	@GetMapping("/animalcenterlist")
	public String listAnimalCenter(@RequestParam(name="send_type", required = false) String send_type ,Model model) {
		model.addAttribute("Cnt", animalCenterService.selectCenterCnt());
		Map<Integer, Object> spaceMap = new HashMap<Integer, Object>();
		List<String> space = null;
		List<AnimalCenter> AClist = null;
		if(send_type != null && !"".equals(send_type)) {
			AClist = animalCenterService.selectAnimalCenter(send_type);
			space = animalCenterService.selectProtectAnimalCenter(send_type);
		}else {
			AClist = animalCenterService.selectAnimalCenter();
			space = animalCenterService.selectProtectAnimalCenter();
		}
		for(int i = 0; i < space.size(); i++) {
			spaceMap.put(i, space.get(i));
		}
		model.addAttribute("AClist", AClist);
		model.addAttribute("proNum", spaceMap);
		
		return "animalcenter/animalCenterList";
	}
	
	//animal center update
	@GetMapping("/animalcenterupdate")
	public String updateAnimalCenterForm(
			@RequestParam(name="send_code", required = false) String send_code, Model model) {
		model.addAttribute("searchReportCode",animalCenterService.getsearchReportCode(send_code));
		model.addAttribute("ac", animalCenterService.selectCenterAnimal(send_code));
		return "animalcenter/animalCenterUpdate";
	}
	@PostMapping("/animalcenterupdate")
	public String updateAnimalCenter(AnimalType atype, AnimalCenter animal,SearchReportAnimal searchRe) {
		ReportManger rm = new ReportManger();
		if(searchRe != null) {
			rm.setAcceptCode(animalCenterService.searchReportManager(searchRe.getSearchReportCode()));
		}
		animal.setReportManger(rm);
		animal.setAnimalType(atype);
		animalCenterService.updateAnimalCenter(animal);
		System.out.println("업데이트 실행 "+animal);
		return "redirect:/animalcenter/animalcenterlist";
	}
	
	//animal center delete
	@GetMapping("/animalcenterdelete")
	public String deleteAnimalCenter(@RequestParam(name="send_code", required = false) String send_code) {
		try {
			animalCenterService.deleteAnimalCenter(send_code);
		} catch (Exception e) {
			System.out.println("센터 동물 삭제 실패");
		}
		return "redirect:/animalcenter/animalcenterlist";
	}
	
	//animal page
	@GetMapping("/animalcenterpage")
	public String pageAnimalCenter(
			@RequestParam(name="send_code", required = false) String send_code, Model model) {
		model.addAttribute("aInfo", animalCenterService.selectCenterAnimal(send_code));
		model.addAttribute("sInfo",animalCenterService.selectReportCodeAnimal(send_code));
		model.addAttribute("hlist", animalHealthService.selectAnimalHealthInfo(send_code));
			
		return "animalcenter/animalCenterPage";
	}
	
}
