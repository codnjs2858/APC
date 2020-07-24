package com.cafe24.memory.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.LostReportAnimal;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.ReportManger;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.service.AnimalReportService;
import com.cafe24.memory.service.StorageService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/reportlist")
public class AnimalReportController {
	private final static Logger logger = (Logger) LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired private AnimalReportService animalReportService;
	@Autowired private StorageService storageService;
	
	
	/**
	 * 유기동물신고 insert
	 * @param aType
	 * @param member
	 * @param searchReportAnimal
	 * @return
	 */
	@PostMapping("/searchReport")
	public String searcReport(AnimalType aType,Member member,SearchReportAnimal searchReportAnimal,ReportManger reportManager,HttpSession session, @RequestParam("animalPicture2") MultipartFile file) {
		searchReportAnimal.setAnimalType(aType);
		searchReportAnimal.setMember(member);
		searchReportAnimal.setAnimalPicture(file.getOriginalFilename());
		
		storageService.store(file);
		logger.info("찾기 리포트 {}"+searchReportAnimal);
		animalReportService.insertAnimalReport(searchReportAnimal);
		
		reportManager.setSearchReport(searchReportAnimal);
		System.out.println("-----------------------------------------"+reportManager+"<-reportManager.setSearchReport(searchReportAnimal);");
		reportManager.setMember(member);
		animalReportService.insertAniSearchReportManager(reportManager);
		
		
		return "redirect:/reportlist/searchReportList";
	
	}
	/**
	 * 유기동물 신고폼
	 * @return
	 */
	@GetMapping("/searchReport")
	public String searhReport() {
		
		
		return "searchreport/searchReport";
	}
	/**
	 * 분실신고폼
	 * @return
	 */
	@GetMapping("/lostreport")
	public String lostReport() {
		
		
		return "lostreport/lostReportForm";
	}
	/**
	 * 동물 분실 신고insert
	 * @param lostReportAnimal
	 * @return
	 */
	@PostMapping("/lostReport")
	public String lostReport(LostReportAnimal lostReportAnimal,Member member,AnimalType animalType,ReportManger reportManager, @RequestParam("lostAnimalPicture2") MultipartFile file) {
		lostReportAnimal.setAnimalType(animalType);
		lostReportAnimal.setMember(member);
		lostReportAnimal.setLostAnimalPicture(file.getOriginalFilename());
		System.out.println(lostReportAnimal.getLostAnimalPicture()+"<-lostReportAnimal.getLostAnimalPicture()");
		storageService.store(file);

		System.out.println(lostReportAnimal);
		animalReportService.insertLostAnimalReport(lostReportAnimal);
		reportManager.setLostReport(lostReportAnimal);
		reportManager.setMember(member);
		animalReportService.insertAniLostReportManager(reportManager);
		return "redirect:/reportlist/lostReportList";
	}
	/**
	 * 종합신고관리에 분실신고와, 찾음신고 에서 신고 처리상태와 신고날짜등만 모아서 list로 바로 보여줌
	 * @return
	 */
	@GetMapping("/reportManager")
	public String reportManager(Model model) {
		List<ReportManger> reportManagerList=animalReportService.selectAllReport();
		System.out.println(reportManagerList);
		model.addAttribute("reportList", reportManagerList);
		return "reportlist/reportManager";
	}
	
	
	/**
	 * lostReportList분실신고 리스트
	 */
	@GetMapping("/lostReportList")
	public String getLostReportList(Model model) {
		List<LostReportAnimal> lostReportList=animalReportService.selectLostReportAnimal();
		System.out.println(lostReportList+"<-lostReportList");
		model.addAttribute("lostReportList", lostReportList);
		return "lostreport/lostReportList";
	}
	
	/**
	 * searchReportList 유기신고리스트
	 */
	@GetMapping("/searchReportList")
	public String getSearchReportList(Model model) {
		List<SearchReportAnimal>searchReportList=animalReportService.selectSearchReportAnimal();
		model.addAttribute("searchReportList", searchReportList);
		return "searchreport/searchReportList";
	}
	/**
	 * reportManager테이블에서 각  row의 데이터 상세보기 화면출력
	 * @param lostReportAnimal
	 * @param searchReportAnimal
	 * @param model
	 * @return
	 */
	@GetMapping("/reportManagerDetail")
	public String reportManagerDetail(LostReportAnimal lostReportAnimal,SearchReportAnimal searchReportAnimal,Model model) {
		System.out.println("lostReportAnimal->"+lostReportAnimal);
		System.out.println("searchReportAnimal->"+searchReportAnimal);
		LostReportAnimal lostAniDetail=null;
		SearchReportAnimal SearchAnimalDetail=null;
		if(lostReportAnimal.getLostReportCode()!=null && !"".equals(lostReportAnimal.getLostReportCode())) {
			System.out.println(1);
			lostAniDetail= animalReportService.selectLostReportAnimal(lostReportAnimal).get(0);
			System.out.println("lostAniDetail->"+lostAniDetail);
		model.addAttribute("lostAniDetail",lostAniDetail);
		return "reportlist/lostAnimalDetail";
		}
		else if(searchReportAnimal.getSearchReportCode()!=null && !"".equals(searchReportAnimal.getSearchReportCode())){
			System.out.println(2);
			SearchAnimalDetail=animalReportService.selectSearchReportAnimal(searchReportAnimal).get(0);
			model.addAttribute("SearchAnimalDetail", SearchAnimalDetail);
			System.out.println("SearchAnimalDetail->"+SearchAnimalDetail);
		return "reportlist/SearchAnimalDetail";
		}
		return "redirect:/reportlist/reportManager";
	}
	@GetMapping("/deletelist")
	public String deletelist(ReportManger reportManager,LostReportAnimal lostReportAnimal,SearchReportAnimal searchReportAnimal) {
		System.out.println("/deletelist->>lostReportAnimal->"+lostReportAnimal);
		System.out.println("/deletelist->>searchReportAnimal->"+searchReportAnimal);
		System.out.println("/deletelist->>reportManager->"+reportManager);
		String re=null;
		int result=0;
		if(lostReportAnimal.getLostReportCode()!=null && !"".equals(lostReportAnimal.getLostReportCode())) {
			reportManager.setLostReport(lostReportAnimal);
			System.out.println("/deletelist->>reportManager->"+reportManager);
			result=animalReportService.deleteReportManager(reportManager);
			System.out.println("ReportManager삭제 결과->"+result);
			result=animalReportService.deleteLostReportAnimal(lostReportAnimal);
			System.out.println("LostReportAnimal삭제 결과->"+result);
			re= "redirect:/reportlist/lostReportList";
		}
		else if(searchReportAnimal.getSearchReportCode()!=null && !"".equals(searchReportAnimal.getSearchReportCode())){
			reportManager.setSearchReport(searchReportAnimal);
			System.out.println("/deletelist->>reportManager->"+reportManager);
			
			result=animalReportService.deleteReportManager(reportManager);
			System.out.println("ReportManager삭제 결과->"+result);
			
			result=animalReportService.deleteSearchReportAnimal(searchReportAnimal);
			System.out.println("searchReport삭제 결과->"+result);
			re= "redirect:/reportlist/searchReportList";
		}
		return re;
	
	}
	@GetMapping("/searchReportView")
	public String searchReportView(SearchReportAnimal searchReportAnimal,Model model) {
		List<SearchReportAnimal> SearchAniList=animalReportService.selectSearchReportAnimal(searchReportAnimal);
		SearchReportAnimal SearchAni=SearchAniList.get(0);
		System.out.println(SearchAni+"SearchAni");
		model.addAttribute("SearchAnimalDetail", SearchAni);
		return "reportlist/SearchAnimalDetail";
	}
	
	
	@GetMapping("/lostReportView")
	public String lostReportView(LostReportAnimal lostReportAnimal,AnimalType animalType,Model model) {

		List<LostReportAnimal> LostReList=animalReportService.selectLostReportAnimal(lostReportAnimal);
		System.out.println("LostReList->"+LostReList);
		LostReportAnimal LostReport=LostReList.get(0);
		System.out.println("LostReport->"+LostReport);
		model.addAttribute("lostAniDetail", LostReport);
		return "reportlist/LostAnimalDetail";
	}
	
	@GetMapping("/lostReportCancel")
	public String lostReportCancel(LostReportAnimal lostReportAnimal,Model model) {
		
		animalReportService.lostReportCancel(lostReportAnimal);
		return "redirect:/reportlist/lostReportList";
	}
	/**
	 * 신고 취소 버튼 클릭시, db에 오늘 날짜로 신고 취소 날짜 입력
	 * @param searchReportAnimal
	 * @return
	 */
	@GetMapping("/searchReportCancel")
	public String searchReportCancel(SearchReportAnimal searchReportAnimal) {
		int result=animalReportService.searchReportCancel(searchReportAnimal);
		System.out.println(result+"<-searchReport 신고 취소 버튼클릭 결과");
		return "redirect:/reportlist/searchReportList";
	}
	/**
	 * searchReport 신고 업데이트 폼에 보여줄 ,회원정보 조회
	 * @param searchReportAnimal
	 * @param model
	 * @return
	 */
	@GetMapping("/updateforgetSearchlist")
	public String updateforgetSearchlist(SearchReportAnimal searchReportAnimal,Model model) {
		List<SearchReportAnimal> SearchAniList=animalReportService.selectSearchReportAnimal(searchReportAnimal);
		SearchReportAnimal SearchAni=SearchAniList.get(0);
		System.out.println(SearchAni+"SearchAni");
		model.addAttribute("SearchAnimalDetail", SearchAni);
		return "searchreport/searchReportUpdate";
	}
	
	/**
	 * searchReport 신고 update
	 * @param searchReportAnimal
	 * @param member
	 * @param animalType
	 * @param reportManager
	 * @param file
	 * @return
	 */
	@PostMapping("/updateLostlist")
	public String updateLostlist(LostReportAnimal lostReportAnimal,Member member,AnimalType animalType,ReportManger reportManager, @RequestParam("animalPicture2") MultipartFile file) {
		lostReportAnimal.setMember(member);
		lostReportAnimal.setAnimalType(animalType);
		System.out.println("lostReportAnimal->"+lostReportAnimal);
		int result=0;
		if(file != null && !"".equals(file.getOriginalFilename())) {
			storageService.deleteFile(lostReportAnimal.getLostAnimalPicture());
			storageService.store(file);	
			lostReportAnimal.setLostAnimalPicture(file.getOriginalFilename());
		}
		result=animalReportService.updateLostReportAnimal(lostReportAnimal);
		System.out.println(result+"<-LostReportAnimalt 수정 결과");
		reportManager.setLostReport(lostReportAnimal);
		reportManager.setMember(member);
		result=animalReportService.updateReportManager(reportManager);
		System.out.println(result+"<-ReportManager 수정 결과");
		
		
		return "redirect:/reportlist/lostReportList";
	}
	@PostMapping("/updateSearchlist")
	public String updateSearchlist(SearchReportAnimal searchReportAnimal,Member member,AnimalType animalType,ReportManger reportManager, @RequestParam("animalPicture2") MultipartFile file) {
		
		searchReportAnimal.setAnimalType(animalType);
		searchReportAnimal.setMember(member);
		System.out.println("updateSearchlist->"+searchReportAnimal);
		
		if(file != null && !"".equals(file.getOriginalFilename())) {
			storageService.deleteFile(searchReportAnimal.getAnimalPicture());
			storageService.store(file);
			searchReportAnimal.setAnimalPicture(file.getOriginalFilename());
		}
		logger.info("updateSearchlist{}"+searchReportAnimal);
		
		int result=animalReportService.updateSearchReport(searchReportAnimal);
		System.out.println(result+"<-updateSearchReport 결과");
		reportManager.setSearchReport(searchReportAnimal);
		System.out.println("-----------------------------------------"+reportManager+"<-reportManager.setSearchReport(searchReportAnimal);");
		reportManager.setMember(member);
		
		animalReportService.updateReportManager(reportManager);
		return "redirect:/reportlist/searchReportList";
	}
	@GetMapping("/updateforgetlostReport")
	public String updateforgetlostReport(LostReportAnimal lostReportAnimal,Model model) {
		List<LostReportAnimal> LostReList=animalReportService.selectLostReportAnimal(lostReportAnimal);
		LostReportAnimal LostReport=LostReList.get(0);
		model.addAttribute("lostReport", LostReport);
		return "lostreport/lostReportUpdate";
	}	
	
	
}
