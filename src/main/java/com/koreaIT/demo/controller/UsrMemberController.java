package com.koreaIT.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.MemberService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Member;
import com.koreaIT.demo.vo.ResultData;
import com.koreaIT.demo.vo.Rq;

@Controller
public class UsrMemberController {
	
private MemberService memberService;
	
	@Autowired
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/usr/member/dojoin")
	@ResponseBody
	public ResultData<Member> doJoin(HttpServletRequest req ,String loginId, String loginPw,String name,String nickname,String cellphoneNum,String email) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		if (rq.getLoginedMemberId() != 0) {
			return ResultData.from("F-A","이미 로그인 되어있습니다.");
		}
		
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
		
		
		ResultData<Integer> doJoinRd = memberService.joinMember(loginId, loginPw, name, nickname,cellphoneNum,email);
		
		if(doJoinRd.isFail()) {
			return ResultData.from(doJoinRd.getResultCode(),doJoinRd.getMsg());

		}
		return ResultData.from(doJoinRd.getResultCode(),doJoinRd.getMsg(),"member",memberService.getMemberById(((int)doJoinRd.getData1())));
	}
	
	@RequestMapping("/usr/member/login")
	public String login() {			
		return "usr/member/login";
	}
	
	@RequestMapping("/usr/member/dologin")
	@ResponseBody
	public String doLogin (HttpServletRequest req, String loginId , String loginPw) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		if (rq.getLoginedMemberId() != 0) {
			return Util.jsHistoryBack("이미 로그인 되어있습니다.");
		}
		
		if (Util.empty(loginId)) {
			return Util.jsHistoryBack("아이디를 입력해주세요");
		}
		
		if (Util.empty(loginPw)) {
			return Util.jsHistoryBack("비밀번호를 입력해주세요");
		}
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			return Util.jsHistoryBack(Util.f("%s은 존재하지 않는아이디입니다.", loginId));

		}
		
		if(member.getLoginPw().equals(loginPw) == false) {
			return Util.jsHistoryBack("비밀번호가 일치하지 않습니다.");

		}
		
		rq.login(member);
		
		return Util.jsReplace(Util.f("%s 회원님 환영합니다~!", member.getNickname()), "/");
	}
	
	@RequestMapping("/usr/member/dologout")
	@ResponseBody
	public String doLogout (HttpSession httpSession) {
		
		if(httpSession.getAttribute("loginedMemberId") == null) {
			return Util.jsHistoryBack("로그인을 해주세요.");
		}
		
		httpSession.removeAttribute("loginedMemberId");
		
		return Util.jsReplace("로그아웃 되었습니다.", "/");
	}

}



