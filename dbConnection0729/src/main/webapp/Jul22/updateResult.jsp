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
		out.print("�Խñ��� ����Ǿ����ϴ�.");
	}else if(r.equals("NOK")) {
		out.print("�Խñ��� ������� �ʾҽ��ϴ�.<br/>");
		out.print("�����ڿ��� ���ǹٶ��ϴ�.");
	}
%>
</body>
</html>