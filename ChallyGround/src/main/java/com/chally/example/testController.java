package com.chally.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class testController {
	@Autowired
	TestService service;

	@GetMapping("/")
	public String sampleHome() {
		//service.addMember();
		return "test2.html";
	}
}
충돌 테스트