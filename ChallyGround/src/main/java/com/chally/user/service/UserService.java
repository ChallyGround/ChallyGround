/***
 *최초 작성자: 심건보
 *최초 작성일: 2024.07.27
 *목적: 유저 서비스(내정보 페이지)
***/
package com.chally.user.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chally.dao.UserInfoMapper;
import com.chally.service.FileStorageService;
import com.chally.user.CustomUserDetails;
import com.chally.vo.UserInfo;

@Service
public class UserService {
	
	@Autowired
	UserInfoMapper userDao;
	
    @Autowired
    private FileStorageService fileStorageService;
	
	/***
	 *메소드 용도: 회원정보 수정 서비스
	 *매개변수: Authentication
	 *반환값: Map<String, Object>
	***/
	public Map<String, Object> modifyMyInfo(Map<String, Object> request) {
        HashMap<String, Object> map = new HashMap<>();
        
		//회원정보 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		
		//파라미터 받기
        String name = request.get("name").toString();
        String tel = request.get("tel").toString();
        String birth = request.get("birth").toString(); //yyyy-mm-dd
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthFormat = null;
		try {
			birthFormat = formatter.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		MultipartFile profileImage = (MultipartFile) request.get("profileImage"); //yyyy-mm-dd
		String fileName = null;
		try {
			fileName = fileStorageService.storeFile(profileImage);
		} catch (java.io.IOException e) {
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
        record.setProfileImage(fileName);
        
        //DAO 실행
        int updateCheck = userDao.updateByPrimaryKeySelective(record);
        
        if(updateCheck == 1) {
            // 업데이트된 사용자 정보로 새로운 UserDetails 생성
            CustomUserDetails updatedUserDetails = new CustomUserDetails(userDetails.getUsername(), null, new ArrayList<>(), record.getName(), record.getTel(), 
            															userDetails.getOauthId(), userDetails.getId(), record.getBirth(), record.getProfileImage());
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
		map.put("birth", userDetails.getBirth());
		
        // 이미지 파일 URL 제공
        String profileImage = userDetails.getProfileImage();
        if (profileImage != null && !profileImage.isEmpty()) {
            String fileUrl = "/chally/uploads/" + profileImage;
            map.put("profileImage",  userDetails.getProfileImage());
        }
		

		return map;
	}
}
