<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="java.util.*, sales.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="myStyle.css">
</head>
<body>
<header>
	<h1 align="center">쇼핑몰 회원관리 ver1.0</h1>
</header>
<menu>
	<jsp:include page="menu_header.jsp"/>
</menu>
<section>
	<h2 align="center">회원매출조회</h2>
	<div align="center">
	<table border="1">
		<tr><th>회원번호</th><th>회원이름</th><th>고객등급</th><th>매출</th></tr>
<%
	ArrayList al=(ArrayList) request.getAttribute("LIST");
	int count=al.size(); 
	for (int i=0; i<count; i++) {
		Output otpt= (Output)al.get(i);
%>
		<tr><td><%= otpt.getCustno() %></td>
			<td><%= otpt.getName() %></td>
			<td>
<% 
		String g=otpt.getGrade();
		if (g.equals("A")){
			out.print("VIP");
		} else if (g.equals("B")){
			out.print("일반");
		} else if (g.equals("C")){
			out.print("직원");
		}
%>			</td>
			<td><%= otpt.getTotal() %></td>
<%
} 
%>
	</table>
	</div>
</section>
<footer>
	<h3 align="center">HRDKOREA copyright 2022 All right reserved</h3>
</footer>
</body>
</html>