<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>다중파일 업로드</h1>
	<form action="./partUploadPro2" method="post" enctype="multipart/form-data">
		<label for="writer">작성자 : </label><input type = "text" name="writer" id="writer"><br>
		<label for="partFile1">업로드파일1 : </label><input type = "file" name="partFile1" id="partFile1"><br>
		<label for="partFile2">업로드파일2 : </label><input type = "file" name="partFile2" id="partFile2"><br>
		<label for="partFile3">업로드파일3 : </label><input type = "file" name="partFile3" id="partFile3"><br>
		<label for="partFile4">업로드파일4 : </label><input type = "file" name="partFile4" id="partFile4"><br>
		<input type="submit" value="파일업로드">
	</form>
</body>
</html>