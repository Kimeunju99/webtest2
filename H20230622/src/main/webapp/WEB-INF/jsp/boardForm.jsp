<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<c:choose>
	<c:when test="${errMsg != null}">
		<p>메세지: <b>${errMsg}</b></p>	
	</c:when>
	<c:otherwise>
		<h3>게시글 등록</h3>
		<form action="addBoard.do" method="post"> <!-- default = get -->
			<table class="table">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><c:choose>
						<c:when test="${loginId == null}">
							<input readonly type="text" name="writer">								
						</c:when>
						<c:otherwise>
							<input readonly type="text" name="writer" value="${loginId }">
						</c:otherwise>
					</c:choose></td>					
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="30" lows="10" name="content"></textarea></td>
				</tr>
				<tr>
				<td><c:choose>
					<c:when test="${loginId == null}">
						<input type="submit" value="저장" disabled>						
					</c:when>
					<c:otherwise>
						<input type="submit" value="저장">				
					</c:otherwise>
				</c:choose>
				</td>
					<td><input type="reset" value="초기화"></td>
				</tr>
			</table>
		</form>
	</c:otherwise>
</c:choose>
<jsp:include page="footer.jsp"></jsp:include>