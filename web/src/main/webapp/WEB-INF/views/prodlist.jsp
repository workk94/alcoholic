<%@page import="web.userpage.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<td>코드</td>
<td>이름</td>
<td>가격</td>
<td>장바구니</td>
</tr>

<% ArrayList<Product> list = ( ArrayList<Product>) request.getAttribute("list"); %>
<% for( Product product : list){ %>

<tr>
<td><%= product.getProd_no() %></td>
<td><%= product.getName() %></td>
<td><%= product.getPrice() %></td>
<td> <a href="/web.userpage/addcart?code=<%=product.getProd_no()%>"> 추가하기</a></td>
</tr>

<%} %>

</table>

<div> <a href="/web.userpage/cart">장바구니</a> </div>

</body>
</html>