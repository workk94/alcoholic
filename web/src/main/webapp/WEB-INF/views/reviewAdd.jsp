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
<div class="container">
<h1>새 리뷰 작성</h1>
<form name="form" action="/web/addReview" method="post" onsubmit="return signUpCheck()">
    <table>
        <tr>
            <td><label for="user_id">작성자:</label></td>
            <td><input type="text" name="user_id" required></td>
        </tr>
        <tr>
            <td><label for="product_no">제품 번호:</label></td>
            <td><input type="text" name="product_no" required></td>
        </tr>
        <tr>
            <td><label for="item_no">아이템 번호:</label></td>
            <td><input type="text" name="item_no" required></td>
        </tr>
        <tr>
            <td><label for="contents">내용:</label></td>
            <td><textarea name="contents" required></textarea></td>
        </tr>
        <tr>
            <td><label for="rating">평점:</label></td>
            <td><input type="text" name="rating" placeholder="1~3" required></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">리뷰 추가</button></td>
        </tr>
    </table>
</form>
 <div class="new-post">
 <a href="review">목록으로 돌아가기</a>
</div>

</div>
</body>
</html>