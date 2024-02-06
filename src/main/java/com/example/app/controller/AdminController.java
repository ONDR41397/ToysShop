package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Admins;
import com.example.app.service.AdminService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@GetMapping("admin")
	public String adminLoginGet(Model model) throws Exception {
		model.addAttribute("admins", new Admins());
		return "admin/login";
	}
	
	@PostMapping("admin")
	public String adminLoginPost(@Valid Admins admins, Errors errors, HttpSession session) throws Exception {
		
		if(errors.hasErrors()) {
			return "admin/login";
		}
		
		if(!service.isCorrectIdAndPassword(admins.getUserId(), admins.getPass())) {
			errors.rejectValue("userId", "error.incorrect_id_password");
			return "admin/login";
		}
		
		session.setAttribute("userId", admins.getUserId());
		return "redirect:/admin/itemList";
	}
	
	@GetMapping("admin/logout")
	public String adminLogout(HttpSession session) throws Exception {
		// セッションの破棄
		session.invalidate();
		return "redirect:/admin";
	}

}
