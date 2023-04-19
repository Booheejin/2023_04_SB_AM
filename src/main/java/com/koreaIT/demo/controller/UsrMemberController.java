package com.koreaIT.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.MemberService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.ResultData;

@Controller
public class UsrMemberController {
	
private MemberService memberService;
	
	@Autowired
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/usr/member/dojoin")
	@ResponseBody
	public ResultData<Object> doJoin(String loginId, String loginPw,String name,String nickname,String cellphoneNum,String email) {
		
		if(Util.empty(loginId)) {
			return ResultData.from("F-1","아이디를 입력해 주세요");
//			return "아이디를 입력해 주세요";
		}
		if(Util.empty(loginPw)) {
			return ResultData.from("F-2","비밀번호를 입력해 주세요");
//			return "비밀번호를 입력해 주세요";
		}
		if(Util.empty(name)) {
			return ResultData.from("F-3","이름을 입력해 주세요");
//			return "이름을 입력해 주세요";
		}
		if(Util.empty(nickname)) {
			return ResultData.from("F-4","닉네임을 입력해 주세요");
//			return "닉네임을 입력해 주세요";
		}
		if(Util.empty(cellphoneNum)) {
			return ResultData.from("F-5","폰번호를 입력해 주세요");
//			return "폰번호를 입력해 주세요";
		}
		if(Util.empty(email)) {
			return ResultData.from("F-6","email을 입력해 주세요");
//			return "email을 입력해 주세요";
		}
		
		
		ResultData<Object> doJoinRd = memberService.joinMember(loginId, loginPw, name, nickname,cellphoneNum,email);
		
		if(doJoinRd.isFail()) {
			return doJoinRd;

		}
		return ResultData.from(doJoinRd.getResultCode(),doJoinRd.getMsg(),memberService.getMemberById(((int)doJoinRd.getData1()))) ;
	}

}



