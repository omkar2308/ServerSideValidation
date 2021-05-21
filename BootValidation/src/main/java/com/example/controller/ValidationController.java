package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.LoginData;

@Controller
public class ValidationController {
	
	@GetMapping("/form")
	public String showPage(Model m) {
		System.out.println("opening form");
		m.addAttribute("LoginData", new LoginData());
		return "form"; 
	}
	
	@PostMapping("/process")
	public String processForm(@ModelAttribute("loginData") LoginData loginData) {
		
		System.out.println(loginData);
		return "success";
		
	}

}
