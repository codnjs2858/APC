package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalTypeService;

@RestController
@RequestMapping("/ajax")
public class AjaxSCWController {
	@Autowired private AnimalTypeService animalTypeService;
	@Autowired private AnimalCenterService animalCenterService;
	
	@PostMapping("/animalcentertype")
	public List<AnimalType> addProtectInsert(@RequestParam(name = "type") String type) {
		return animalTypeService.selectAnimalType(type);
	}
	
//신고 내역 조회
	@PostMapping("/animalcenterReport")
	public List<SearchReportAnimal> animalcenterReport(@RequestParam(name = "memberName") String memberName,
			@RequestParam(name = "memberPhone") String memberPhone) {
		return animalCenterService.selectCenterReport(memberName, memberPhone);
	}

}
