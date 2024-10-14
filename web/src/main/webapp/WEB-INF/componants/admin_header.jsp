<%@page import="web.login.AdminDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin_header.css" />

<% AdminDTO admin =(AdminDTO)session.getAttribute("currentAdmin"); %>
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
                            <li><a href="/web/admin">ADMIN</a></li>
                                    <li><a href="/web/admin_product">PRODUCT</a></li>
                                    <li><a href="/web/admin_order">ORDER</a></li>
                                    <li><a href="/web/admin_sales">SALES</a></li>
                        </ul>
                </ul>
            </div>
        </div>
        <!-- 우측 상단 로그인&회원가입 -->
        <div class="login">
            <p><%=admin.getName() %> 님 , 안녕하세요.</p>
            <a class="log_btn">LOGOUT</a>
        </div>
    </header>
 