<%@page import="web.admin.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
   <link rel="stylesheet" href="css/update.css">
</head>

<body>
    <!-- 헤더 부분 시작 -->
    <header>
        <div class="top">
            <div class="logo">
                <a href="">SYSTEM</a>
            </div>

            <div class="menu">
                <ul>
                    <li>
                        <a class="main_menu" href="">SYSTEM</a>
                        <ul>
                            <li><a href="admin.html">ADMIN</a></li>
                            <li><a href="#">ITEM</a></li>
                            <li><a href="#">SALES</a></li>
                        </ul>
                </ul>
            </div>
        </div>
        <!-- 우측 상단 로그인&회원가입 -->
        <div class="login">
            <p>system 님 , 안녕하세요.</p>
            <a class="log_btn" href="login.html">LOGIN(LOGOUT)</a> / <a class="join_btn" href="joinus.html">JOIN US</a>
        </div>
    </header>
    <!-- 헤더 부분  -->

	
    <!-- 메인 부분 시작 -->
    <main>
        <div class="container">
            <h1 class="title">UPDATE</h1>
            <div class="input_wrap">
            <%Admin admin =(Admin) request.getAttribute("admin"); %>
                <p>이름 : <input name ="id" type="text" value="<%=admin.getName() %>" readonly="readonly"> </p>
                <p>주민등록번호 : <input name ="id" type="text" value="<%=admin.getSsn() %>" readonly="readonly"></p>
                <p>아이디 : <input name ="id" type="text" value="<%=admin.getId() %>" readonly="readonly"> </p>
                <p>비밀번호 : <input name="pw" type="text" value="<%=admin.getPw() %>"></p>
                <p>비밀번호 확인 : <input name="pw2" type="text"  value="<%=admin.getPw() %>"></p>
                <p>전화번호 : <input name="phone" type="text"  value="<%=admin.getPhone() %>"></p>
                <p>주소 : <input name="address" type="text"  value="<%=admin.getAddress() %>"></p>
                <a href="">수정하기</a>
            </div>
        </div>
    </main>
    <!-- 메인 부분 끝 -->
</body>
</html>