<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책목록</title>
</head>
<body>
	<h1>책목록</h1>
	<table>
		<thead>
			<tr>
				<td>제목</td>
				<td>카테고리</td>
				<td>가격</td>
			</tr>
		</thead>
		<c:forEach var="row" items="${data}">
			<tr>
				<td><a href="/detail?bookId=${row.book_id }"> ${row.title }
				</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>