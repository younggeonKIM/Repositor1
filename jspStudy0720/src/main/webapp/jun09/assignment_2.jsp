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
String resu=request.getParameter("R");
switch (resu) {
case "G": out.print("축하합니다. 맞추셨습니다."); break;
case "C": out.print("아쉽게도 맞추지 못하셨습니다."); break;
}
%>
</body>
</html>