<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String[] brands=(String[])request.getAttribute("BRS");

%>
<h2>��õ ����1:<%=brands[0] %>, ��õ ����2:<%=brands[1] %>, 
	��õ ����3:<%=brands[2] %></h2>
</body>
</html>