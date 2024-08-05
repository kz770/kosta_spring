<%@page import="org.springframework.web.filter.CharacterEncodingFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Dept 테이블</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서위치</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td><a href="detailDept.do?dno=${vo.dno }">${vo.dno }</a></td>
				<td>${vo.dname }</td>
				<td>${vo.dloc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>