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
        String name = request.get("name");
        String tel = request.get("tel");
        String birth = request.get("birthFormat"); //yyyy-mm-dd
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthFormat = null;
		try {
			birthFormat = formatter.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		if(name.equals("")) {
			map.put("result", "회원정보 수정에 실패하였습니다.");
			return map;
		}
		
        //VO객체 생성
        UserInfo record = new UserInfo();
        record.setId(userDetails.getId());
        record.setName(name);
        record.setTel(tel);
        record.setBirth(birthFormat);
        
        //DAO 실행
        int updateCheck = challengeDao.insertSelective(null);
        
        if(updateCheck == 1) {
            // 업데이트된 사용자 정보로 새로운 UserDetails 생성
            CustomUserDetails updatedUserDetails = new CustomUserDetails(userDetails.getUsername(), null, new ArrayList<>(), record.getName(), record.getTel(), userDetails.getOauthId(), userDetails.getId(), record.getBirth(), record.getProfileImage());
            // 새로운 Authentication 객체 생성
            Authentication newAuth = new UsernamePasswordAuthenticationToken(updatedUserDetails, null, updatedUserDetails.getAuthorities());
            // SecurityContext에 새로운 Authentication 객체 설정
            SecurityContextHolder.getContext().setAuthentication(newAuth);
            
        	map.put("result", "회원정보가 수정되었습니다.");
        	
        } else {
        	map.put("result", "회원정보 수정에 실패하였습니다.");
        }
        
        return map;
	}
}
