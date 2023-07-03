package com.yedam.board.persistence;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> boardList(int page); //페이지 리스트
	public BoardVO selectBoard(long no); //1건 조회(메소드이름은 BoaraMapper.xml id와 같아야함)
	public int updateCnt(long bno);
	public int deleteBoard(long bno);
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int totalCnt();
}
