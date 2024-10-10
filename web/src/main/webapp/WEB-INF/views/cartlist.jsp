<%@page import="web.userpage.Product"%>
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
}
</style>
</head>
<body>




<% ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cartlist"); %>

	<table>

	<tr>
	<td>제품코드</td>
	<td>제품명</td>
	<td>가격</td>
	<td>선택</td>
	</tr>

<% for(Product s : list){ %>
	 
	 
	 <tr>
	 <td><%= s.getProd_no() %></td>
	 <td><%= s.getName() %></td>
	 <td><%= s.getPrice() %></td>
	 <td> <a href="/web.userpage/deletecart?code=<%= s.getProd_no() %>">삭제</a> </td>
	 </tr>

	 
<%} %>
 
	 </table>

</body>
</html>