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

public class MemberInfoControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("loginId");
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = service.getMember(id);
		req.setAttribute("Member", vo);
		//service(getMember)/mapper(select) /jsp
		if(vo != null) {
			req.getRequestDispatcher("/WEB-INF/jsp/member/memberInfo.jsp").forward(req, resp);
		}
	}

}
