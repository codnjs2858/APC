package com.cafe24.memory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.memory.domain.Note;
import com.cafe24.memory.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired private NoteService noteService;
	
	@PostMapping("/sendNote")
	public String sendNote(Note note, Model model) {
		noteService.insertNote(note);
		return "redirect:/note/sendNoteList";
	}
	
	@GetMapping("/sendNote")
	public String write(Model model) {
		return "note/sendNote";
	}
	
	@GetMapping("/getNote")
	public String getNote(Note note, Model model) {
		model.addAttribute("getNote", noteService.getNote(note));
		return "note/getNote";
	}
	
	@GetMapping("/noteList")
	public String noteList(Model model,HttpSession session) {
		String id = (String) session.getAttribute("SID");
		model.addAttribute("noteList", noteService.selectNote(id));
		return "note/noteList";
	}
	
	@GetMapping("/sendNoteList")
	public String sendNoteList(Model model,HttpSession session) {
		String id = (String) session.getAttribute("SID");
		model.addAttribute("sendNoteList", noteService.selectSendNote(id));
		return "note/sendNoteList";
	}
}
