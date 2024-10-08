<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<label for="user_id"> 아이디 </label> <input type="text" name="user_id">
		<label for="user_pw"> 비밀번호 </label> <input type="password" name="user_pw">
		<button>로그인</button>
	</form>
	<a href="${pageContext.request.contextPath}/register">회원가입</a>
	<a href="${pageContext.request.contextPath}/admin">관리자 로그인</a>
</body>
</html>