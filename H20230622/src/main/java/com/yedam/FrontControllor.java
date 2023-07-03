package com.yedam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.control.BoardAddControl;
import com.yedam.board.control.BoardFormControl;
import com.yedam.board.control.BoardListControl;
import com.yedam.board.control.BoardModifyControl;
import com.yedam.board.control.BoardModifyFormControl;
import com.yedam.board.control.BoardRemoveControl;
import com.yedam.board.control.BoardSearchControl;
import com.yedam.common.Controller;
import com.yedam.member.control.AddMemberControl;
import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.LogoutControl;
import com.yedam.member.control.MemberInfoControl;
import com.yedam.member.control.MemberJoinFormControl;
import com.yedam.member.control.modifyMemberControl;

public class FrontControllor extends HttpServlet{
	
	HashMap<String, Controller> menu;
	String enc;
	public FrontControllor() {
		menu = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		enc = config.getInitParameter("charset");
		//해시에 uri 여러개를 담아둔다.
//		menu.put("/abc.do", "abc페이지실행"); //HashMap<String, String>
		menu.put("/main.do", new MainControl());
		menu.put("/boardList.do", new BoardListControl());
		menu.put("/boardForm.do", new BoardFormControl());
		menu.put("/addBoard.do", new BoardAddControl());
		menu.put("/getBoard.do", new BoardSearchControl());
		menu.put("/modifyForm.do", new BoardModifyFormControl());
		menu.put("/boardModify.do", new BoardModifyControl());
		menu.put("/boardRemove.do", new BoardRemoveControl());
		
		menu.put("/memberLoginForm.do", new LoginFormControl()); //로그인 화면 기능
		menu.put("/memberLogin.do", new LoginControl());//로그인 기능
		menu.put("/memberLogout.do", new LogoutControl());
		menu.put("/memberJoin.do", new MemberJoinFormControl());//회원가입 화면 연결
		menu.put("/addMember.do", new AddMemberControl());
		menu.put("/memberInfo.do", new MemberInfoControl());
		menu.put("/modifyMember.do", new modifyMemberControl());
//		menu.put("/member.do", new MemberControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		
		String uri = req.getRequestURI();     //url:서버정보o uri:서버정보x
		String cpath = req.getContextPath(); //application name
		String path = uri.substring(cpath.length());
//		System.out.println(uri);
//		System.out.println(cpath);//project name
		System.out.println(path); //this page
		
		//서비스를 호출한 곳에서 준 uri path 정보가 들어간다.
		Controller msg = menu.get(path);
		msg.exec(req, resp);
		
	}
	
	
}
