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

import com.cafe24.memory.domain.AnimalType;
import com.cafe24.memory.domain.LostReportAnimal;
import com.cafe24.memory.domain.Member;
import com.cafe24.memory.domain.ReportManger;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.service.AnimalReportService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/reportlist")
public class AnimalReportController {
	private final static Logger logger = (Logger) LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired private AnimalReportService animalReportService;
	
	
	/**
	 * 유기동물신고 insert
	 * @param aType
	 * @param member
	 * @param searchReportAnimal
	 * @return
	 */
	@PostMapping("/searchReport")
	public String searcReport(AnimalType aType,Member member,SearchReportAnimal searchReportAnimal,ReportManger reportManager,HttpSession session) {
		searchReportAnimal.setAnimalType(aType);
		searchReportAnimal.setMember(member);
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
	public String lostReport(LostReportAnimal lostReportAnimal,Member member,AnimalType animalType,ReportManger reportManager) {
		lostReportAnimal.setAnimalType(animalType);
		lostReportAnimal.setMember(member);
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
	public String reportManagerUpdate(LostReportAnimal lostReportAnimal,SearchReportAnimal searchReportAnimal,Model model) {
	
		if(lostReportAnimal!=null) {
		model.addAttribute("lostAnimalDetail", animalReportService.selectLostReportAnimal(lostReportAnimal));
		return "reportlist/lostAnimalDetail";
		}
		else {
		model.addAttribute("SearchAnimalDetail", animalReportService.selectSearchReportAnimal(searchReportAnimal));	
		}
		return "reportlist/SearchAnimalDetail";
	}
	@GetMapping("/deletelist")
	public String deletelist(ReportManger reportManager,LostReportAnimal lostReportAnimal,SearchReportAnimal searchReportAnimal) {
		if(lostReportAnimal!=null) {
			reportManager.setLostReport(lostReportAnimal);
			animalReportService.deleteLostReportAnimal(lostReportAnimal);
			animalReportService.deleteReportManager(reportManager);
		}
		if(searchReportAnimal!=null) {
			reportManager.setSearchReport(searchReportAnimal);
			animalReportService.deleteSearchReportAnimal(searchReportAnimal);
			animalReportService.deleteReportManager(reportManager);
		}
	
		return "redirect:/reportlist/reportManager";
	}
	@GetMapping("/searchReportView")
	public String searchReportView(SearchReportAnimal searchReportAnimal,Model model) {
		List<SearchReportAnimal> SearchAniList=animalReportService.selectSearchReportAnimal(searchReportAnimal);
		SearchReportAnimal SearchAni=SearchAniList.get(0);
		model.addAttribute("SearchAnimalDetail", SearchAni);
		return "reportlist/SearchAnimalDetail";
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
}
