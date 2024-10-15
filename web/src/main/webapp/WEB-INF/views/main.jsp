<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>

    <style>
         body {
            margin: 0;
            padding: 0;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            background-color: rgba(252, 245, 223, 0.95);
        }

        /* 메인 부분 시작 */
        main {
            min-height: 315px;
            padding: 0 190px 0 190px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .container {
            padding-top: 20px;
            height: 100%;
            width: 100%;
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }

        .item {
            width: 300px;
            height: 550px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .item:hover {
            border: 1px solid rgb(128, 128, 128);
        }

        .item_img {
            width: 250px;
            height: 350px;
        }

        .brand_name {
            font-size: 15px;
            width: 250px;
            color: rgb(128, 128, 128);
        }

        .item_name {
            font-size: 25px;
            width: 250px;
            font-weight: 500;
            margin: 5px 0;
        }

        .price {
            font-size: 18px;
            font-weight: 700;
            width: 250px;
            margin: 5px 0;
        }

        .cart_add {
            border: 1px solid black;
            font-size: 25px;
            margin-top: 10px;
            height: 50px;
            width: 250px;
            background-color: rgba(252, 245, 223, 0.95);
            color: black;
            letter-spacing: -1px;
            font-weight: 500;
            display: none;
        }

        .cart_add:hover {
            cursor: pointer;
            background-color: rgb(128, 128, 128);
            border: 1px solid rgb(128, 128, 128);
            color: rgba(255, 255, 255, 0.794);
        }

        .item:hover .cart_add {
            border: 1px solid rgb(128, 128, 128);
            display: block;
        }
        .pagination {
        }
        
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>

<body>    
    <!--  header -->
    <jsp:include page="../componants/header.jsp"></jsp:include>

    <main>
    	<!-- 페이징 처리 -->
        <div class="pagination">
            <c:if test="${paging.grpStartPage > 1}">
                <a href="?p=${paging.grpStartPage - 1}">이전</a>
            </c:if>

            <c:forEach var="i" begin="${paging.grpStartPage}" end="${paging.grpEndPage}">
                <a href="?p=${i}" class="${i == paging.currentPage ? 'active' : ''}">${i}</a>
            </c:forEach>

            <c:if test="${paging.grpEndPage < paging.totalPage}">
                <a href="?p=${paging.grpEndPage + 1}">다음</a>
            </c:if>
            <input type="text" id="search_bar">
            <button>검색</button>
        </div>
    
        <div class="container">
            <c:forEach var="product" items="${list}">
                <div class="item">
                    <a href="${pageContext.request.contextPath}/shop?product_no=${product.productNo}">
                        <img class="item_img" src="${product.imgUrl}" alt="${product.pname}">
                    </a>
                    <a href="${pageContext.request.contextPath}/shop?product_no=${product.productNo}">
                        <p class="item_name">${product.pname}</p>
                    </a>
                    <p class="price">${product.price} 원</p>
                </div>
            </c:forEach>
        </div>

        
    </main>
</body>
</html>
