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
	<h1 align="center">���θ� ȸ������ ver1.0</h1>
</header>
<menu>
	<jsp:include page="menu_header.jsp"/>
</menu>
<section>
	<h2 align="center">ȸ��������ȸ</h2>
	<div align="center">
	<table border="1">
		<tr><th>ȸ����ȣ</th><th>ȸ���̸�</th><th>�����</th><th>����</th></tr>
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
			out.print("�Ϲ�");
		} else if (g.equals("C")){
			out.print("����");
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