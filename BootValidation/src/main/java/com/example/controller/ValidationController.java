package com.example.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.LoginData;

@Controller
public class ValidationController {

	@GetMapping("/form")
	public String showPage(Model m) {
		System.out.println("opening form");
		m.addAttribute("loginData", new LoginData());
		return "form";
	}

	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result)
	{
		if(result.hasErrors()) {
			System.out.println(result);	
			return "form";
		}
		System.out.println(loginData);
		return "success";
	}

}
