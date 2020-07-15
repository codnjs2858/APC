package com.cafe24.memory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.Commute;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.domain.Vacation;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalTypeService;
import com.cafe24.memory.service.StaffService;

@RestController
@RequestMapping("/ajax")
public class AjaxSCWController {
	@Autowired private AnimalTypeService animalTypeService;
	@Autowired private AnimalCenterService animalCenterService;
	@Autowired private StaffService staffService;
	
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
	
	@PostMapping("/vacationAdmission")
	public int vacationAdmission(@RequestParam(name = "code") String code, @RequestParam(name = "val") String val) {
		Vacation v = new Vacation();
		v.setVacationCode(code);
		if("보류".equals(val)) {
			val = null;
		}
		v.setVacationAdmissionState(val);
		staffService.vacationAdmission(v);
		return 0;
	}
	
}
