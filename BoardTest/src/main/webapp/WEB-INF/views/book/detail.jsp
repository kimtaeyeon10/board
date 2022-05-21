<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세</title>
</head>
<body>

	<h1>책 상세</h1>
	<!-- 컨트롤러에서  mav.addObject("data",detailMap)라고 설정.. data-->
	<p>제목 : ${data.TITLE}</p>
	<p>카테고리: ${data.category}</p>
	<p>가격 : ${data.PRICE}</p>

	<p>
		<a href="/update?bookId?=${bookId}">수정</a>
	</p>
	<form method="POST" action="/delete">
		<input type="hidden" name="bookId" value="${bookId}" /> 
		<input type="submit" value="삭제" />
	</form>
	<p>
		<a href="/list">목록</a>
	</p>
</body>
</html>