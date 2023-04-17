package com.koreaIT.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
	
	// 서비스 메서드
	
	public void joinMember(String loginId, String loginPw, String name, String nickname);

	
}
