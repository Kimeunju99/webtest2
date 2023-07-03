<%@page import="com.yedam.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"></jsp:include>
<h3>회원 정보</h3>
<%
	MemberVO vo = (MemberVO) request.getAttribute("Member");
%>
<form action="modifyMember.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="uid" value="<%=vo.getUserId()%>" readonly></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="uname" value="<%=vo.getUserName()%>" readonly></td>
		</tr>
		<tr>
			<th>생일</th>
			<td><input type="text" name="ubirth" value="<%=vo.getUserBirth()%>" readonly></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="uphone" value="<%=vo.getUserPhone()%>"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="uaddr" value="<%=vo.getUserAddr()%>"></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><img src="images/<%=vo.getUserImg()%>" width="150px">
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
</form>
<jsp:include page="../footer.jsp"></jsp:include>