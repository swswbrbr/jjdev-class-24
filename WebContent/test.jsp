<%@page import="board.model.*"%>
<%@page import="board.repository.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//1-1.��û�м� -> servelet:FrontController
		int boardNo = 1;
		if(request.getParameter("boardNo") != null){
			boardNo = Integer.parseInt(request.getParameter("boardNo"));
		}
		
		//1-2.���� ȣ�� -> servlet:ActionController
		Board board = new BoardDAO().selectBoard(boardNo);//board��(DATA) �ϼ�
	
		//3. ���� ���(View)

	%>
	<%= board.toString() %>
</body>
</html>