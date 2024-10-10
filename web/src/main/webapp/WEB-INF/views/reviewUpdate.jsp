<%@page import="web.review.Review"%>
<%@page import="web.review.ReviewService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
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
<h2>리뷰 수정 페이지</h2>
<form name="form" action="/web/reviewUpdate" method="post">
    <% Review updateReview = (Review) request.getAttribute("review"); %>
    
    <input type="hidden" name="review_no" value="<%=updateReview.getReview_no() %>"/> 

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
<div class="new-post">
<a href="/web/review">목록으로 돌아가기</a>
</div>

</body>
</html>