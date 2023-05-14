package com.koreaIT.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.koreaIT.demo.vo.ReactionPoint;

@Mapper
public interface ReactionPointRepository {

//	@Select("""
//			SELECT IFNULL(SUM(`point`), 0) AS sumReactionPoint
//				FROM reactionPoint
//				WHERE memberId = #{loginedMemberId}
//				AND relId = #{relId}
//				AND relTypeCode = #{relTypeCode}
//			""")
	ReactionPoint getReactionPoint(int loginedMemberId, int relId, String relTypeCode);

}