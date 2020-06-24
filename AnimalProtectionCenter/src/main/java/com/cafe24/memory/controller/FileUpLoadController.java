package com.cafe24.memory.controller;

import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalTypeService;
import com.cafe24.memory.service.StorageService;

@Controller
public class FileUpLoadController {
	
	@Autowired 
	private AnimalTypeService animalTypeService;
	
	@Autowired 
	private AnimalCenterService animalCenterService;
	
	@Autowired
	private StorageService storageService;
	
	//이게 다운로드
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		//파일 다운로드
		System.out.println("파일다운로드");
		Resource file = storageService.loadAsResource(filename);
		ResponseEntity<Resource>  re = ResponseEntity.ok().header(
				HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\""
		).body(file);
		return re;
	}

	//이게 업로드 form 에서 MultipartFile로 보내고 파라미터로 받고하면 됨 storageService.store(); 만 해주면 올라감 
	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		System.out.println("파일업로드");
		storageService.store(file);
		//redirect 보내면서 Attribute 전달
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		redirectAttributes.addFlashAttribute("imageFile", "/files/" + file.getOriginalFilename());
		
		return "redirect:/";
	}
	
	//animal center inset
	@GetMapping("/animalcenterinsertSCK")
	public String insertAnimalCenterForm() {
		return "fileUpLoad/animalCenterInsertSCK";
	}
	
	@PostMapping("/animalcenterinsertSCK")
	public String insertAnimalCenter(Model model, AnimalType atype, Staff staff, AnimalCenter animal,SearchReportAnimal searchRe,
			@RequestParam("animalPictureSCK") MultipartFile file, RedirectAttributes redirectAttributes) {
		String reCode = searchRe.getSearchReportCode();
		if( reCode == null || "".equals(reCode)) {
			animal.setAcceptCode(null);
		}else {
			animal.setAcceptCode(animalCenterService.searchReportManager(reCode));
		}
		storageService.store(file);
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		redirectAttributes.addFlashAttribute("imageFile", "/files/" + file.getOriginalFilename());
		
		animal.setAnimalPicture(file.getOriginalFilename());
		animal.setStaff(staff);
		animal.setAnimalType(atype);
		animalCenterService.insertAnimalCenter(animal);
		return "redirect:/animalcenterlistSCK";
	}
	
	@GetMapping("/animalcenterlistSCK")
	public String listAnimalCenter(@RequestParam(name="send_type", required = false) String send_type ,Model model) {
		model.addAttribute("Cnt", animalCenterService.selectCenterCnt());
		if(send_type != null && !"".equals(send_type)) {
			model.addAttribute("AClist", animalCenterService.selectAnimalCenter(send_type));
			model.addAttribute("proNum", animalCenterService.selectProtectAnimalCenter(send_type));
		}else {
			model.addAttribute("AClist", animalCenterService.selectAnimalCenter());
			model.addAttribute("proNum", animalCenterService.selectProtectAnimalCenter());
		}
		return "fileUpLoad/animalcenterlistSCK";
	}
	
	//animal center update
	@GetMapping("/animalcenterupdateSCK")
	public String updateAnimalCenterForm(
			@RequestParam(name="send_code", required = false) String send_code, Model model) {
		AnimalCenter ac = animalCenterService.selectCenterAnimal(send_code);
		model.addAttribute("searchReportCode",animalCenterService.getsearchReportCode(send_code));
		model.addAttribute("ac", ac);
		model.addAttribute("aniPicture", "/files/" + ac.getAnimalPicture());
		return "fileUpLoad/animalCenterUpdateSCK";
	}
	@PostMapping("/animalcenterupdateSCK")
	public String updateAnimalCenter(AnimalType atype, AnimalCenter animal,SearchReportAnimal searchRe) {
		if(searchRe == null) {
			animal.setAcceptCode(null);
		}else {
			animal.setAcceptCode(animalCenterService.searchReportManager(searchRe.getSearchReportCode()));
		}
		animal.setAnimalType(atype);
		animalCenterService.updateAnimalCenter(animal);
		System.out.println("업데이트 실행 "+animal);
		return "redirect:/animalcenterlistSCK";
	}
}
