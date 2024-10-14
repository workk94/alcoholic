<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<link rel="stylesheet" type="text/css" href="/web/css/style.css">
<link rel="stylesheet" type="text/css" href="/web/css/register.css">
</head>
<body>
	<!--  header -->
	<jsp:include page="../componants/header.jsp" />

	<div class="wrap">
		<form name="frm" action="${pageContext.request.contextPath}/register" method="post" id="registerForm">
			<div class="form-group">
				<label for="userId">아이디</label>
				<div class="input-group">
					<input type="text" name="id" id="userId" />
					<button type="button" id="checkIdBtn">중복체크</button>
				</div>
				<div id="msg" class="error"></div>
			</div>

			<div class="form-group">
				<label for="pw">패스워드</label>
				<input type="password" name="pw" id="pw" />
			</div>

			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" name="name" id="name" />
			</div>

			<div class="form-group">
				<label for="ssn">주민번호</label>
				<input type="text" name="ssn" id="ssn" placeholder="예: 123456-1234567" />
			</div>

			<div class="form-group">
				<label for="phone">전화번호</label>
				<input type="text" name="phone" id="phone" placeholder="예: 010-1234-5678" />
			</div>

			<div class="form-group">
				<label for="addr">주소</label>
				<input type="text" name="addr" id="addr" />
			</div>

			<button type="submit" class="regBtn">회원가입</button>
		</form>
	</div>
</body>
</html>
