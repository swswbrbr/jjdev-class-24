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
		if(session.getAttribute("SID") != null){
			response.sendRedirect("./index.jsp");
		}else{
	%>
			
		<form action="./GetServlet" method="post">
			<div>
				ID : <input type="text" name="id">
			</div>
			<div>
				PW : <input type="password" name="pw">
			</div>
		<input type="submit" value="로그인">
		</form>
	<%
		}
	%>
</body>
</html>