<%@page import="web.admin.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="css/order_detail.css" />
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
                    </li>
                </ul>
            </div>
        </div>
        <!-- 우측 상단 로그인&회원가입 -->
        <div class="login">
            <p>system 님 , 안녕하세요.</p>
            <a class="log_btn">LOGIN(LOGOUT)</a>
        </div>
    </header>
    <!-- 헤더 부분 끝-->

    <!-- 메인 부분 시작 -->
    <main>
        <div class="container">
            <h1 class="title">ORDER</h1>

            <table>
    <tr>
        <th class="info">No<br>주문일자<br>주문ID</th>
        <th class="info">이미지</th>
        <th class="info">상품정보</th>
        <th class="info">수량</th>
        <th class="info">주문금액</th>
    </tr>

    <%
        ArrayList<Order> order = (ArrayList<Order>) request.getAttribute("order");
        // 첫 번째 주문 정보는 반복문 외부에서 사용
        Order firstOrder = order.get(0);
    %>
        <tr class="order_info">
            <td rowspan="<%= order.size() %>">
                <%= firstOrder.getOrderNo() %><br>
                <%= firstOrder.getOrderDate() %><br>
                <%= firstOrder.getUserId() %>
            </td>
            <% for(Order detail : order) { %>
            <td><img src="<%= detail.getImgUrl() %>" alt=""></td>
            <td class="product_info"><%= detail.getProductName() %></td>
            <td class="quantity"><%= detail.getQuantity() %> 개</td>
            <td class="price"><span><%= detail.getPrice() %></span> 원</td>
        </tr>
        <% } %>

    <tr>
        <td colspan="4"></td>
        <td class="sum">합계 : <span id="total-price">0</span> 원</td>
    </tr>
</table>

        </div>
    </main>
    <!-- 메인 부분 끝 -->

    <script>
        // 모든 금액을 합산하는 함수
        function calculateTotal() {
            const priceElements = document.querySelectorAll('.price span'); // 가격 정보를 담고 있는 span
            let total = 0;

            priceElements.forEach((element) => {
                total += parseInt(element.textContent); // textContent에서 금액을 추출하고 합산
            });

            document.getElementById('total-price').textContent = total; // 합계를 화면에 표시
        }

        // 페이지 로드가 완료되면 합계를 계산
        window.onload = calculateTotal;
    </script>
</body>
</html>