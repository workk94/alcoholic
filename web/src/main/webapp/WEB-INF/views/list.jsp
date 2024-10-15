<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 페이지</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<!--  헤더 부분 -->
	<jsp:include page="../componants/header.jsp"></jsp:include>

	<main>
		<!-- 검색바 -->
		<form action="${pageContext.request.contextPath}/search" method="GET">
			<input type="text" id="searchBar" name="s_keyword"
				placeholder="검색어를 입력하세요">
			<button type="submit" class="searchBtn">검색</button>
		</form>

		<div class="container">
			<c:forEach var="product" items="${list}">
				<div class="item">
					<a
						href="${pageContext.request.contextPath}/shop?product_no=${product.productNo}">
						<img class="item_img" src="${product.imgUrl}"
						alt="${product.pname}">
					</a> <a
						href="${pageContext.request.contextPath}/shop?product_no=${product.productNo}">
						<p class="item_name">${product.pname}</p>
					</a>
					<p class="price">${product.price}원</p>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>
