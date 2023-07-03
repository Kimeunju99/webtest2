package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;

public class BoardModifyControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//db update
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String  content = req.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setBrdNo(Long.parseLong(no));
		vo.setBrdTitle(title);
		vo.setBrdContent(content);
		
		BoardService service = new BoardServiceMybatis();
		boolean result = service.editBoard(vo);
		
		if(result)
			resp.sendRedirect("boardList.do");
	}

}
