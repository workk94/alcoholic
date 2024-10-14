<%@page import="web.userpage.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/web/css/review.css">
<style>
body {
	padding: 0px 190px;
}

main {
	min-height: 315px;
	padding: 0 190px 0 190px;
}

.container {
	width: 100%;
	display: flex;
	justify-content: center;
	flex-direction: column;
	align-items: center;
}

.title {
	padding: 15px 0 20px 0;
	width: 500px;
	border-bottom: 1px solid black;
	text-align: center;
	font-size: 40px;
}

table {
	border-top: 1px solid black;
	border-collapse: collapse;
	margin: 100px auto;
}

td {
	border-bottom: 1px solid black;
	padding: 10px;
	text-align: center;
}
</style>
</head>
<body>
	<!--  header -->
	<jsp:include page="../componants/header.jsp" />

	<main>
		<div class="container">

			<h1 class="title">ORDER</h1>

			<table>

				<tr>
					<td>아이디</td>
					<td>제품명</td>
					<td>카테고리</td>
					<td>가격</td>
					<td>수량</td>
					<td>날짜</td>
				</tr>

				<%
				ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("cartlist");
				int result2 = 0;
				%>

				<%
				for (Order order : list) {
				%>
				<tr>
					<td><%=order.getUser_id()%></td>
					<td><%=order.getName()%></td>
					<td><%=order.getCategory()%></td>
					<td><%=order.getPrice()%></td>
					<td><%=order.getQuantity()%></td>
					<td><%=order.getOrder_date()%></td>
				</tr>
				<%
				int result = 0;
				
				result += order.getPrice() * Integer.parseInt(order.getQuantity());
				result2 += result;
				%>
				<%
				}
				%>

			</table>
			
				합계 금액: <%= result2 %>원
				
		</div>
	</main>
</body>
</html>