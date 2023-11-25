package com.stockmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	@GetMapping("/view")
	public String showViewPage() {
		return "view";
	}
	
	@GetMapping("/delete")
	public String showDeletePage() {
		return "delete";
	}
}
