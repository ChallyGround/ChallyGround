/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.27
 *목적: 유저 서비스(내정보 페이지)
***/
package com.chally.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.chally.dao.UserInfoMapper;
import com.chally.user.CustomUserDetails;
import com.chally.vo.UserInfo;

@Service
public class UserService {
	
	@Autowired
	UserInfoMapper userDao;
	
	/***
	 *메소드 용도: 회원정보 수정 서비스
	 *매개변수: Authentication
	 *반환값: Map<String, Object>
	***/
	public Map<String, Object> modifyMyInfo(Map<String, String> request) {
		//회원정보 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		
		//파라미터 받기
        String name = request.get("name");
        String tel = request.get("tel");
        String birth = request.get("birth");
        
        //VO객체 생성
        UserInfo record = new UserInfo();
        record.setId(userDetails.getId());
        record.setName(name);
        record.setTel(tel);
        //생일은 데이터 형식 어케 받나 확인하고 변환하는 작업 필요
        //record.setBirth(birth);
        
        //DAO 실행
        int updateCheck = userDao.updateByPrimaryKeySelective(record);
        
        
        HashMap<String, Object> map = new HashMap<>();
        if(updateCheck == 1) {
            // 업데이트된 사용자 정보로 새로운 UserDetails 생성
            CustomUserDetails updatedUserDetails = new CustomUserDetails(userDetails.getUsername(), null, new ArrayList<>(), record.getName(), record.getTel(), userDetails.getOauthId(), userDetails.getId());
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
	
	/***
	 *메소드 용도: 회원정보 보기 서비스
	 *반환값: Map<String, Object>
	***/
	public Map<String, Object> viewMyInfo() {
        HashMap<String, Object> map = new HashMap<>();
		//회원정보 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		
		map.put("email", userDetails.getUsername());
		map.put("name", userDetails.getName());
		map.put("tel", userDetails.getTel());

		return map;
	}
}
