<%@page import="web.admin.PageHandler"%>
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
    <jsp:include page="../componants/admin_header.jsp" />
    <!-- 헤더 부분  끝-->


    <!-- 메인 부분 시작 -->
    <%-- <c:if test="${!empty sessionScope.currentUser}"> --%>
    
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
			<br>
			
			<div class = "page"><%PageHandler handler = (PageHandler)request.getAttribute("handler"); %>
		
			<!-- 이전 -->
		
			<%if(handler.getCurrentGrp() > 1){ %>
			[<a href="/web/admin?p=<%=handler.getGrpStartPage()-1 %> "> 이전 </a> ]
			
			<%} %>
		
		
			<%for (int i = handler.getGrpStartPage(); i <= handler.getGrpEndPage(); i++) { %>
		    <% if (i == handler.getCurrentPage()) { %>
		        [<a href="/web/admin?p=<%= i %>" class = "current"> <%= i %> </a>]
		    <% } else { %>
		        [<a href="/web/admin?p=<%= i %>"> <%= i %> </a>]
		    	<% } %>
			<% } %>

			
			
		
			<!-- 다음 -->
		
			<% if(handler.getTotalPage() > handler.getGrpEndPage()){ %>
				[<a href="/web/admin?p=<%=handler.getGrpEndPage()+1 %>">다음</a> ]
			<%} %>
			</div>
       
       <%String message = (String) request.getAttribute("message");%> </div>
       <script type="text/javascript">
       
       function deleteCheck(){
    	          return confirm("정말 삭제하시겠습니까?");
    	   }
       var message = "<%=message != null ? message : ""%>";
		if (message !== "") {
			alert(message);
		}
       </script>

    </main>
    
    
    
    <%-- </c:if> --%>
    <!-- 메인 부분 끝 -->
</body>
</html>