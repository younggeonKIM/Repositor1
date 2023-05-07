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
	String resu=request.getParameter("R"); //결과
	String com=request.getParameter("C"); //컴퓨터 방향
	String gamer=request.getParameter("G"); //슛 방향
	if (resu.equals("Y")) {
		out.print("<h2 align='center'>골~인~</h2>");
	} else {
		out.print("<h2 align='center'>노 골!</h2>");
	}
	switch (com) {
	case "1": out.print ("<h2 align='center'>키퍼의 방향은 상</h2>"); break;
	case "2": out.print ("<h2 align='center'>키퍼의 방향은 하</h2>"); break;
	case "3": out.print ("<h2 align='center'>키퍼의 방향은 좌</h2>"); break;
	case "4": out.print ("<h2 align='center'>키퍼의 방향은 우</h2>"); break;
	case "5": out.print ("<h2 align='center'>키퍼의 방향은 중</h2>"); break;
	}
	switch (gamer) {
	case "1": out.print ("<h2 align='center'>킥의 방향은 상</h2>"); break;
	case "2": out.print ("<h2 align='center'>킥의 방향은 하</h2>"); break;
	case "3": out.print ("<h2 align='center'>킥의 방향은 좌</h2>"); break;
	case "4": out.print ("<h2 align='center'>킥의 방향은 우</h2>"); break;
	case "5": out.print ("<h2 align='center'>킥의 방향은 중</h2>"); break;
	}
%>
</body>
</html>