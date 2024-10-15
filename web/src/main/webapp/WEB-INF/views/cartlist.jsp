<%@page import="web.userpage.Product"%>
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

.quantbtn {
	width: 30px;
	border: none;
	background-color: rgba(252, 245, 223, 0.95);
}

.orderbtn {
	text-decoration: none;
	border: none;
	background-color: rgba(252, 245, 223, 0.95);
	cursor: pointer;
	font-size: 15px;
}

.delbtn {
	height: 10px;
	text-decoration: none;
	font-size: 16px;
	background-color: rgba(252, 245, 223, 0.95);
}
</style>
</head>
<body>
	<!--  header -->
	<jsp:include page="../componants/header.jsp" />

	<main>
		<div class="container">
		

				<%
				ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cartlist");
				%>

				<h1 class="title">CART</h1>

				<table>

					<tr>
						<td>이미지</td>
						<td>제품코드</td>
						<td>제품명</td>
						<td>수량</td>
						<td>가격</td>
						<td>선택</td>
					</tr>

					<%
					for (Product s : list) {
					%>

	
					<tr>
					<form action="/web/ordercreate" method="post">
						<td><%=s.getImg_url()%></td>
						<td><%=s.getProd_no()%></td>
						<td><%=s.getName()%></td>
						<td><input type="number" value="<%=s.getQuantity() %>" min="0"
							name="quantity" class="quantbtn"></td>
						<td>
						<input type="hidden" name="Date" value="sysdate">
						<%=s.getPrice()%>   <input type="hidden" name="code" value="<%=s.getProd_no()%>" >
						</td>
						<td>
						<input type="submit" value="order" class="orderbtn">  <br>
							 <a href="/web/deletecart?code=<%=s.getProd_no()%>"
							class="delbtn">delete</a>
						</td>
					 </form>
					</tr>


					<%
					}
					%>

				</table>

		
		</div>
	</main>
</body>
</html>