<%@page import="web.admin.Product"%>
<%@page import="web.admin.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin_product.css" />
</head>
<body>

	<!-- 헤더 부분 시작 -->
	<jsp:include page="../componants/admin_header.jsp" />
	<!-- 헤더 부분  끝-->

	
	<!-- 메인 부분 시작 -->
	<main>
		<div class="container">
			<h1 class="title">PRODUCT</h1>

			<table>
				<tr>
					<th class="info">No</th>
					<th class="info">카테고리</th>
					<th class="info">이름</th>
					<th class="info">가격</th>
					<th class="add"><a href="/web/admin_product.add">Add +</a></th>
				</tr>
				<%
				ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
				%>
				<%
				for (Product product : list) {
				%>
				<tr class="product_info">
					<th><%=product.getNo()%></th>
					<th><%=product.getCategory()%></th>
					<th><%=product.getName()%></th>
					<th><%=product.getPrice()%></th>
					<th><a class="update"
						href="/web/admin_product.update?no=<%=product.getNo()%>">Update</a>
						/ <a class="delete"
						href="/web/admin_product.delete?no=<%=product.getNo()%>"
						onclick="return deletecheck();">Delete</a></th>

				</tr>
				<%
				}
				%>



			</table>

		</div>

	<%String message = (String) request.getAttribute("message");%>
		<script type="text/javascript">
		    function deletecheck(){
		        return confirm("정말 삭제하시겠습니까?");
		    }
		
		    var message = "<%=message != null ? message : ""%>";
			if (message !== "") {
				alert(message);
			}
		</script>


	</main>
	<!-- 메인 부분 끝 -->
</body>
</html>