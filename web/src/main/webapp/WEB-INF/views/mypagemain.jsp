<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        background-color: rgba(252, 245, 223, 0.95);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        flex-direction: column;
    }

    h1 {
        text-align: center;
        font-size: 40px;
        margin-bottom: 50px; /* 제목과 테이블 사이에 간격 추가 */
    }

    table {
        background-color: white;
        border-collapse: collapse;
        width: 400px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 부드러운 그림자 추가 */
        border-radius: 10px;
        overflow: hidden; /* 둥근 테두리가 적용되도록 설정 */
        margin-bottom: 50px; /* 테이블 하단 여백 추가 */
    }

    table td {
        padding: 30px;
        text-align: center;
        border-bottom: 1px solid #ddd;
        font-size: 22px;
    }

    table td:last-child {
        border-bottom: none; /* 마지막 행은 테두리 제거 */
    }

    table a {
        text-decoration: none;
        color: #333;
        font-weight: bold;
        transition: color 0.3s ease;
    }

    table a:hover {
        color: #007bff; /* 링크에 마우스를 올렸을 때 색상 변경 */
    }

    /* 테이블을 감싸는 부모 요소를 화면 중앙에 배치 */
    .table-container {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }
</style>
</head>
<body>

<h1>MyPage</h1>

<div class="table-container">
    <table>
        <tr>
            <td><a href="/web/login">로그아웃</a></td>
        </tr>
        <tr>
            <td><a href="/web/editPersonalInfo">개인정보수정</a></td>
        </tr>
        <tr>
            <td><a href="/web/review">리뷰관리</a></td>
        </tr>
    </table>
</div>

</body>
</html>
