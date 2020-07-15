package com.cafe24.memory.controller;

import org.springframework.core.io.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.memory.service.StorageService;

@Controller
public class FileUpLoadController {
	
	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	private StorageService storageService;
	
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
}
