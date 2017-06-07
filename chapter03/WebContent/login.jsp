<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	//1. request & param
		String id =	request.getParameter("id");
		String pw = request.getParameter("pw");
		
		PreparedStatement pstmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jjdev?" +
				"useUnicode=true&characterEncoding=utf8","root","java0000");
		String sql="select * from member where member_id=? and member_pw=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			session.setAttribute("loginMember", id);
		}
		response.sendRedirect("./index.jsp");
	%>
</body>
</html>