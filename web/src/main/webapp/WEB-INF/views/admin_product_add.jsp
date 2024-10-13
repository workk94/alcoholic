<%@page import="web.admin.Product" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>

            <link rel="stylesheet" href="css/admin_product_add.css">
            <script src="https://kit.fontawesome.com/4ec79785b5.js" crossorigin="anonymous"></script>

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
                    <a class="log_btn" href="login.html">LOGIN(LOGOUT)</a> / <a class="join_btn" href="joinus.html">JOIN
                        US</a>
                </div>
            </header>
            <!-- 헤더 부분  -->


            <!-- 메인 부분 시작 -->
            <main>
                <div class="container">
                    <h1 class="title">UPDATE</h1>
                    <div class="wrap">
                        <form name="frm" action="/web/admin_product.add" method="post"
                            onsubmit="return addCheck();">
                            <div class="info_wrap">
                                <p>Category : <select name="category" id="category">
                                        <option id="none" value="none" disabled selected>=== 선택 ===</option>
                                        <option value="WINE">WINE</option>
                                        <option value="WHISKY">WHISKY</option>
                                    </select> </p>
                                <p>이름 : <input id="name" name="name" type="text"></p>
                                <p>가격 : <input id="price" name="price" type="text">
                                </p>
                                <p>imgUrl : <input id="imgUrl" name="imgUrl" type="text"
                                        > <a onclick="imgCheck();"><i
                                            class="fa-solid fa-arrows-rotate"></i></a></p>
                            </div>
                            <button>등록하기</button>
                        </form>
                        <div class="image">
                            <img id="productImg" src="">
                        </div>
                    </div>

                </div>


                <script type="text/javascript">

                    function addCheck() {
                        return confirm("정말 등록하시겠습니까?");
                    }
                    function imgCheck() {
                        let imgUrl = document.querySelector("#imgUrl").value;

                        document.querySelector("#productImg").src = imgUrl;
                    }

                </script>

            </main>
            <!-- 메인 부분 끝 -->
        </body>

        </html>