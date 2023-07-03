package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;

public class BoardAddControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		if(title.isEmpty() || writer.isEmpty() || content.isEmpty() ) {
			req.setAttribute("errMsg", "필수값 미입력");
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		}else {
			
		BoardService service = new BoardServiceMybatis();
		BoardVO vo = new BoardVO();
		vo.setBrdTitle(title);
		vo.setBrdWriter(writer);
		vo.setBrdContent(content);
		
		if(service.addBoard(vo))
			resp.sendRedirect("boardList.do");
		else
			resp.sendRedirect("boardForm.do");
		}
	}

}
