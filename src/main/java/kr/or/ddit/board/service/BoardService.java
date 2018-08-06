package kr.or.ddit.board.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf{

	@Override
	public List<BoardVo> getBoradList() {
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		
		
		boardList.add(new BoardVo("첫번째 글입니다", "첫번째 내용입니다", "brown", "곰", new Date()));
		boardList.add(new BoardVo("두번째 글입니다", "두번째 내용입니다", "sally", "곰", new Date()));
		boardList.add(new BoardVo("세번째 글입니다", "세번째 내용입니다", "tt", "곰", new Date()));
		boardList.add(new BoardVo("네번째 글입니다", "네번째 내용입니다", "", "곰", new Date()));
		boardList.add(new BoardVo("다번째 글입니다", "다번째 내용입니다", "brown", "곰", new Date()));
		boardList.add(new BoardVo("여번째 글입니다", "여번째 내용입니다", "brown", "곰", new Date()));
		
		return boardList;
	}

	
	
}
