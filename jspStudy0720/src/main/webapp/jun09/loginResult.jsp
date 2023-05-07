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
String res=request.getParameter("R");
String Id=request.getParameter("ID");
if(res.equals("YES")) {
	out.print("<h2>로그인 되었습니다. 환영합니다~"+Id+"님~</h2>");
} else {
	out.print("<h2>로그인 실패했습니다. 계정과 암호를 확인하세요.");
}
%>
</body>
</html>