package com.chally.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chally.example.service.TestService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // React 앱이 실행되는 포트
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
	
    @PostMapping("/data")
    public ResponseEntity<String> receiveData(@RequestBody Map<String, Object> requestData) {
        String data2 = requestData.get("data2").toString();
        if (data2 != null) {
            System.out.println("Received data2: " + data2);
            return ResponseEntity.ok("Data received successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid data");
        }
    }
}