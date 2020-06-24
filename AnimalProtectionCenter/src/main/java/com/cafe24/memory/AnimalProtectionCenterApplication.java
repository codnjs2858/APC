package com.cafe24.memory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cafe24.memory.service.StorageService;

@SpringBootApplication
public class AnimalProtectionCenterApplication {

	private final static Logger logger = 
			LoggerFactory.getLogger(SpringBootApplication.class);
	
	public static void main(String[] args) {
		logger.info("로거 출력 - {}", "값");
		SpringApplication.run(AnimalProtectionCenterApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//서버 시작시 전체 업로드 경로의 파일 제거
			//storageService.deleteAll();
			//파일 업로드 없을 경우 폴더 생성
			storageService.init();
		};
	}
	
}
