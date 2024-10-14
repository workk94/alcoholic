<%@page import="web.admin.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
   <link rel="stylesheet" href="css/admin_product_update.css">
<script src="https://kit.fontawesome.com/4ec79785b5.js" crossorigin="anonymous"></script>
   
</head>


<body>
 
     <!-- 헤더 부분 시작 -->
    <jsp:include page="../componants/admin_header.jsp" />
    <!-- 헤더 부분  끝-->
    

	
    <!-- 메인 부분 시작 -->
    <main>
        <div class="container">
            <h1 class="title">UPDATE</h1>
            <div class="wrap">
                <form name="frm" action="/web/admin_product.update" method="post" onsubmit="return updateCheck();">
                    <!-- <%Product product = (Product) request.getAttribute("product"); %> -->
                    <div class="info_wrap">
                    <p>Category : <input id="category" name="category" type="text" value="<%=product.getCategory()%>" readonly="readonly"> </p>
                        <p>No : <input id="no" name="no" type="text" value="<%=product.getNo() %>" readonly="readonly"> </p>
                        <p>이름 : <input id="name" name="name" type="text" value="<%=product.getName() %>"></p>
                        <p>가격 : <input id="price" name="price" type="text" value="<%=product.getPrice() %>"> </p>
                        <p>imgUrl : <input id="imgUrl" name="imgUrl" type="text" value="<%=product.getImgUrl() %>"> <a onclick = "imgCheck();"><i class="fa-solid fa-arrows-rotate"></i></a></p>  
                    </div>
                    <button>수정하기</button>
                </form>
                <div class="image">
                    <img id="productImg" src="<%=product.getImgUrl() %>">
                </div>
            </div>
            
        </div>

        
        <script type="text/javascript">
        
        function updateCheck(){
     	          return confirm("정말 수정하시겠습니까?");
     	   }
        function imgCheck(){
        	let imgUrl = document.querySelector("#imgUrl").value;

            document.querySelector("#productImg").src = imgUrl;
        }
        
        </script>
           
    </main>
    <!-- 메인 부분 끝 -->
</body>
</html>