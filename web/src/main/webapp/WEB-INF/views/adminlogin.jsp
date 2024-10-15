<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
	<!-- 헤더 부분 -->
	<jsp:include page="../componants/header.jsp"></jsp:include>

	<!-- 메인 부분 -->
	<main>
		<div class="container">
			<h1 class="title">ADMIN LOGIN</h1>
			<div class="input_wrap">
				<form action="${pageContext.request.contextPath}/adminlogin" method="post">
					<p>
						아이디 : <input type="text" name="admin_id" id="user_id">
					</p>
					<p>
						비밀번호 : <input type="password" name="admin_pw" id="user_pw">
					</p>
					<button id="loginBtn">로그인</button>
					<!-- 서버에서 전달된 메시지를 숨김 -->
					<input type="hidden" id="msg" value="${msg}">
				</form>
				<a href="${pageContext.request.contextPath}/login">유저 로그인</a>
			</div>
		</div>
	</main>
</body>
</html>
