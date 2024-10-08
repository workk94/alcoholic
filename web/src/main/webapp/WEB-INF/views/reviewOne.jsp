<%@page import="web.review.Review"%>
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

<h2> 리뷰 페이지 </h2>

<table>
<tr>
	<th>리뷰번호</th>
	<th>제품번호</th>
	<th>아이템 번호</th>
	<th>리뷰 내용</th>
	<th> 평점 </th>
	<th>작성자</th>
	<th>작성일</th>
</tr>

<% ArrayList<Review> list = (ArrayList<Review>) request.getAttribute("reviewOne");
for (Review review : list) {
 %>
<tr>
<td> <input type = "text" id ="product_no"  value=" <%=review.getProduct_no() %>"> </td>
<td>  </td>
<td>  </td>

</tr>
<%} %>

</table>


</body>
</html>