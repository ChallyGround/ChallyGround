package com.chally.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chally.example.service.TestService;

@Controller
public class testController {
	@Autowired
	TestService service;

	@GetMapping("/")
	public String sampleHome() {
		//service.addMember();
		return "index.html";
	}
	
	@RestController
	public class HelloController {
	    @GetMapping("/api/hello")
	    public String getGreeting() {
			return "어라라?";
	    }
	}
}