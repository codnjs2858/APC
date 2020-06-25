package com.cafe24.memory.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.service.AnimalTypeService;


@Controller
@RequestMapping("adoption")
public class AnimalAdoptionController {
	@Autowired private AnimalTypeService animalTypeService;
	
	@GetMapping("/adoptionReview")
	public String adoptionReview(Model model) {
		return "adoption/adoptionReview";
	}
	@GetMapping("/adoptionApply")
	public String adoptionApply(Model model) {
		List<AnimalType>AniList=animalTypeService.selectAnimalType();
		System.out.println(AniList);
		
		
		model.addAttribute("AniList", AniList);
		return "adoption/adoptionApplyForm";
	}
	@PostMapping("/adoptionApply")
	public String adoptionApply() {
		
		return "index";
	}
	/**
	 * ajax로 입양신청폼에서 강아지/고양이 선택시 축종select박스 의 내용 db에서 가져오기
	 * @return
	 */
	@GetMapping("/ajaxAdoptionApplyForm")
	@ResponseBody
	public List<AnimalType> ajaxAdoptionApplyForm(@RequestParam("select")String select){
		List<AnimalType>AniList=animalTypeService.selectAnimalType(select);
		
		return AniList;
	}
	
}
