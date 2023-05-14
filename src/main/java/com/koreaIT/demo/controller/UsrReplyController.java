package com.koreaIT.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.ReplyService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Reply;
import com.koreaIT.demo.vo.ResultData;
import com.koreaIT.demo.vo.Rq;

@Controller
public class UsrReplyController {

	private ReplyService replyService;


	@Autowired
	public UsrReplyController(ReplyService replyService) {
		this.replyService = replyService;
		
	}

	@RequestMapping("/usr/reply/doWrite")
	@ResponseBody
	public String doWrite(HttpServletRequest req,String relTypeCode, int relId, String body) {

		Rq rq = (Rq)req.getAttribute("rq");
		
		ResultData<Integer> replyWriteRd = replyService.writeReply(rq.getLoginedMemberId(), relTypeCode, relId, body);

		return Util.jsReplace(replyWriteRd.getMsg(), Util.f("../article/detail?id=%d", relId));
	}

	@RequestMapping("/usr/reply/doDelete")
	@ResponseBody
	public String doDelete(HttpServletRequest req,int id) {

		Rq rq = (Rq)req.getAttribute("rq");
		Reply reply = replyService.getReply(id);

		ResultData actorCanMDRd = replyService.actorCanMD(rq.getLoginedMemberId(), reply);

		if (actorCanMDRd.isFail()) {
			return Util.jsHistoryBack(actorCanMDRd.getMsg());
		}

		replyService.deleteReply(id);

		return Util.jsReplace(Util.f("%d번 댓글을 삭제했습니다", id), Util.f("../article/detail?id=%d", reply.getRelId()));
	}
	
	@RequestMapping("/usr/reply/doModify")
	@ResponseBody
	public String doModify(HttpServletRequest req,int id, String body) {

		Rq rq = (Rq)req.getAttribute("rq");
		Reply reply = replyService.getReply(id);

		ResultData actorCanMDRd = replyService.actorCanMD(rq.getLoginedMemberId(), reply);

		if (actorCanMDRd.isFail()) {
			return Util.jsHistoryBack(actorCanMDRd.getMsg());
		}

		replyService.modifyReply(id, body);

		return Util.jsReplace(Util.f("%d번 댓글을 수정했습니다", id), Util.f("../article/detail?id=%d", reply.getRelId()));
	}

	@RequestMapping("/usr/reply/getReplyContent")
	@ResponseBody
	public ResultData<Reply> getReplyContent(HttpServletRequest req,int id) {

		Rq rq = (Rq)req.getAttribute("rq");
		Reply reply = replyService.getForPrintReply(id);

		if (reply == null) {
			return ResultData.from("F-1", "해당 댓글은 존재하지 않습니다");
		}

		return ResultData.from("S-1", "댓글 정보 조회 성공", "reply", reply);
	}

}