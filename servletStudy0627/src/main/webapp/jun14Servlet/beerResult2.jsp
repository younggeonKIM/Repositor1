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
// String name1=request.getParameter("BR1");
// String name2=request.getParameter("BR2");
// String name3=request.getParameter("BR3");
String[] names=(String[]) request.getAttribute("BRS");
%>
<h2>��õ�� ����1 : <%=names[0] %>, ��õ�� ����2 : <%=names[1] %>, 
	��õ�� ����3 : <%=names[2] %></h2>
</body>
</html>