<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<style>
    body {
        background-image: url('https://lh5.googleusercontent.com/proxy/xvtq6_782kBajCBr0GISHpujOb51XLKUeEOJ2lLPKh12-xNBTCtsoHT14NQcaH9l4JhatcXEMBkqgUeCWhb3XhdLnD1BiNzQ_LVydwg=w3840-h2160-p-k-no-nd-mv');
        background-position: center center;
        background-repeat: no-repeat;
        background-size: cover;
        margin: 0;
        font-family: Arial, sans-serif;
    }

    table {
        background-color: rgba(255, 255, 255, 0.8); /* 테이블 배경을 반투명하게 설정 */
        padding: 20px;
        border-radius: 10px;
    }

    td {
        padding: 10px;
    }

    h1 {
        text-align: center;
        color: white;
    }
</style>
</head>
<body>

<h1>MyPage</h1>

<table align="center">
    <tr>
        <td><a href="/web/login">로그아웃</a></td>
    </tr>
    <tr>
        <td><a href="/web/editPersonalInfo">개인정보수정</a></td>
    </tr>
    <tr>
        <td><a href="/web/cartlist">장바구니목록</a></td>
    </tr>
    <tr>
        <td><a href="/web/review">리뷰관리</a></td>
    </tr>
</table>

</body>
</html>
