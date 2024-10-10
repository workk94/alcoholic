<%@page import="web.login.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


</style>
<script>

function showItemList(){
	$.ajax ({
		type: "get",
		url: "/shop",
		contentsType: "application/json",
	})
}

function switchMenu(){
	
}

</script>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.currentUser}">
			<a href="${pageContext.request.contextPath}/login">로그인</a>
			<a href="${pageContext.request.contextPath}/register">회원가입</a>
		</c:when>
		<c:otherwise>
        ${sessionScope.currentUser.name}님 안녕하세요
        <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	
	<a href="#" onclick="switchMenu()">와인</a>
	<a href="#">위스키</a>
	<c:forEach var="product" items="${productList}">
		<div class="wrap">
			<div class="item">
				${product.pname} ${product.category} 
				${product.imgUrl} <a
					href="${pageContext.request.contextPath}/shop?product_no=${product.productNo}">상세
					보기</a>
			</div>

		</div>
	</c:forEach>
</body>
</html>