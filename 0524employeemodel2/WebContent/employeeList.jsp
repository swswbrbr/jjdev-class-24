<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "service.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf8");
	String employeeName = request.getParameter("employeeName");
	String employeeGender = request.getParameter("employeeGender");
	String[] skillName = request.getParameterValues("skillName");
	System.out.println(employeeName+" <-- employeeName getParam");
	System.out.println(employeeGender+" <-- employeeGender getParam");
	System.out.println(skillName+" <-- skillName getParam");

	EmployeeService employeeservice = new EmployeeService();
	ArrayList<EmployeeAndSkill> list = employeeservice.selectEmployee(employeeName, employeeGender, skillName);
%>
	<table>
		<thead>
			<th>ID</th>
			<th>NAME</th>
			<th>GENDER</th>
			<th>SKILL</th>
		</thead>

<%	
	for(EmployeeAndSkill es : list){
%>
	<tbody>
		<td><%= es.getEmployee().getEmployeeNo() %></td>
		<td><%= es.getEmployee().getEmployeeName() %></td>
		<td><%= es.getEmployee().getEmployeeGender() %></td>
		<td><%= es.getSkill().getSkillName() %></td>
<%
	}
%>
	</tbody>
	</table>
</body>
</html>