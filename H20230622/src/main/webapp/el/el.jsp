<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("msg", "hello, world");
%>
	<h3>Expression Language</h3>
	${"hello"}<br>
	${12.4 - 3.0 }<br>
	${ 10 > 4}<br>
	<p>리퀘스트 어트리뷰트</p><p>msg: ${msg }</p>
	<p>세션</p><p>id: ${loginId }, name: ${loginName }</p>
	<p>request: ${requestScope }</p>
	<p>session: ${sessionScope }</p>
	<p>${1>0 and 2>1} </p>
	<p>${1 lt 0} </p>
	<p>${1 gt 0} </p>
	<p>not equal: ${10 ne 2} </p>
	<p>equal: ${22 eq 20} </p>
	<p>!empty: ${!empty msg} </p>
	<jsp:forward page="../index.jsp"></jsp:forward>
</body>
</html>