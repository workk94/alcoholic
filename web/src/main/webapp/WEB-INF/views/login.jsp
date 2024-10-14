<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript" src="/web/js/login.js"></script>
</head>

<body>
	<!-- 헤더 부분 -->
	<jsp:include page="../componants/header.jsp"></jsp:include>

	<!-- 메인 부분 -->
	<main>
		<div class="container">
			<h1 class="title">LOGIN</h1>
			<div class="input_wrap">
				<form action="${pageContext.request.contextPath}/login" method="post">
					<p>
						아이디 : <input type="text" name="user_id" id="user_id">
					</p>
					<p>
						비밀번호 : <input type="password" name="user_pw" id="user_pw">
					</p>
					<button id="loginBtn">로그인</button>
					<!-- 서버에서 전달된 메시지를 숨김 -->
					<input type="hidden" id="msg" value="${msg}">
				</form>
				<a href="${pageContext.request.contextPath}/register">회원가입</a>
				<a href="${pageContext.request.contextPath}/adminlogin">관리자 로그인</a>
			</div>
		</div>
	</main>
</body>

</html>
