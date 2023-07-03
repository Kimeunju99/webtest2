<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<c:choose>
	<c:when test="${Board == null}">
		<p><b>조회 결과가 없습니다.</b></p>
	</c:when>
	<c:otherwise>
		<h3>상세화면</h3>
		<form action="modifyForm.do" method="post" name="myform">
			<input type="hidden" name="bno" value="${Board.brdNo}">
			<table class="table">
				<tr>
					<th>제목</th>
					<td><input readonly type="text" name="title"
						value="${Board.brdTitle}"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input readonly type="text" name="writer"
						value="${Board.brdWriter}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea readonly cols="30" rows="10" name="content">${Board.brdContent}></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><c:choose>
							<c:when
								test="${loginId == null || !loginId.equals(Board.brdWriter)}">
								<button type="submit" disabled>수정</button>
								<button type="button" disabled>삭제</button>
							</c:when>
							<c:otherwise>
								<button type="submit">수정</button>
								<button type="button">삭제</button>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
		</form>
	</c:otherwise>
</c:choose>


<script>
	console.log(this);
	document.querySelector('form[name="myform"] button[type="button"]')
			.addEventListener('click', function(e) {
				console.log(e);
				document.forms.myform.action = "boardRemove.do";
				document.forms.myform.submit();

				//window.location.href = "boardRemove.do?bno=3";
			});
</script>

<jsp:include page="footer.jsp"></jsp:include>