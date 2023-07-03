package com.yedam.member.service;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String id, String pw);
	public boolean addMember(MemberVO member);
	public MemberVO getMember(String id);
	public boolean modifyMember(MemberVO member);
}
