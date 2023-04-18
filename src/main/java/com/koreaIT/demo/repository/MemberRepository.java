package com.koreaIT.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.koreaIT.demo.vo.Member;

@Mapper
public interface MemberRepository {
	
	// 서비스 메서드
	
	public void joinMember(String loginId, String loginPw, String name, String nickname,String cellphoneNum,String email);
	
	public int getLastInsertId();
	
	public Member getMemberById(int id);

	public Member getMemberByLoginId(String loginId);

	public Member getMemberByNickname(String nickname);

	public Member getMemberByNameAndEmail(String name, String email);
}
