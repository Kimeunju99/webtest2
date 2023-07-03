package com.yedam.member.persistence;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	public MemberVO login(@Param("id") String id, @Param("pw") String pw);
	//param으로 지정하면 mapper.xml에서 parameterType 없이 사용가능
	
	public int insert(MemberVO vo);
	public MemberVO select(String id);
	public int update(MemberVO vo);
}
