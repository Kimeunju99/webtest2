<%@page import="com.yedam.board.vo.BoardVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
	<h3>수정 화면</h3>
	<form action="boardModify.do" method="post">
		<table class="table">
			<tr>
			<th>글번호</th><td><input readonly name="no" value="${board.brdNo}"></td>
			<th>조회수</th><td>${board.clickCnt}</td>
			</tr>
			<tr>
				<th>제목</th><td colspan="3"><input name="title" value="${board.brdTitle}" style="width:340px"></td>
			</tr>	
			<tr>
				<th>내용</th><td colspan="3"><textarea name="content" cols="50" rows="3">${board.brdContent}</textarea></td>
			</tr>
			<tr>
				<th>작성자</th><td><input readonly value="${board.brdWriter}"></td>
				<th>작성일</th><td>${board.createdate}></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>

<jsp:include page="footer.jsp"></jsp:include>