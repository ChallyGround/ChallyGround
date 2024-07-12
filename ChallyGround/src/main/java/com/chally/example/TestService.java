package com.chally.example;

import org.springframework.stereotype.Service;

import com.chally.dao.TestChallyMapper;
import com.chally.vo.TestChally;

@Service
public class TestService {
	
	
	private final TestChallyMapper challyMapper;

	TestService(TestChallyMapper challyMapper) {
        this.challyMapper = challyMapper;
    }


	public void addMember() {
		TestChally testChally = new TestChally();
		testChally.setTestSeq("1");
		testChally.setTestTitle("gdgd");
		testChally.setTestPlain("내용입니다");

		challyMapper.insertSelective(testChally);
	}
}
