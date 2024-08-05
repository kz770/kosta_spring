<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertDeptOK.do" method="post">
	부서번호 : <input type="text" name="dno"><br>
	부서이름 : <input type="text" name="dname"><br>
	부서위치 : <input type="text" name="dloc"><br>
	<input type="submit" value="작성 완료">
	<input type="reset" value="다시 작성하기">
</form>
</body>
</html>