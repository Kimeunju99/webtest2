package com.yedam.common;

import java.util.List;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;

public class TestMain {
	public static void main(String[] args) {
		BoardService service = new BoardServiceMybatis();
		BoardVO vo = new BoardVO();
		vo.setBrdNo(2);
		vo.setBrdTitle("change");
		vo.setBrdContent("change");
		vo.setBrdWriter("useerr");
		
		//삽입 테스트
		if(service.addBoard(vo));
			System.out.println("성공");
		
//		//수정 테스트
//		if(service.editBoard(vo));
//			System.out.println("성공");
//		
		//단건 조회 테스트
//		System.out.println(service.getBoard(111));
		
		//삭제 테스트
//		if(service.delBoard(111))
//			System.out.println("성공");
		
//		목록 테스트
//		List<BoardVO> list = service.listPage(1);
//		System.out.println(list.size());
//	
//		for(BoardVO vo : list) {
//			System.out.println(vo.toString());
//		}
	}
}
