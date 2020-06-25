package com.cafe24.memory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.ReportManger;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.domain.Staff;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalHealthService;
import com.cafe24.memory.service.StorageService;

@Controller
@RequestMapping("/animalcenter")
public class AnimalCenterController {
	
	@Autowired private AnimalHealthService animalHealthService;
	@Autowired private AnimalCenterService animalCenterService;
	@Autowired private StorageService storageService;
	
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	//이게 다운로드
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		//파일 다운로드
		logger.info("로거 출력해보자 - {}", "파일 다운로드");
		logger.error("에러를 출력해보자 - {}", "파일 다운로드");
		Resource file = storageService.loadAsResource(filename);
		ResponseEntity<Resource>  re = ResponseEntity.ok().header(
				HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\""
		).body(file);
		return re;
	}

	//이게 업로드 form 에서 MultipartFile로 보내고 파라미터로 받고하면 됨 storageService.store(); 만 해주면 올라감 
	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		storageService.store(file);
		//redirect 보내면서 Attribute 전달
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		redirectAttributes.addFlashAttribute("imageFile", "/files/" + file.getOriginalFilename());
		
		return "redirect:/";
	}
		
		
	//animal center inset
	@GetMapping("/animalcenterinsert")
	public String insertAnimalCenterForm() {
		return "animalcenter/animalCenterInsert";
	}
	
	@PostMapping("/animalcenterinsert")
	public String insertAnimalCenter(Model model, AnimalType atype, Staff staff, AnimalCenter animal,SearchReportAnimal searchRe
			, @RequestParam("animalPictureSCK") MultipartFile file) {
		
		String reCode = searchRe.getSearchReportCode();
		ReportManger rm = new ReportManger();
		if( reCode != null || !"".equals(reCode)) {
			rm.setAcceptCode(animalCenterService.searchReportManager(reCode));
		}
		storageService.store(file);
		
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
		AnimalCenter ac = animalCenterService.selectCenterAnimal(send_code);
		model.addAttribute("searchReportCode",animalCenterService.getsearchReportCode(send_code));
		model.addAttribute("ac", ac);
		model.addAttribute("aniPicture", "/files/" + ac.getAnimalPicture());
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
