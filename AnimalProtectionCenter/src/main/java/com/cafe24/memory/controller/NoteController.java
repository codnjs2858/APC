package com.cafe24.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired private NoteService noteService;
	
	@GetMapping("/noteList")
	public String noteList(Model model) {
		model.addAttribute("noteList", noteService.selectNote("id001"));
		return "note/noteList";
	}
	
	@GetMapping("/sendNoteList")
	public String sendNoteList(Model model) {
		model.addAttribute("sendNoteList", noteService.selectSendNote("id001"));
		return "note/sendNoteList";
	}
}
