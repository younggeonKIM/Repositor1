<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ page import="java.util.*, member.*" %>
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
	<h2 align="center">ȸ����� ��ȸ/����</h2>
<div align="center">
<table border="1">
	<tr><th>ȸ����ȣ</th><th>ȸ������</th><th>��ȭ��ȣ</th><th>�ּ�</th><th>��������</th>
		<th>�����</th><th>��������</th></tr>
<%
ArrayList members =(ArrayList) request.getAttribute("ALL");
int size = members.size();
for (int i =0;i<size;i++) {
	Member mem = (Member)members.get(i);
%>
	<tr><td><a href="memberSelect.do?ID=<%= mem.getCustno() %>"><%= mem.getCustno() %></a></td>
		<td><%= mem.getName() %></td>
		<td><%= mem.getTel() %></td>
		<td><%= mem.getAddr() %></td>
		<td><%= mem.getDate() %></td>
		<td>
<%		String g=mem.getGrade();
		if(g.equals("A")){
			out.print("VIP");
		}else if(g.equals("B")) {
			out.print("�Ϲ�");
		}else if(g.equals("C"))	{
			out.print("����");
		}
%>		</td>
		<td><%= mem.getCode() %></td></tr>
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