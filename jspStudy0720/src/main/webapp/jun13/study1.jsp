<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>스크립트 릿과 선언부에서의 변수 선언 차이</h2>
<%!
int a=1;
%>
<%
int b=1; a=a+1; b=b+1;
%>
<h3>a : <%=a %> b : <%=b %></h3>
</body>
</html>