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
String direction=request.getParameter("DIR");
int computer=(int) (Math.random()*5)+1;
int gamer=Integer.parseInt(direction);
String result="";
if (computer==gamer) {
	result="N";
} else {
	result="Y";
}
response.sendRedirect("penaltyResult.jsp?R="+result+
						"&C="+computer+"&G="+gamer);
%>
</body>
</html>