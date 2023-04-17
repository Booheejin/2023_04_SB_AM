package com.koreaIT.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.demo.repository.MemberRepository;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;

	}
	
	public void joinMember(String loginId,String loginPw,String name,String nickname) {
		memberRepository.joinMember(loginId, loginPw,name,nickname);
	}

}
