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
int gamer=Integer.parseInt(request.getParameter("HJ"));
int com=(int) ((Math.random()*2)+1);
String result="";
if (com==gamer) {
	result="G";
}else {
	result="C";
}
response.sendRedirect("assignment_2.jsp?R="+result);
%>
</body>
</html>