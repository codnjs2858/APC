package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.service.AnimalTypeService;

@Controller
@RequestMapping("/animaltype")
public class AnimalTypeController {
	@Autowired private AnimalTypeService animalTypeService;
	
	//animal type list
	@GetMapping("/animaltypelist")
	public String listAnimalType(@RequestParam(name="send_type", required = false) String send_type, Model model) {
		model.addAttribute("Cnt", animalTypeService.selectAnimalCnt());
		if(send_type != null && !"".equals(send_type)) {
			model.addAttribute("TypeList", animalTypeService.selectAnimalType(send_type));
		}else {
			model.addAttribute("TypeList", animalTypeService.selectAnimalType());
		}
		return "animaltype/animalTypeList";
	}
	
	//animal type insert
	@GetMapping("/animaltypeinsert")
	public String insertAnimalForm() {
		return "animaltype/animalTypeInsert";
	}
	@PostMapping("/animaltypeinsert")
	public String insertAnimalType(AnimalType atype) {
		animalTypeService.insertAnimalType(atype);
		return "redirect:/animaltype/animaltypelist"; 
	}
	
	//animal type update
	@GetMapping("/animaltypeupdate")
	public String updateAnimalForm(
			@RequestParam(name="send_code", required = false) String send_code, Model model) {
		model.addAttribute("type",animalTypeService.selectType(send_code));
		return "animaltype/animalTypeUpdate";
	}
	@PostMapping("/animaltypeupdate")
	public String updateAnimalType(AnimalType atype) {
		animalTypeService.updateAnimalType(atype);
		return "redirect:/animaltype/animaltypelist";
	}
	
	//animal type delete
	@GetMapping("/animaltypedelete")
	public String deleteAnimalType(@RequestParam(name="send_code", required = false) String send_code, RedirectAttributes rattr) {
		System.out.println(send_code);
		try {
			animalTypeService.deleteAnimalType(send_code);
		}catch (Exception e) {
			rattr.addAttribute("alert", "N");
			System.out.println("동물 종류 삭제 실패");
		}
		return "redirect:/animaltype/animaltypelist";
	}
	
}
