<%@page import="web.review.Review"%>
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
}
</style>
</head>
<body>
<h1>게시물 목록</h1>
<table>
	<tr>
	<th>리뷰번호</th>
	<th>제품번호</th>
	<th>아이템 번호</th>
	<th>리뷰 내용</th>
	<th> 평점 </th>
	<th>작성자</th>
	<th>작성일</th>
	<td> <a href = "/web.review/reviewOne"> no.1 </a> </td>
	</tr>
<% ArrayList<Review> list = (ArrayList<Review>) request.getAttribute("allList");
for (Review review : list) {
 %>
<tr> 
<td><%=review.getReview_no() %> </td>
<td><%=review.getProduct_no() %> </td>
<td> <%=review.getItem_no() %> </td>
<td> <%=review.getContents() %> </td>
<td> <%=review.getRating() %> </td>
<td> <%=review.getUser_id() %></td>
<td> <%=review.getCreated_at() %></td>

</tr>
 <%} %>

 </table>
</body>
</html>