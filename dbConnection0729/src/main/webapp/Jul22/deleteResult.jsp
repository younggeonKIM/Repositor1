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
	String r =request.getParameter("R");
	if(r.equals("OK")) {
		out.print("게시글이 삭제되었습니다.");
	}else if(r.equals("NOK")) {
		out.print("게시글이 삭제되지 않았습니다.<br/>");
		out.print("관리자에게 문의바랍니다.");
	}
%>
</body>
</html>