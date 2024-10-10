<%@page import="web.review.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
}

.container {
    max-width: 800px;
    margin: auto;
    background: white;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
    color: #333;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
}

th, td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: left;
}

th {
    background-color: #f2f2f2;
}


.new-post {
    text-align: right;
    margin: 20px 0;
}
    </style>
</head>
<body>
<div class="container">
<h2> 리뷰 페이지 </h2>
<%
// 단일 리뷰 객체 가져오기
Review selectedReview = (Review) request.getAttribute("reviewOne");

if (selectedReview != null) {
%>
<table>
    <tr><th>리뷰 번호</th><td><%=selectedReview.getReview_no() %></td></tr>
        <tr><th>작성자</th><td><%=selectedReview.getUser_id() %></td></tr>
    <tr><th>제품 번호</th><td><%=selectedReview.getProduct_no() %></td></tr>
    <tr><th>아이템 번호</th><td><%=selectedReview.getItem_no() %></td></tr>
    <tr><th>내용</th><td><%=selectedReview.getContents() %></td></tr>
    <tr><th>평점</th><td><%=selectedReview.getRating() %></td></tr>
    <tr><th>작성 시간</th><td><%=selectedReview.getCreated_at() %></td></tr>
</table>


<!-- 수정 버튼 추가 -->
<form action="/web/reviewUpdate" method="get">
    <input type="hidden" name="review_no" value="<%=selectedReview.getReview_no() %>">
    <input type="submit" value="수정">
</form>
<!--  <a href="/web/delete?review_no=<%=selectedReview.getReview_no() %>">삭제</a> -->  
<form action="/web/delete" method="get">
    <input type="hidden" name="review_no" value="<%=selectedReview.getReview_no() %>">
    <input type="submit" value="삭제">
</form>
<% 
} else {
    out.println("<p>해당 리뷰를 찾을 수 없습니다.</p>");
}
%>
<div class="new-post">
<a href="review">목록으로 돌아가기</a>
</div>
</div>

</body>
</html>