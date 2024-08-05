/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.08.04
 *목적: 챌린지 관련 컨트롤러(챌린지 페이지)
***/
package com.chally.challenge.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chally.challenge.service.ChallengeService;
import com.chally.dao.ChallengeMapper;
import com.chally.user.service.UserService;

@Controller
public class ChallengeController {

	@Autowired
	ChallengeService challengeService;

	/***
	 *메소드 용도: 내정보 수정 컨트롤러
	 *매개변수: Map<String, String>
	 *반환값: ResponseEntity(Map<String, Object>)
	***/
	@PostMapping("/api/saveChallenge")
	public ResponseEntity<Map<String, Object>> saveChallenge(@RequestBody Map<String, String> request) {
		Map<String, Object> response = new HashMap<>();

		response = challengeService.saveChallenge(request);

		return ResponseEntity.ok(response);
	}
}