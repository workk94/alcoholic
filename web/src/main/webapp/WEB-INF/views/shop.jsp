<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.item_wrap {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    padding: 10px;
}

.item_img {
    flex: 1;
    max-width: 50%;
    text-align: center;
}

.item_img img {
    width: 100%;
    height: auto;
}

.item_info {
    flex: 1;
    max-width: 50%;
    padding-left: 20px;
}

.product_name {
    font-size: 1.5em; 
    font-weight: bold; 
    margin-bottom: 10px;
}

.product_category {
    font-size: 1em;
    color: #888; 
    margin-bottom: 10px;
}

.product_price {
    font-size: 1.2em; 
    color: #000; 
    margin-bottom: 20px;
}

.addToCart, .orderNow {
    padding: 10px 20px;
    margin-right: 10px;
    cursor: pointer;
}

.orderNow {
    background-color: #ff6b6b; 
    color: white;
}

</style>
<script>
	
</script>
</head>
<body>
	<div class="item_wrap">
		<div class="item_img">
			<img alt="${product.pname}" src="${product.imgUrl}">
		</div>
		<div class="item_info">
			<div class="product_name">${product.pname}</div>
			<div class="product_category">${product.category}</div>
			<div class="product_price">${product.price}원</div>
			<button class="addToCart">장바구니에 넣기</button>
			<button class="orderNow">주문하기</button>
		</div>
	</div>
</body>
</html>