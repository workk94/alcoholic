<%@page import="web.login.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
    <c:when test="${empty sessionScope.currentUser}">
        <a href="${pageContext.request.contextPath}/login">로그인</a>
        <a href="${pageContext.request.contextPath}/register">회원가입</a>
    </c:when>
    <c:otherwise>
        ${sessionScope.currentUser.name}님 안녕하세요
        <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
    </c:otherwise>
</c:choose>
</body>
</html>