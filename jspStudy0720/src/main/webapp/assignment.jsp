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
	msg="F�����Դϴ�.";
} else {
	switch (sco/10) {
	case 10: msg="A�����Դϴ�."; break;
	case 9: msg="A�����Դϴ�."; break;
	case 8: msg="B�����Դϴ�."; break;
	case 7: msg="C�����Դϴ�."; break;
	}
}
%>
<h2>����: <%=msg %></h2>
</body>
</html>