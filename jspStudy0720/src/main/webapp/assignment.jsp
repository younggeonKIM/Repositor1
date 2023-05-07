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
int sco=Integer.parseInt(request.getParameter("Score"));
String msg="";
if (sco<70) {
	msg="F학점입니다.";
} else {
	switch (sco/10) {
	case 10: msg="A학점입니다."; break;
	case 9: msg="A학점입니다."; break;
	case 8: msg="B학점입니다."; break;
	case 7: msg="C학점입니다."; break;
	}
}
%>
<h2>점수: <%=msg %></h2>
</body>
</html>