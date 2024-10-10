<%@page import="web.userpage.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>

<h2>주문 내역</h2>

<table>

<tr>
<td>아이디</td>
<td>제품명</td>
<td>카테고리</td>
<td>가격</td>
<td>수량</td>
<td>날짜</td>
</tr>

<% ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("list"); %>

<% for(Order order : list){ %>
<tr>
<td><%= order.getUser_id() %></td>
<td><%= order.getName() %></td>
<td><%= order.getCategory() %></td>
<td><%= order.getPrice() %></td>
<td><%= order.getQuantity() %></td>
<td><%= order.getOrder_date() %></td>
</tr>

<% 
int result = 0;
result += order.getPrice();
%>

<tr>
<td colspan="6">합계 금액 : <%= result %></td>
</tr>
<%} %>

</table>

</body>
</html>