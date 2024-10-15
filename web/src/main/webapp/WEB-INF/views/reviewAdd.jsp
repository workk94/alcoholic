<%@page import="java.util.HashMap"%>
<%@page import="web.review.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/web/css/review.css">
<script>
    function updateItemNo() {
        const productSelect = document.querySelector('select[name="product_no"]');
        const itemSelect = document.querySelector('select[name="item_no"]');
        
        const selectedProductNo = productSelect.value;
        
        const itemOptions = itemSelect.querySelectorAll('option');
        
        itemOptions.forEach(option => {
            if (option.getAttribute('data-product-no') === selectedProductNo || option.value === "") {
                option.style.display = 'block';
            } else {
                option.style.display = 'none';
            }
        });
        
        itemSelect.value = Array.from(itemOptions).find(option => option.style.display === 'block')?.value || '';
    }
</script>
</head>
<body>
<header>
<jsp:include page="../componants/header.jsp"></jsp:include>
</header>
<main>
    <div class="container">
        <h1 class="title">새 리뷰 작성</h1>
        <form name="form" action="/web/addReview" method="post" onsubmit="return signUpCheck()">
            <table>
                <tr>
                    <td><label for="user_id">작성자:</label></td>
                    <td><input type="text" name="user_id" value="<%= request.getAttribute("currentUserId") %>" readonly></td>
                </tr>
                <tr>
                    <td><label for="product_no">제품 번호:</label></td>
                    <%
                        ArrayList<Review> productItems = (ArrayList<Review>) request.getAttribute("productItems");
                        if (productItems != null && !productItems.isEmpty()) {
                    %>
                    <td>
                        <select name="product_no" required onchange="updateItemNo()">
                            <option value="">선택하세요</option>
                            <%
                                HashMap<Integer, ArrayList<Review>> productMap = new HashMap<>();
                                for (Review item : productItems) {
                                    int productNo = item.getProduct_no(); // int로 변경
                                    if (!productMap.containsKey(productNo)) {
                                        productMap.put(productNo, new ArrayList<>());
                                    }
                                    productMap.get(productNo).add(item);
                                }
                                for (Integer productNo : productMap.keySet()) {
                            %>
                                <option value="<%= productNo %>"><%= productNo %></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    </tr>
                    <tr>
                        <td><label for="item_no">아이템 번호:</label></td>
                        <td>
                            <select name="item_no" required>
                                <option value="">선택하세요</option>
                                <%
                                    for (Review item : productItems) {
                                %>
                                    <option value="<%= item.getItem_no() %>" data-product-no="<%= item.getProduct_no() %>"><%= item.getItem_no() %></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="contents">내용:</label></td>
                        <td><textarea name="contents" required></textarea></td>
                    </tr>
                    <tr>
                        <td><label for="rating">평점:</label></td>
                        <td><input type="number" name="rating" min="1" max="3" required></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="submit">리뷰 추가</button></td>
                    </tr>
                    <%
                        } // if (productItems != null && !productItems.isEmpty()) 끝
                    %>
            </table>
        </form>
        <div class="new_wrap"><a class="new" href="review">목록으로 돌아가기</a></div>
    </div>
</main>
</body>
</html>
