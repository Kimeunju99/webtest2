<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl1</title>
</head>
<body>
<% String msg = "hello, world";
	out.print(msg);%>
	<my:set value="hello, world" var="msg"></my:set>
	<my:out value="${msg }" ></my:out>
	<my:out value="${loginId }"></my:out>
</body>
</html>