package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class LoginControl implements Controller{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String id = req.getParameter("uid");
		String pw = req.getParameter("upw");
		
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.login(id, pw);
		
		if(member != null) { //로그인 성공
			session.setAttribute("loginId", member.getUserId()); //로그인 정보 기억?인듯
			session.setAttribute("loginName", member.getUserName());
			resp.sendRedirect("boardList.do");
		}else//로그인 실패
			resp.sendRedirect("memberLoginForm.do");
		
	}

}
