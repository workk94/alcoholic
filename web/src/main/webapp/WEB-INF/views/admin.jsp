<%@page import="web.admin.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" />
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
                            <li><a href="/web/admin">ADMIN</a></li>
                                    <li><a href="/web/admin_product">PRODUCT</a></li>
                                    <li><a href="/web/admin_order">ORDER</a></li>
                        </ul>
                </ul>
            </div>
        </div>
        <!-- 우측 상단 로그인&회원가입 -->
        <div class="login">
            <p>system 님 , 안녕하세요.</p>
            <a class="log_btn">LOGIN(LOGOUT)</a>
        </div>
    </header>
    <!-- 헤더 부분  끝-->


    <!-- 메인 부분 시작 -->
    <c:if test="${!empty sessionScope.currentUser}">
    
    <main>
        <div class="container">
            <h1 class="title">ADMIN</h1>

            <table>
                <tr>
                    <th class="info">이름</th>
                    <th class="info">아이디</th>
                    <th class="info">비밀번호</th>
                    <th class="info">전화번호</th>
                    <th class="register"><a href="#">Register +</a></th>
                </tr>
				<%ArrayList<Admin> list = (ArrayList<Admin>)request.getAttribute("list"); %>
                <%for(Admin admin : list) { %>
                <tr class = "admin_info">
                    <th><%=admin.getName() %></th>
                    <th><%=admin.getId() %></th>
                    <th><%=admin.getPw() %></th>
                    <th><%=admin.getPhone() %></th>
                    <th><a class="update" href="/web/admin.update?id=<%=admin.getId()%>">Update</a> / <a class="delete"
                     href="/web/admin.delete?id=<%=admin.getId() %>" onclick = "return deleteCheck();")>Delete</a></th>
                     
                </tr>
                <%} %>


                
            </table>

        </div>
       <script type="text/javascript">
       
       function deleteCheck(){
    	          return confirm("정말 삭제하시겠습니까?");
    	   }
       
       </script>

    </main>
    
    
    
    </c:if>
    <!-- 메인 부분 끝 -->
</body>
</html>