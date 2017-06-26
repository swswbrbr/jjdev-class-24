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
		//1-1.요청분석 -> servelet:FrontController
		int boardNo = 1;
		if(request.getParameter("boardNo") != null){
			boardNo = Integer.parseInt(request.getParameter("boardNo"));
		}
		
		//1-2.모델을 호출 -> servlet:ActionController
		Board board = new BoardDAO().selectBoard(boardNo);//board모델(DATA) 완성
	
		//3. 모델을 출력(View)

	%>
	<%= board.toString() %>
</body>
</html>