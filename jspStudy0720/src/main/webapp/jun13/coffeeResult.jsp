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
	String total=request.getParameter("TOTAL");
	out.print("<h2 align='center'>총 액: "+total+"원</h2>");
%>
</body>
</html>