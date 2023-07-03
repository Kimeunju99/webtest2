package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Controller;

public class MemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		System.out.println("MemberControl");
	}

}
