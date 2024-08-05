package com.chally.controller;


import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chally.service.FileStorageService;

@Controller
public class FileLoadController {
	
	@Autowired
	FileStorageService fileStorageService;
	
	@GetMapping("/uploads/{fileName:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
	    try {
	        Resource resource = fileStorageService.loadFileAsResource(fileName);
	        return ResponseEntity.ok()
	                .contentType(MediaType.IMAGE_PNG) // 또는 이미지의 MIME 타입에 맞게 설정
	                .body(resource);
	    } catch (MalformedURLException ex) {
	        return ResponseEntity.notFound().build();
	    }
	}

}
