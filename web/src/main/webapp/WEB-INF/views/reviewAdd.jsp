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
            <h1 class="title">새 리뷰 작성</h1>
<form name="form" action="/web/addReview" method="post" onsubmit="return signUpCheck()">
    <table>
        <tr >
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
 <div class="new_wrap"><a class="new" href="review">목록으로 돌아가기</a></div>

</div>
</main>
</body>
</html>