package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class modifyMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String id = req.getParameter("uid");
		String addr = req.getParameter("uaddr");
		String phone = req.getParameter("uphone");
		
		MemberVO member = new MemberVO();
		MemberService service = new MemberServiceImpl();
		
		member.setUserId(id);
		member.setUserAddr(addr);
		member.setUserPhone(phone);	
		
		if(service.modifyMember(member))
			resp.sendRedirect("boardList.do");
	}

}
