<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정</title>
</head>
<body>

<h1>개인정보 수정</h1>

<form action="/web/editPersonalInfo" method="post">
    <table>

        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pw" value="${user.pw}"></td>
        </tr>
 
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" value="${user.phone}"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr" value="${user.addr}">
               <input type="text" name="id" value="${user.id}">
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="정보 수정"></td>
        </tr>
    </table>
</form>

</body>
</html>
