package com.koreaIT.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.koreaIT.demo.vo.Board;

@Mapper
public interface BoardRepository {

	
	public Board getBoardById(int boardId);
}
