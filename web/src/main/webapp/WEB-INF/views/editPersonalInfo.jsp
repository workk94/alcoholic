<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Personal Info</title>
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
        margin-bottom: 50px; /* 제목과 폼 사이에 간격 추가 */
    }

    form {
        background-color: white;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 30px;
        width: 400px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table td {
        padding: 15px;
        font-size: 18px;
    }

    table input[type="text"], table input[type="password"] {
        width: 100%; 
        padding: 10px;
        font-size: 18px;
        border: 1px solid #ddd;
        border-radius: 5px;
        background-color: rgba(252, 245, 223, 0.95);
        box-sizing: border-box; 
    }

    table input:focus {
        outline: none;
        border-color: #007bff;
    }

    table input[type="submit"] {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
        margin-top: 20px;
        box-sizing: border-box;
    }

    table input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
<script>
    function showSuccessMessage() {
        alert("수정 완료");
    }
</script>
</head>
<body>
    <!--  header -->
    <jsp:include page="../componants/header.jsp" />

<h1>개인정보 수정</h1>

<form action="/web/editPersonalInfo" method="post" onsubmit="showSuccessMessage()">
    <table>
        <tr>
            <td>비밀번호</td>
            <td>
                <input type="password" id="pw" name="pw" value="${user.pw}">
                <button type="button" onclick="togglePassword()">보기</button>
            </td>
        </tr>
        <tr>
            <td>전화번호</td>
             <td>
                <input type="text" name="phone" value="${user.phone}" 
                    pattern="\d{3}-\d{4}-\d{4}" 
                    title="전화번호는 000-0000-0000 형식으로 입력해주세요."
                    required>
            </td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr" value="${user.addr}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="수정"></td>
        </tr>
    </table>
</form>

<script>
    function togglePassword() {
        var pwField = document.getElementById("pw");
        if (pwField.type === "password") {
            pwField.type = "text";
        } else {
            pwField.type = "password";
        }
    }
</script>


</body>
</html>
