package com.cafe24.memory.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.domain.Board;
import com.cafe24.memory.domain.CompanionAnimalRegister;
import com.cafe24.memory.domain.LostReportAnimal;
import com.cafe24.memory.domain.SearchReportAnimal;
import com.cafe24.memory.service.AnimalCenterService;
import com.cafe24.memory.service.AnimalReportService;
import com.cafe24.memory.service.CompanionAnimalRegisterService;
import com.cafe24.memory.service.NoteService;
import com.cafe24.memory.service.NoticeService;
import com.cafe24.memory.service.ReviewService;
import com.cafe24.memory.service.StaffService;

@Controller
public class AdminController {
	
	@Autowired 
	private StaffService staffService;
	
	@Autowired 
	private ReviewService reviewServiece;
	
	@Autowired 
	private NoteService noteService;
	
	@Autowired
	private AnimalCenterService animalCenterService;
	
	@Autowired
	private AnimalReportService animalReportService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private CompanionAnimalRegisterService companionAnimalRegisterService;
	
	@GetMapping("/")
	public String intro(HttpSession session) {
		String send_code = (String) session.getAttribute("STAFFCODE");
		if(send_code != null) {
			session.setAttribute("com", staffService.selectStaffList(send_code));
		}
		return "intro/introSCK";
	}
	
	@GetMapping("/introSCW")
	public String introSCW() {
		return "intro/introSCW";
	}
	
	@GetMapping("/introLKJ")
	public String introLKJ() {
		return "intro/introLKJ";
	}
	
	@GetMapping("/introSMY")
	public String introSMY() {
		return "intro/introSMY";
	}
	
	@GetMapping("/introJSY")
	public String introJSY() {
		return "intro/introJSY";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		//여기에서 고양이 보내주고 하면 될듯 
		List<SearchReportAnimal> searchReportAnimalList = animalReportService.selectSearchReportAnimal();
		System.out.println(searchReportAnimalList + " <-- searchReportAnimalList");
		List<LostReportAnimal> lostReportAniamlList = animalReportService.selectLostReportAnimal();
		System.out.println(lostReportAniamlList + " <-- lostReportAniamlList");
		List<Board> selectNoticeList = noticeService.selectNotice();
		System.out.println(selectNoticeList + " <-- selectNoticeList");
		
		
		model.addAttribute("cnt", animalCenterService.selectCenterCnt());
		model.addAttribute("searchReportAnimalList", searchReportAnimalList);
		model.addAttribute("lostReportAniamlList", lostReportAniamlList);
		model.addAttribute("selectNoticeList", selectNoticeList);
		
		return "index";
	}

	@RequestMapping("/admin")
	public String admin(HttpSession session, Model model) {
		String send_code = (String) session.getAttribute("STAFFCODE");
		String send_id = (String) session.getAttribute("SID");
		if(send_code != null) {
			session.setAttribute("com", staffService.selectStaffList(send_code));
		}
		List<CompanionAnimalRegister> carList = companionAnimalRegisterService.selectCompanionAnimalRegisterList();
		model.addAttribute("animalCnt", animalCenterService.selectAnimalCenter().size());
		model.addAttribute("noteCnt", noteService.selectNote(send_id).size());
		model.addAttribute("carList", carList);
		model.addAttribute("cnt", animalCenterService.selectCenterCnt());
		model.addAttribute("RVL", reviewServiece.selectReview());
		model.addAttribute("CARS", companionAnimalRegisterService.selectComAniRegList("분양 가능"));
		return "admin/admin";
	}
	@GetMapping("/member/blacklistMemberAlert")
	public String blacklistMemberAlert() {
		return "member/blacklistMemberAlert";
	}
}
