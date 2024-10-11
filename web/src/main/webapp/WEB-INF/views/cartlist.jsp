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
	text-align: center;
}
</style>
</head>
<body>


	<form action="/web/updatecart" method="post">

		<%
		ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cartlist");
		%>

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
				<td><%=s.getImg_url()%></td>
				<td><%=s.getProd_no()%></td>
				<td><%=s.getName()%></td>
				<td><input type="number" value="1" min="0"
					name="quantity_<%=s.getProd_no()%>"></td>
				<td><%=s.getPrice()%></td>
				<td><input type="submit" value="구매하기"> <br> <a
					href="/web/deletecart?code=<%=s.getProd_no()%>">삭제</a></td>
			</tr>


			<%
			}
			%>

		</table>

		<%
		int result = 0;

		for (Product s : list) {

			result += s.getPrice() * s.getQuantity();
		%>

		<%
		}
		%>

		<div>
			총 합계 :
			<%=result%></div>
	</form>
	<script>
function setQuantityToZero() {
    // 모든 수량 입력 필드를 0으로 설정
    const quantityInputs = document.querySelectorAll('input[type="number"]');
    quantityInputs.forEach(input => {
        input.value = 0; // 수량을 0으로 설정
    });
}
</script>

</body>
</html>