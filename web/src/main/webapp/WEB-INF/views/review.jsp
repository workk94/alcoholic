<%@page import="web.model.User"%>
<%@page import="web.review.Paging"%>
<%@page import="web.review.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><link rel="stylesheet" type="text/css" href="/web/css/review.css">
</head>
<body>
<!-- 헤더 부분 시작 -->
<header>
<jsp:include page="../componants/header.jsp"></jsp:include>
</header>
<!-- 헤더 부분  끝-->
    
<!-- 메인 부분 시작 -->
<main>
<div class="container">
 <h1 class="title">REVIEW</h1>
<!-- 검색 부분 추가 -->
        <div class="search">
            <form action="/web/review" method="get" class="search-form">
                <select name="searchType" class="search-select">
                    <option value="item_no">아이템번호</option>
                    <option value="user_id">작성자</option>
                    <option value="product_no">제품번호</option>
                    <option value="rating">평점</option>
                    <!-- 필요에 따라 다른 옵션 추가 -->
                </select>
                <input type="text" name="searchQuery" class="search-input" placeholder="검색어 입력" />
                <button type="submit" class="search-button">검색</button>
            </form>
        </div>
<table>
	<thead>
     <tr>
        <th class="info">리뷰번호</th>
        <th class="info">작성자</th>
        <th class="info">제품번호</th>
        <th class="info">아이템번호</th>
        <th class="info">리뷰내용</th>
        <th class="info">평점</th>
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
        <td><%= review.getUser_id() %></td>
        <td><%= review.getProduct_no() %></td>
        <td><%= review.getItem_no() %></td>
        <td class="review-content">
            <%= review.getContents().length() > 50 ? review.getContents().substring(0, 50) + "..." : review.getContents() %>
        </td>
        <td><%= review.getRating() %></td>
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

<div class="pagination-container">
    <div class="pagination">
        <% Paging paging = (Paging) request.getAttribute("paging"); %>

        <!-- 이전 -->
        <% if (paging.getCurrentGroup() > 1) { %>
            [ <a href="/web/review?p=<%=paging.getGrpStartPage() - 1%>"> 이전 </a> ]
        <% } %>

        <% for (int i = paging.getGrpStartPage(); i <= paging.getGrpEndPage(); i++) { %>
            [ <a href="/web/review?p=<%=i%>"> <%=i%> </a> ]
        <% } %>

        <!-- 다음 -->
        <% if (paging.getGrpEndPage() < paging.getTotalPage()) { %>
            [ <a href="/web/review?p=<%=paging.getGrpEndPage() + 1%>"> 다음 </a> ]
        <% } %>
    </div>
</div>
<%
    User user =(User) session.getAttribute("currentUser");;

    // 로그인 상태일 때만 "NEW REVIEW 작성" 버튼을 보이게 함
    if (user != null) {
%>
    <div class="new_wrap">
        <a class="new" href="/web/addReview?p=1"> NEW REVIEW 작성</a>
    </div>
<%
    }
    
    
%>

<%
    String message = request.getParameter("message");
    if (message != null) {
    %>
        <script>alert("<%= message %>");</script>
    <%
    }
%>

</div>    

</main>

</body>
</html>