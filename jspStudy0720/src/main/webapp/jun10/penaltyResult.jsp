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
	String resu=request.getParameter("R"); //���
	String com=request.getParameter("C"); //��ǻ�� ����
	String gamer=request.getParameter("G"); //�� ����
	if (resu.equals("Y")) {
		out.print("<h2 align='center'>��~��~</h2>");
	} else {
		out.print("<h2 align='center'>�� ��!</h2>");
	}
	switch (com) {
	case "1": out.print ("<h2 align='center'>Ű���� ������ ��</h2>"); break;
	case "2": out.print ("<h2 align='center'>Ű���� ������ ��</h2>"); break;
	case "3": out.print ("<h2 align='center'>Ű���� ������ ��</h2>"); break;
	case "4": out.print ("<h2 align='center'>Ű���� ������ ��</h2>"); break;
	case "5": out.print ("<h2 align='center'>Ű���� ������ ��</h2>"); break;
	}
	switch (gamer) {
	case "1": out.print ("<h2 align='center'>ű�� ������ ��</h2>"); break;
	case "2": out.print ("<h2 align='center'>ű�� ������ ��</h2>"); break;
	case "3": out.print ("<h2 align='center'>ű�� ������ ��</h2>"); break;
	case "4": out.print ("<h2 align='center'>ű�� ������ ��</h2>"); break;
	case "5": out.print ("<h2 align='center'>ű�� ������ ��</h2>"); break;
	}
%>
</body>
</html>