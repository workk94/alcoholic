<%@page import="web.review.Review"%>
<%@page import="web.review.ReviewService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/web/css/admin_product_update.css">
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
  <h1 class="title">리뷰 수정 페이지</h1>
	<form name="form" action="/web/reviewUpdate" method="post">
    <% Review updateReview = (Review) request.getAttribute("review"); %>
    <input type="hidden" name="review_no" value="<%=updateReview.getReview_no() %>"/> 
  <div class="info_wrap">

  
  

  
    <table>
        <tr>
            <td><label for="contents">내용:</label></td>
            <td><textarea name="contents" id="contents" rows="4" cols="50"><%= updateReview.getContents() %></textarea></td>
        </tr>
        <tr>
            <td><label for="rating">평점:</label></td>
            <td>
                <input type="number" name="rating" id="rating" min="1" max="5" value="<%= updateReview.getRating() %>" />
            </td>
        </tr>
       
       
       
        <tr>
            <td colspan="2"><input type="submit" value="수정 완료" /></td>
        </tr>
    </table>
</form>
<div class="new_wrap"><a class="new" href="/web/review">목록으로 돌아가기</a></div>
</div>
</main>
</body>
</html>