package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.memory.domain.Mail;
import com.cafe24.memory.service.MailService;

@Controller
public class MailController {
	@Autowired MailService mailService;
	
	@GetMapping("/mailList")
	public String main() {
		return "/mail/mailList";
	}
	
	@PostMapping("/mailList")
	public String mail(Mail mail) {
		System.out.println(mail.toString());
		mailService.mailSend(mail);
		return "redirect:/mailList";
	}
}
