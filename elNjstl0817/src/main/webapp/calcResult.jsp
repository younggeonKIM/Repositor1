<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- ������ ���:${param.A }, ������ ���:${param.B }, --%>
<%-- ������ ���:${param.C }, �������� ���:${param.D } --%>
<%
// 	String sum=request.getParameter("A");
// 	String sub=request.getParameter("B");
// 	String mul=request.getParameter("C");
// 	String div=request.getParameter("D");
// 	out.print("������ ���:"+sum+", ������ ���:"+sub+
// 			", ������ ���:"+mul+", �������� ���:"+div);
%>
������ ���:${requestScope.A }, ������ ���:${requestScope.B }, 
������ ���:${requestScope.C }, �������� ���:${requestScope.D }
<%
// 	String a=(String) request.getAttribute("A");
// 	String b=(String) request.getAttribute("B");
// 	String c=(String) request.getAttribute("C");
// 	String d=(String) request.getAttribute("D");
// 	out.print("������ ���:"+a+", ������ ���:"+b+
//  			", ������ ���:"+c+", �������� ���:"+d);
%>
</body>
</html>