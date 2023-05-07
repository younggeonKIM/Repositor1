<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- 덧셈의 결과:${param.A }, 뺄셈의 결과:${param.B }, --%>
<%-- 곱셈의 결과:${param.C }, 나눗셈의 결과:${param.D } --%>
<%
// 	String sum=request.getParameter("A");
// 	String sub=request.getParameter("B");
// 	String mul=request.getParameter("C");
// 	String div=request.getParameter("D");
// 	out.print("덧셈의 결과:"+sum+", 뺄셈의 결과:"+sub+
// 			", 곱셈의 결과:"+mul+", 나눗셈의 결과:"+div);
%>
덧셈의 결과:${requestScope.A }, 뺄셈의 결과:${requestScope.B }, 
곱셈의 결과:${requestScope.C }, 나눗셈의 결과:${requestScope.D }
<%
// 	String a=(String) request.getAttribute("A");
// 	String b=(String) request.getAttribute("B");
// 	String c=(String) request.getAttribute("C");
// 	String d=(String) request.getAttribute("D");
// 	out.print("덧셈의 결과:"+a+", 뺄셈의 결과:"+b+
//  			", 곱셈의 결과:"+c+", 나눗셈의 결과:"+d);
%>
</body>
</html>