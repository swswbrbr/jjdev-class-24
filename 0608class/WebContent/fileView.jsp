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
		String src = (String) request.getAttribute("file");
		System.out.print(src+" <-- src fileView.jsp");
	%>
	<a href="./image.jsp?src=<%= src %>">이미지 보기</a>
	
</body>
</html>