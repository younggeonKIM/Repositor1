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
	//컴퓨터를 위해서 난수를 구한다. (1~3)
	int com=(int)((Math.random()*3)+1);
	String gamer=request.getParameter("GAMER");
	//문자열을 정수로 바꾼다.
	int gamerInt=Integer.parseInt(gamer);
	String result="";
	if (com==gamerInt) {//무승부인 경우
		result="D";
	} else if (com==1&&gamerInt==2||com==2&&gamerInt==3||
				com==3&&gamerInt==1) {//게이머가 이긴 경우
		result="G";
	}
	else {//컴퓨터가 이긴 경우
		result="C";
	}
	response.sendRedirect("study1_2.jsp?R="+result);
%>
</body>
</html>