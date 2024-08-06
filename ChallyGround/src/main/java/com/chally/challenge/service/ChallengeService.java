/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.08.04
 *목적: 챌린지 관련 서비스(챌린지 페이지)
***/
package com.chally.challenge.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.chally.dao.ChallengeMapper;
import com.chally.dao.UserInfoMapper;
import com.chally.user.CustomUserDetails;
import com.chally.vo.Challenge;
import com.chally.vo.UserInfo;

@Service
public class ChallengeService {
	
	@Autowired
	ChallengeMapper challengeDao;
	
	/***
	 *메소드 용도: 챌린지 등록
	 *매개변수: Authentication
	 *반환값: Map<String, Object>
	***/
	public Map<String, Object> saveChallenge(Map<String, String> request) {
        HashMap<String, Object> map = new HashMap<>();
        
		//회원정보 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		
		//파라미터 받기
        String title = request.get("title");
        String content = request.get("content");
        int minJoin = Integer.parseInt(request.get("minJoin"));
        int maxJoin = Integer.parseInt(request.get("maxJoin"));
        String startDt = request.get("startDt");
        String endDt = request.get("endDt"); 
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDtFormat = null;
        Date endDtFormat = null;
		try {
			startDtFormat = formatter.parse(startDt);
			endDtFormat = formatter.parse(endDt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		
		
        //VO객체 생성
		//chall
		Challenge record = new Challenge();
		record.setTitle(title);
		record.setContent(content);
		record.setMinJoin(minJoin);
		record.setMaxJoin(maxJoin);
		record.setStartDt(startDtFormat);
		record.setEndDt(endDtFormat);
		record.setUserId(userDetails.getId());
        
        //DAO 실행
        int updateCheck = challengeDao.insertSelective(record);
        
        if(updateCheck == 1) {

        	map.put("result", "회원정보가 수정되었습니다.");
        	
        } else {
        	map.put("result", "회원정보 수정에 실패하였습니다.");
        }
        
        return map;
	}
}
