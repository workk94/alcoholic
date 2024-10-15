<%@page import="web.review.Review"%>
<%@page import="web.review.ReviewService"%>
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
<jsp:include page="../componants/header.jsp"></jsp:include>
</header>
<!-- 헤더 부분  끝-->
<!-- 메인 부분 시작 -->
<main>
    <% Review updateReview = (Review) request.getAttribute("review"); %>
    <div class="container">
        <h1 class="title">리뷰 수정 페이지</h1>
        <form name="form" action="/web/reviewUpdate" method="post" onsubmit="return updateCheck();">
            <div class="info_wrap">
                <input type="hidden" name="review_no" value="<%= updateReview.getReview_no() %>"/> 
                <p> 사용자 ID : <input id="name" name="name" type="text" class="search-input" value="<%= updateReview.getUser_id() %>" readonly="readonly"> </p>
                <p> 제품 번호 : <input id="ssn" name="ssn" type="text" class="search-input" value="<%= updateReview.getProduct_no() %>" readonly="readonly"></p>
                <p> 아이템 번호 : <input id="id" name="id" type="text" class="search-input" value="<%= updateReview.getItem_no() %>" readonly="readonly"> </p>
                <p>평점 : <input type="number" name="rating" id="rating" min="1" max="3" class="search-input" value="<%= updateReview.getRating() %>" /> </p>
            </div>

            <div class="image">
                <label for="contents">내용:</label>
                <textarea name="contents" id="contents" rows="4" cols="50" class="search-input"><%= updateReview.getContents() %></textarea>
                <p><input type="submit" value="수정 완료" /> </p>
            </div>
        </form>
         <div class="new_wrap"><a class="new" href="/web/review">목록으로 돌아가기</a></div>
    </div>
   
</main>

</body>
</html>
