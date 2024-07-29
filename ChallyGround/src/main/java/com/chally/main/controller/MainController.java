/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.21
 *목적: 메인 컨트롤러
***/
package com.chally.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chally.user.CustomUserDetails;
import com.chally.vo.UserInfo;

@RestController
public class MainController {
	@PostMapping("/api/submit")
	public ResponseEntity<Map<String, String>> submitData(@RequestBody Map<String, String> request) {

		//회원정보 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

		String name = request.get("name");
		String email = request.get("email");

		// 비즈니스 로직 처리 (예: 데이터베이스에 저장 등)

		Map<String, String> response = new HashMap<>();
		response.put("status", "success");
		response.put("name", name);
		response.put("email", email);

		return ResponseEntity.ok(response);
	}
}