package com.koreaIT.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.MemberService;

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
		
		if(loginId == null || loginId.trim().length() == 0) {
			return "아이디를 입력해 주세요";
		}
		if(loginPw == null || loginPw.trim().length() == 0) {
			return "비밀번호를 입력해 주세요";
		}
		if(name == null || name.trim().length() == 0) {
			return "이름을 입력해 주세요";
		}
		if(nickname == null || nickname.trim().length() == 0) {
			return "닉네임을 입력해 주세요";
		}
		if(cellphoneNum == null || cellphoneNum.trim().length() == 0) {
			return "폰번호를 입력해 주세요";
		}
		if(email == null || email.trim().length() == 0) {
			return "email을 입력해 주세요";
		}
		
		
		int id = memberService.joinMember(loginId, loginPw, name, nickname,cellphoneNum,email);
		
		if(id == -1) {
			return "이미 사용중인 아이디 입니다.";
		}
		
		return memberService.getMemberById(id);
	}

}



