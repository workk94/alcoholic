<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/adminlogin" method="post">
		<label for="admin_id"> 아이디 </label> <input type="text" name="admin_id"
			id="admin_id"> <label for="admin_pw"> 비밀번호 </label> <input
			type="password" name="admin_pw" id="admin_pw">
		<button id="loginBtn">로그인</button>
	</form>
	<a href="${pageContext.request.contextPath}/login">유저 로그인</a>
</body>
</html>