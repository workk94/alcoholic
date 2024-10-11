<%@page import="web.review.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/web/css/review.css">
</head>

<body>
<!-- 헤더 부분 시작 -->
<header>
<div class="top">
<div class="logo">
	<a href="index.html">BOTTLE</a>
</div>
<div class="menu">
	<ul>
		<li><a class="main_menu" href="">CATEGORY</a>
			<ul>
				<li><a href="#">WHISKY</a></li>
				<li><a href="#">WINE</a></li>
				<li><a href="#">SUBMENU 3</a></li>
				<li><a href="#">SUBMENU 3</a></li>
				<li><a href="#">SUBMENU 3</a></li>
			</ul>
		</li>
		<li><a class="main_menu" href="">WHISKEY</a>
			<ul>
				<li><a href="#">SUBMENU 4</a></li>
				<li><a href="#">SUBMENU 5</a></li>
				<li><a href="#">SUBMENU 6</a></li>
			</ul>
		</li>
		<li><a class="main_menu" href="">REVIEW</a>
			<ul>
				<li><a href="#">SUBMENU 7</a></li>
				<li><a href="#">SUBMENU 8</a></li>
				<li><a href="#">SUBMENU 9</a></li>
			</ul>
		</li>
		<li><a class="main_menu" href="">MYPAGE</a>
			<ul>
				<li><a href="#">SUBMENU 10</a></li>
				<li><a href="#">SUBMENU 11</a></li>
				<li><a href="#">SUBMENU 12</a></li>
			</ul>
		</li>
	</ul>
</div>
		</div>
		<!-- 우측 상단 로그인&회원가입 -->
		<div class="login">
			<p>백바울 님 , 안녕하세요.</p>
			<a class="log_btn" href="login.html">LOGIN(LOGOUT)</a> / <a
				class="join_btn" href="joinus.html">JOIN US</a>
		</div>
	</header>
	<!-- 헤더 부분  끝-->
<!-- 메인 부분 시작 -->
    <main>
        <div class="container">
            <h1 class="title"> 리뷰 페이지 </h1>
<% Review reviewOne = (Review) request.getAttribute("reviewOne"); %>
<% if (reviewOne != null) { %>
<table>
    <tr><th>리뷰 번호</th><td><%=reviewOne.getReview_no() %></td></tr>
    <tr><th>작성자</th><td><%=reviewOne.getUser_id() %></td></tr>
    <tr><th>제품 번호</th><td><%=reviewOne.getProduct_no() %></td></tr>
    <tr><th>아이템 번호</th><td><%=reviewOne.getItem_no() %></td></tr>
    <tr><th>내용</th><td><%=reviewOne.getContents() %></td></tr>
    <tr><th>평점</th><td><%=reviewOne.getRating() %></td></tr>
    <tr><th>작성 시간</th><td><%=reviewOne.getCreated_at() %></td></tr>
</table>

<!-- 수정 버튼 추가 -->
<form action="/web/reviewUpdate" method="get">
    <input type="hidden" name="review_no" value="<%=reviewOne.getReview_no() %>">
    <input type="submit" value="수정">
</form>
<form action="/web/delete" method="get">
    <input type="hidden" name="review_no" value="<%=reviewOne.getReview_no() %>">
    <input type="submit" value="삭제">
</form>
<% 
} else {
    out.println("<p>해당 리뷰를 찾을 수 없습니다.</p>");
}
%>
<div class="new_wrap"><a class="new" href="review">목록으로 돌아가기</a></div>
</div>
</main>
</body>
</html>