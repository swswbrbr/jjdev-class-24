<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원 입력</h1>
<form action="./employeeList.jsp" method="post">
	<div>
		<label for="employeeName">이름</label>
		<input name="employeeName" id="employeeName" type="text">
	</div>
	<div>
		<label>성별</label>
		<input name="employeeGender" class="employeeGender" type="radio" value="남">남
		<input name="employeeGender" class="employeeGender" type="radio" value="여">여
	</div>
	<div>
		<label>기술</label>
		<input name="skillName" class="skillName" type="checkbox" value="JAVA">JAVA
		<input name="skillName" class="skillName" type="checkbox" value="JSP">JSP
		<input name="skillName" class="skillName" type="checkbox" value="HTML">HTML
		<input name="skillName" class="skillName" type="checkbox" value="JAVASCRIPT">JAVASCRIPT
		<input name="skillName" class="skillName" type="checkbox" value="SQL">SQL
	</div>
	<div>
		<input type="submit" value="입력">
	</div>
</form>
</body>
</html>