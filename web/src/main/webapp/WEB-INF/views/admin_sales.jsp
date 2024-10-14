<%@page import="web.admin.Sales"%>
<%@page import="web.admin.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/admin_sales.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
</head>
<body>
	<!-- 헤더 부분 시작 -->
	<jsp:include page="../componants/admin_header.jsp" />
	<!-- 헤더 부분  끝-->

	<!-- 메인 부분 시작 -->
	<main>
		<div class="container">
			<h1 class="title">SALES</h1>

			<div class="chart_wrap">
				<canvas id="myChart"></canvas>
				<canvas id="myChart2"></canvas>
				<canvas id="myChart3"></canvas>
			</div>
		</div>

		<%
		ArrayList<Sales> dailySales = (ArrayList<Sales>) request.getAttribute("dailySales");
		StringBuilder dates = new StringBuilder();
		StringBuilder quantities = new StringBuilder();
		StringBuilder prices = new StringBuilder();

		for (Sales sale : dailySales) {
			dates.append("'").append(sale.getOrderDate()).append("',");
			quantities.append(sale.getQuantity()).append(",");
			prices.append(sale.getPrice()).append(",");
		}
		if (dates.length() > 0)
			dates.setLength(dates.length() - 1);
		if (quantities.length() > 0)
			quantities.setLength(quantities.length() - 1);
		if (prices.length() > 0)
			prices.setLength(prices.length() - 1);
		%>

		<%
		ArrayList<Sales> salesByItem = (ArrayList<Sales>) request.getAttribute("salesByItem");
		StringBuilder itemNames = new StringBuilder();
		StringBuilder itemQuantities = new StringBuilder();
		StringBuilder itemPrices = new StringBuilder();

		int maxLabelLength = 20; // 최대 레이블 길이

		for (Sales sale : salesByItem) {
			String productName = sale.getProductName();
			// 레이블 길이 제한 적용
			if (productName.length() > maxLabelLength) {
				productName = productName.substring(0, maxLabelLength) + "..."; // 잘라내고 "..." 추가
			}

			itemNames.append("'").append(productName).append("',");
			itemQuantities.append(sale.getQuantity()).append(",");
			itemPrices.append(sale.getPrice()).append(",");
		}

		if (itemNames.length() > 0)
			itemNames.setLength(itemNames.length() - 1);
		if (itemQuantities.length() > 0)
			itemQuantities.setLength(itemQuantities.length() - 1);
		if (itemPrices.length() > 0)
			itemPrices.setLength(itemPrices.length() - 1);
		%>

		<%
		ArrayList<Sales> salesByCategory = (ArrayList<Sales>) request.getAttribute("salesByCategory");
		StringBuilder categoryNames = new StringBuilder();
		StringBuilder categorySales = new StringBuilder();

		for (Sales sale : salesByCategory) {
			categoryNames.append("'").append(sale.getCategory()).append("',");
			categorySales.append(sale.getPrice()).append(",");
		}

		if (categoryNames.length() > 0)
			categoryNames.setLength(categoryNames.length() - 1);
		if (categorySales.length() > 0)
			categorySales.setLength(categorySales.length() - 1);
		%>

		<script>
		Chart.defaults.font.family ="'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif";
			const ctx = document.getElementById('myChart').getContext('2d');
			new Chart(ctx, {
				type : 'bar',
				data : {
					labels : [
		<%=dates.toString()%>
			],
					datasets : [ {
						label : 'Quantity',
						data : [
		<%=quantities.toString()%>
			],
						backgroundColor : 'rgba(255, 99, 132, 0.5)',
						borderColor : 'rgba(255, 99, 132, 1)',
						borderWidth : 1,
						yAxisID : 'yQuantity'
					}, {
						label : 'Sales Amount',
						data : [
		<%=prices.toString()%>
			],
						backgroundColor : 'rgba(54, 162, 235, 0.5)',
						borderColor : 'rgba(54, 162, 235, 1)',
						borderWidth : 1,
						yAxisID : 'ySales'
					} ]
				},
				options : {
					responsive : false,
					maintainAspectRatio : false,
					plugins : {
						title : {
							display : true,
							text : 'Daily Sales'
						}
					},
					scales : {
						yQuantity : {
							type : 'linear',
							position : 'left',
							beginAtZero : true,
							max : 20, // 수량 Y축 최대값 설정
							title : {
								display : true,
								text : 'Quantity'
							}
						},
						ySales : {
							type : 'linear',
							position : 'right',
							beginAtZero : true,
							max : 3000000, // 금액 Y축 최대값 설정
							title : {
								display : true,
								text : 'Sales Amount'
							},
							grid : {
								drawOnChartArea : false
							}
						}
					}
				}
			});

			const ctx2 = document.getElementById('myChart2').getContext('2d');
			new Chart(ctx2, {
				type : 'bar',
				data : {
					labels : [
		<%=itemNames.toString()%>
			],
					datasets : [ {
						label : 'Quantity',
						data : [
		<%=itemQuantities.toString()%>
			],
						backgroundColor : 'rgba(255, 99, 132, 0.5)',
						borderColor : 'rgba(255, 99, 132, 1)',
						borderWidth : 1,
						yAxisID : 'yQuantity'
					}, {
						label : 'Sales Amount',
						data : [
		<%=itemPrices.toString()%>
			],
						backgroundColor : 'rgba(54, 162, 235, 0.5)',
						borderColor : 'rgba(54, 162, 235, 1)',
						borderWidth : 1,
						yAxisID : 'ySales'
					} ]
				},
				options : {
					responsive : false,
					maintainAspectRatio : false,
					plugins : {
						title : {
							display : true,
							text : 'Sales by Item'
						}
					},
					scales : {
						yQuantity : {
							type : 'linear',
							position : 'left',
							beginAtZero : true,
							max : 30,
							title : {
								display : true,
								text : 'Quantity'
							}
						},
						ySales : {
							type : 'linear',
							position : 'right',
							beginAtZero : true,
							max : 10000000,
							title : {
								display : true,
								text : 'Sales Amount'
							},
							grid : {
								drawOnChartArea : false
							}
						}
					}
				}
			});
			const ctx3 = document.getElementById('myChart3').getContext('2d');
			new Chart(ctx3, {
				type : 'pie',
				data : {
					labels : [
		<%=categoryNames.toString()%>
			], // 카테고리 이름
					datasets : [ {
						label : 'Sales by Category',
						data : [
		<%=categorySales.toString()%>
			], // 카테고리별 판매 금액
						backgroundColor : [ 'rgb(255, 99, 132)',
								'rgb(54, 162, 235)', 'rgb(255, 205, 86)',
								'rgb(75, 192, 192)', 'rgb(153, 102, 255)',
								'rgb(255, 159, 64)' ],
						hoverOffset : 4
					} ]
				},
				options : {
					responsive : false,
					maintainAspectRatio : false,
					plugins : {
						title : {
							display : true,
							text : 'Sales by Category'
						}
					}
				}
			});

			showChart(currentPage);
		</script>
	</main>
	<!-- 메인 부분 끝 -->

</body>
</html>