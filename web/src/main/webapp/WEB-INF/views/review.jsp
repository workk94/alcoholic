<%-- <%@page import="web.review.Paging"%> --%>
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
            <h1 class="title">REVIEW</h1>
</div>

            <table>
            <thead>
                <tr>
                    <th class="info">리뷰번호</th>
                    <th class="info">제품번호</th>
                    <th class="info">아이템번호</th>
                    <th class="info">리뷰내용</th>
                    <th class="info">평점</th>
                    <th class="info">작성자</th>
                    <th class="info">작성일</th>
                </tr>
                </thead>

                  <!-- 리뷰 추가 반복 부분 -->
                    <tbody>
               
        <% 
        ArrayList<Review> list = (ArrayList<Review>) request.getAttribute("allList");
        if (list != null && !list.isEmpty()) {
            for (Review review : list) {
                if (review != null) { // null 체크
        %>
   <tr class="review_info">
            <td><a href="/web/reviewOne?review_no=<%= review.getReview_no() %>"><%= review.getReview_no() %></a></td>
            <td><%= review.getProduct_no() %></td>
            <td><%= review.getItem_no() %></td>
            <td><%= review.getContents() %></td>
            <td><%= review.getRating() %></td>
            <td><%= review.getUser_id() %></td>
            <td><%= review.getCreated_at() %></td>
        </tr>
        <% 
                }
            }
        } else { // 리스트가 비어있을 때 처리
        %>
        <tr>
            <td colspan="7" style="text-align: center;">등록된 리뷰가 없습니다.</td>
        </tr>
        <% 
        } 
        %>
    </tbody>
</table>

<div class="pagination">
 <% Paging paging =(Paging) request.getAttribute("paging"); %>

<!--  이전  -->
<% if( paging.getCurrentGroup() >1) {%>
 	[ <a href="/web/review?p=<%=paging.getGrpStartPage()-1%>"> 이전 </a> ]
 <%} %>


<% for(int i = paging.getGrpStartPage(); i<=paging.getGrpEndPage(); i++){	%>
[  <a href="/web/review?p=<%=i%>"> <%=i %></a> ]
<% } %>


 <!-- 다음 -->
 <%
if (paging.getCurrentGroup() < paging.getTotalPage()) { 
%>
    [ <a href="/web/review?p=<%=paging.getGrpEndPage() + 1%>"> 다음 </a> ]
<% 
} 
%>
<div class="new_wrap"><a class="new" href="/web/addReview?p=1">새 글 작성</a></div>
</div>
<%
    String message = request.getParameter("message");
    if (message != null) {
    %>
        <script>alert("<%= message %>");</script>
    <%
    }
    %>
</main>

</body>
</html>