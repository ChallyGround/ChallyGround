/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.27
 *목적: 유저 컨트롤러(내정보 페이지)
***/
package com.chally.user.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chally.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	/***
	 *메소드 용도: 내정보 수정 컨트롤러
	 *매개변수: Map<String, String>
	 *반환값: ResponseEntity(Map<String, Object>)
	***/
	@PostMapping("/api/modifyMyInfo")
    public ResponseEntity<Map<String, Object>> modifyMyInfo(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        
        response = userService.modifyMyInfo(request);

        return ResponseEntity.ok(response);
    }
	
	/***
	 *메소드 용도: 내정보 보기 컨트롤러
	 *반환값: ResponseEntity(Map<String, Object>)
	***/
	@PostMapping("/api/modifyMyInfo")
    public ResponseEntity<Map<String, Object>> viewMyInfo() {
        Map<String, Object> response = new HashMap<>();
        
        response = userService.viewMyInfo();

        return ResponseEntity.ok(response);
    }
}
