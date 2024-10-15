<%@page import="java.util.ArrayList"%>
<%@page import="web.userpage.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.name } 상품 페이지</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/shop.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../componants/header.jsp"></jsp:include>

	<!-- body -->
	<div class="item_wrap">
		<div class="item_img">
			<img alt="${product.name}" src="${product.img_url}">
		</div>
		<div class="item_info">
			<div class="item_info">
					<div class="product_name">${product.name}</div>
					<div class="product_category">${product.category}</div>
					<div class="product_price">${product.price}원</div>
					<div>
						<form action="addcart" method="get">
							<input type="hidden" name="code" value="${product.prod_no}">
							<input class="cartQty" type="number" name="qty" placeholder="1"
								min="1" >
							<button type="submit" class="addToCart">장바구니에 넣기</button>
						</form>
					</div>
				</div>
		</div>
	</div>
</body>
</html>