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
String id=request.getParameter("ID");
String pwd=request.getParameter("PWD");
String resu="";
if (id.equals(pwd)) {//�α��� ����
	resu="YES";
} else {//�α��� ����
	resu="NO";
}
response.sendRedirect("loginResult.jsp?R="+resu+"&ID="+id);
%>
</body>
</html>