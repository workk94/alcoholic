<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<link rel="stylesheet" type="text/css" href="/web/css/review.css">

<style type="text/css">
.wrap {
	display: flex;
	justify-content: center;
}

form {
	margin: 30px;
	width: 600px;
	padding: 30px 50px;
	border: 1px solid gray;
	background-color: rgba(252, 245, 223, 0.95);
}

table {
	width: 100%;
	border-collapse: collapse;
}

td {
	padding: 15px 0;
	font-size: 18px;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	font-size: 18px;
	border: 1px solid gray;
	background-color: rgba(252, 245, 223, 0.95);
}

button {
	padding: 10px 20px;
	background-color: black;
	color: white;
	font-size: 18px;
	border: none;
	cursor: pointer;
	display: inline-block;
	margin-left: 10px;
}

button:hover {
	background-color: gray;
}

.checkLogin {
	margin-top: 20px;
	width: 100%;
	padding: 15px;
	background-color: black;
	color: white;
	font-size: 20px;
	border: none;
	cursor: pointer;
	text-align: center;
}

.checkLogin:hover {
	background-color: gray;
}

h1 {
	text-align: center;
	font-size: 40px;
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<!--  header -->
	<jsp:include page="../componants/header.jsp" />


	<div class="wrap">
		<form name="frm" action="${pageContext.request.contextPath}/register"
			method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" />
						<button onclick="isUserExist()">중복체크</button></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="text" name="pw" /></td>
				</tr>
				<tr>
					<td>패스워드 확인</td>
					<td><input type="text" name="pw2" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>주민번호</td>
					<td><input type="text" name="ssn" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" /></td>
				</tr>
			</table>
			<button class="checkLogin">회원가입</button>
		</form>

	</div>
</body>
</html>
