<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>상 품 목 록</h2>
<%
	//자바에서 상품 번호 (정수 5개)가 들어있는 배열 선언
	int [] ids = {100, 200, 300, 400, 500};
	//자바에서 상품 이름 (문자열 5개)이 들어있는 배열 선언
	String [] names = {"포도", "딸기", "키위", "오렌지", "귤"};
	//자바에서 상품 가격 (정수 5개)이 들어있는 배열 선언
	int [] prices = {8000, 9000, 10000, 6000, 11000};
%>
<table border="1">
	<tr><th>상품 번호</th><th>상품 이름</th><th>상품 가격</th><th>구 매</th></tr>
	<%
		for (int idx=0 ; idx<prices.length ; idx++) {
	%>
		<form action="study1_1.jsp" method="get">
		<input type="hidden" name="PRICE" value="<%=prices[idx] %>"/>
		<input type="hidden" name="ID" value="<%=ids[idx] %>"/>
		<tr><td><%=ids[idx] %></td><td><%=names[idx] %></td>
		<td><%=prices[idx] %></td>
		<td><input type="submit" value="구매하기"/></td></tr>
		</form>
	<%
		}
	%>
</table>
</div>
</body>
</html>