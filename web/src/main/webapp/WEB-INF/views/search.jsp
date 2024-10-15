<%@page import="web.pages.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="../componants/header.jsp"></jsp:include>

<% ArrayList<ProductDTO> list = (ArrayList<ProductDTO>)request.getAttribute("searchList"); %>


<c:choose>
<c:when test="${!empty list }">
<ul>
<% for(ProductDTO p : list){ %>
<li><%= p.getPname() %></li>
<li><%= p.getCategory()%></li>
<%} %>
</ul>
</c:when>
<c:otherwise>
검색 결과가 없습니다
</c:otherwise>
</c:choose>

</body>
</html>