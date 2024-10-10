<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script type="text/javascript">
      $(document).ready(() => {
        alert('hi');
      });
    </script>
  </head>
  <body>
    <form
      class="regForm"
      action="${pageContext.request.contextPath}/register"
      method="post"
    >
      <table>
        <tr>
          <td>아이디</td>
          <td>
            <input type="text" name="id" id="id" /><button>중복체크</button>
          </td>
        </tr>
        <tr>
          <td>패스워드</td>
          <td><input type="text" name="pw" /></td>
        </tr>
        <tr>
          <td>패스워드 확인</td>
          <td><input type="text" name="pw2" /></td>
        </tr>
        <tr>
          <td>이름</td>
          <td><input type="text" name="name" /></td>
        </tr>
        <tr>
          <td>주민번호</td>
          <td><input type="text" name="ssn" /></td>
        </tr>
        <tr>
          <td>전화번호</td>
          <td><input type="text" name="phone" /></td>
        </tr>
        <tr>
          <td>주소</td>
          <td><input type="text" name="addr" /></td>
        </tr>
      </table>
      <button class="checkLogin">회원가입</button>
    </form>
  </body>
</html>
