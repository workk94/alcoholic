<%@page import="web.review.Review"%>
<%@page import="web.review.ReviewService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/web/css/reivewOne.css">
<style>
    /* 헤더 스타일 */
    header {
        display: flex;
        justify-content: space-between; /* 왼쪽과 오른쪽 정렬 */
        align-items: center; /* 세로 가운데 정렬 */
        padding: 10px 40px; /* 패딩 추가 */
        background-color: #f8f8f8; /* 배경색 설정 */
    }

    /* 검색 바 스타일 */
    #sb-search {
        display: flex; /* flexbox 사용 */
        align-items: center; /* 세로 가운데 정렬 */
    }

    .sb-search-input {
        padding: 8px; /* 패딩 추가 */
        border: 1px solid #ccc; /* 테두리 추가 */
        border-radius: 4px; /* 테두리 둥글게 */
        margin-right: 10px; /* 입력 필드와 아이콘 간 간격 */
    }

    .sb-icon-search {
        cursor: pointer; /* 마우스 커서 변경 */
    }
</style>
</head>
<body>
<!-- 헤더 부분 시작 -->
<header>
<jsp:include page="../componants/header.jsp"></jsp:include>

<!-- 검색 바 추가 -->
    <div id="sb-search" class="sb-search"> 
        <form id="searchBarForm" action="/product/search.html" method="get" target="_self" enctype="multipart/form-data">
            <input id="banner_action" name="banner_action" value="" type="hidden" />
            <input class="sb-search-input" placeholder="검색어를 입력하세요" id="keyword" name="keyword" type="text" />
            <span class="sb-icon-search"> <i class="fa fa-search" aria-hidden="true"></i></span>
        </form>
    </div>

</header>
<!-- 헤더 부분  끝-->
<!-- 메인 부분 시작 -->
<main>
    <% Review updateReview = (Review) request.getAttribute("review"); %>
<div class="container">
<h1 class="title">리뷰 수정 페이지</h1>
<form name="form" action="/web/reviewUpdate" method="post" onsubmit="return updateCheck();">
<div class="info_wrap">
<input type="hidden" name="review_no" value="<%=updateReview.getReview_no() %>"/> 
<p> 사용자 id : <input id="name" name ="name" type="text" value="<%=updateReview.getUser_id() %>" readonly="readonly"> </p>
<p> 제품 번호 : <input id="ssn" name ="ssn" type="text" value="<%=updateReview.getProduct_no() %>" readonly="readonly"></p>
<p> 아이템 번호 : <input id="id" name ="id" type="text" value="<%=updateReview.getItem_no() %>" readonly="readonly"> </p>
<p>평점 : <input type="number" name="rating" id="rating" min="1" max="3" value="<%= updateReview.getRating() %>" /> </p>
</div>

<div class="image">
<label for="contents">내용:</label>
<textarea name="contents" id="contents" rows="4" cols="50"><%= updateReview.getContents() %></textarea>
<p><input type="submit" value="수정 완료" /> </p>
</div>
</div>
<div class="new_wrap"><a class="new" href="/web/review">목록으로 돌아가기</a></div>
</form>
</main>

</body>
</html>