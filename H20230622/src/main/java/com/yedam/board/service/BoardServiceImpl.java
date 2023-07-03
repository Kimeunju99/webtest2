package com.yedam.board.service;

import java.util.List;

import com.yedam.board.persistence.BoardDAO;
import com.yedam.board.vo.BoardVO;


//jdbc 활용
public class BoardServiceImpl implements BoardService{

	BoardDAO dao = new BoardDAO();
	
	
	@Override
	public boolean addBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public BoardVO getBoard(long brdNo) {
		return dao.selectBoard(brdNo);
	}

	@Override
	public boolean editBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public boolean delBoard(long vo) {
		return dao.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> list() {
		return dao.boardList();
	}

	@Override
	public List<BoardVO> listPage(int page) {
		return dao.boardListPaging(page);
	}

	@Override
	public int totalCnt() {
		
		return dao.getTotalCnt();
	}
	
	
}
