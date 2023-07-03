package com.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.persistence.BoardMapper;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.DataSource;

public class BoardServiceMybatis implements BoardService{
	SqlSession session = DataSource.getInstance().openSession(true); 
	//opensession=여러 세션 중 하나를 반환(매개변수로 true하면 자동커밋)
	BoardMapper mapper = session.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> listPage(int page) {
//		return session.selectList("com.yedam.board.persistence.BoardMapper.boardList");
		return mapper.boardList(page);
	}
	
	@Override
	public boolean addBoard(BoardVO vo) {
		return mapper.insertBoard(vo) == 1;
	}

	@Override
	public BoardVO getBoard(long brdNo) {
		BoardVO vo = mapper.selectBoard(brdNo);
		mapper.updateCnt(brdNo);
		return vo;
	}

	@Override
	public boolean editBoard(BoardVO vo) {
		return mapper.updateBoard(vo) == 1;
	}

	@Override
	public boolean delBoard(long no) {
		return mapper.deleteBoard(no) == 1;
	}

	@Override
	public List<BoardVO> list() {
		return null;
	}
	

	@Override
	public int totalCnt() {
		return mapper.totalCnt();
	}
	
}
