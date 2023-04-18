package com.koreaIT.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.MemberService;
import com.koreaIT.demo.util.Util;

@Controller
public class UsrMemberController {
	
private MemberService memberService;
	
	@Autowired
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/usr/member/dojoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw,String name,String nickname,String cellphoneNum,String email) {
		
		if(Util.empty(loginId)) {
			return "아이디를 입력해 주세요";
		}
		if(Util.empty(loginPw)) {
			return "비밀번호를 입력해 주세요";
		}
		if(Util.empty(name)) {
			return "이름을 입력해 주세요";
		}
		if(Util.empty(nickname)) {
			return "닉네임을 입력해 주세요";
		}
		if(Util.empty(cellphoneNum)) {
			return "폰번호를 입력해 주세요";
		}
		if(Util.empty(email)) {
			return "email을 입력해 주세요";
		}
		
		
		int id = memberService.joinMember(loginId, loginPw, name, nickname,cellphoneNum,email);
		
		if(id == -1) {
			return "이미 사용중인 아이디 입니다.";
		}
		if(id == -2) {
			return "이미 사용중인 닉네임 입니다.";
		}
		if(id == -3) {
			return "이미 사용중인 이름과 이메일 입니다.";
		}
		
		return memberService.getMemberById(id);
	}

}



