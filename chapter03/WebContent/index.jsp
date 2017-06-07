<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("SID") == null){
%>
	<a href="./loginForm.jsp">로그인</a>
<%
	}else{
%>
	<a href="./logout.jsp">로그아웃</a>
<%
	}
%>
</body>
</html>