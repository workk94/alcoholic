<%@page import="web.admin.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
   <link rel="stylesheet" href="css/admin_update.css">

   
</head>


<body>
   <!-- 헤더 부분 시작 -->
    <jsp:include page="../componants/admin_header.jsp" />
    <!-- 헤더 부분  끝-->

	
    <!-- 메인 부분 시작 -->
    <main>
        <div class="container">
            <h1 class="title">UPDATE</h1>
            <div class="input_wrap">
           <form name="frm" action="/web/admin.update" method="post" onsubmit="return validateForm()">
            <%Admin admin =(Admin) request.getAttribute("admin"); %>
                <p>이름 : <input id="name" name ="name" type="text" value="<%=admin.getName() %>" readonly="readonly"> </p>
                <p>주민등록번호 : <input id="ssn" name ="ssn" type="text" value="<%=admin.getSsn() %>" readonly="readonly"></p>
                <p>아이디 : <input id="id" name ="id" type="text" value="<%=admin.getId() %>" readonly="readonly"> </p>
                <p>비밀번호 : <input id="pw" name="pw" type="text" value="<%=admin.getPw() %>"></p>
                <p>비밀번호 확인 : <input id="pw2" name="pw2" type="text"  value="<%=admin.getPw() %>"></p> <div class="pwcheck">*비밀번호가 일치하지 않습니다.</div>
                <p>전화번호 : <input name="phone" type="text"  value="<%=admin.getPhone() %>"></p>
                <p>주소 : <input name="address" type="text"  value="<%=admin.getAddress() %>"></p>
              	<button>수정하기</button>
              	</form>
            </div>
        </div>

        <script>
            let pw = document.querySelector("#pw"); 
            let pw2 = document.querySelector("#pw2"); 
            let pwcheck = document.querySelector(".pwcheck");
        
        
            function match(pw,pw2){
                return pw===pw2;
            }

            function validatePassword() {
                pwcheck.style.display = "block";
                if (pw.value === pw2.value) {
                    pwcheck.textContent = "*비밀번호가 일치합니다.";
                    pwcheck.style.color = "green";
                    return true;
                } else {
                    pwcheck.textContent = "*비밀번호가 일치하지 않습니다.";
                    pwcheck.style.color = "red";
                    return false;
                }
            }

            
            function validateForm() {
                if (!validatePassword()) {
                    alert("비밀번호가 일치하지 않습니다.");
                    return false; 
                }
                return confirm("정말 수정하시겠습니까?")
            }



            pw.addEventListener("input", validatePassword);
            pw2.addEventListener("input", validatePassword);
           </script>
    </main>
    <!-- 메인 부분 끝 -->
</body>
</html>