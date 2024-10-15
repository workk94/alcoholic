<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BOTTLE 메인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<!--  header -->
	<jsp:include page="../componants/header.jsp"></jsp:include>

	<main>
		<!-- 페이징 처리 -->
		<div class="pagination">
			<c:if test="${paging.grpStartPage > 1}">
				<a href="?p=${paging.grpStartPage - 1}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${paging.grpStartPage}" end="${paging.grpEndPage}">
				<a href="?p=${i}" class="${i == paging.currentPage ? 'active' : ''}">${i}</a>
			</c:forEach>

			<c:if test="${paging.grpEndPage < paging.totalPage}">
				<a href="?p=${paging.grpEndPage + 1}">[다음]</a>
			</c:if>

			<form action="${pageContext.request.contextPath}/search" method="GET">
				<input type="text" id="searchBar" name="s_keword" placeholder="검색어를 입력하세요">
				<button type="submit" class="searchBtn">검색</button>
			</form>
		</div>

		<div class="container">
			<c:forEach var="product" items="${list}">
				<div class="item">
					<a href="${pageContext.request.contextPath}/shop?product_no=${product.productNo}">
						<img class="item_img" src="${product.imgUrl}" alt="${product.pname}">
					</a> 
					<a href="${pageContext.request.contextPath}/shop?product_no=${product.productNo}">
						<p class="item_name">${product.pname}</p>
					</a>
					<p class="price">${product.price}원</p>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>
