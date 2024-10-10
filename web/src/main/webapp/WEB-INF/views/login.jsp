<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#loginBtn').on('click', function(e) {
			let userIdInput = $('#user_id').val();
			let userPwInput = $('#user_pw').val();

			if (userIdInput === '') {
				e.preventDefault();
				alert('아이디를 입력하세요');
			} else if (userPwInput === '') {
				e.preventDefault();
				alert('비밀번호를 입력하세요');
			}
		});
	});

	<c:if test="${not empty msg}">
	alert("${msg}");
	</c:if>
</script>
</head>
<body>

	<form action="${pageContext.request.contextPath}/login" method="post">
		<label for="user_id"> 아이디 </label> <input type="text" name="user_id"
			id="user_id"> <label for="user_pw"> 비밀번호 </label> <input
			type="password" name="user_pw" id="user_pw">
		<button id="loginBtn">로그인</button>
	</form>
	<a href="${pageContext.request.contextPath}/register">회원가입</a>
	<a href="${pageContext.request.contextPath}/admin">관리자 로그인</a>
</body>
</html>