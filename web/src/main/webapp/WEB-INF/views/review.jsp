<%@page import="web.review.Paging"%>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
 <style>
        /* 검색 바 스타일 */
        #sb-search {
            position: fixed; /* 고정 위치 */
            top: 20px; /* 화면 상단에서의 위치 */
            right: 40px; /* 화면 오른쪽에서의 위치 */
            z-index: 1000; /* 다른 요소 위에 나타나도록 설정 */
        }
        .sb-search-input {
            display: none; /* 기본적으로 숨김 */
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-right: 10px;
            transition: border-color 0.3s; /* 부드러운 전환 효과 */
        }
        .underline {
            width: 100%;
            height: 2px;
            background-color: #ccc;
            position: absolute;
            bottom: -5px; /* 버튼 아래쪽 위치 */
            left: 0;
            display: none; /* 기본적으로 숨김 */
        }
        .active .sb-search-input {
            display: inline-block; /* 클릭 시 입력 필드 표시 */
        }
        .active .underline {
            display: block; /* 클릭 시 밑줄 표시 */
        }
    </style>
</head>
<body>
<!-- 헤더 부분 시작 -->
<header>
<jsp:include page="../componants/header.jsp"></jsp:include>
</header>
<!-- 헤더 부분  끝-->
    
<!-- 메인 부분 시작 -->
<main>
<div id="sb-search" class="sb-search"> 
        <span class="sb-icon-search" onclick="toggleSearch()">
            <i class="fas fa-search" aria-hidden="true"></i>
        </span>
        <input class="sb-search-input" placeholder="검색어를 입력하세요" id="keyword" name="keyword" type="text" />
        <div class="underline"></div>
    </div>

    <script>
        function toggleSearch() {
            const searchDiv = document.getElementById('sb-search');
            searchDiv.classList.toggle('active'); // 클래스 추가/제거
            const input = document.getElementById('keyword');
            if (input.style.display === "inline-block") {
                input.style.display = "none"; // 숨기기
                input.value = ""; // 입력값 초기화
            } else {
                input.style.display = "inline-block"; // 보이기
                input.focus(); // 포커스 주기
            }
        }
    </script>


<div class="container">
 <h1 class="title">REVIEW</h1>
<!-- 검색 부분 추가 -->
        <div class="search">
            <form action="/web/review" method="get">
                <select name="searchType">
                    <option value="item_no">아이템번호</option>
                    <option value="user_id">작성자</option>
                    <option value="product_no">제품번호</option>
                    <option value="rating">평점</option>
                    <!-- 필요에 따라 다른 옵션 추가 -->
                </select>
                <input type="text" name="searchQuery" placeholder="검색어 입력" />
                <button type="submit">검색</button>
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
            <td><%= review.getContents() %></td>
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
 //if (paging.getCurrentGroup() < paging.getTotalPage()) { 

//Paging 클래스의 calcPage() 메서드에서 totalPage를 기준으로 "다음" 링크의 유효성을 확인할 수 있도록 조건을 추가해야 합니다.
//예를 들어, 현재 그룹의 마지막 페이지(grpEndPage)가 totalPage와 같거나 클 경우에만 "다음" 링크를 보여주는 방식으로 수정할 수 있습니다.

if (paging.getGrpEndPage() < paging.getTotalPage()) {
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
</div>    
</main>

</body>
</html>