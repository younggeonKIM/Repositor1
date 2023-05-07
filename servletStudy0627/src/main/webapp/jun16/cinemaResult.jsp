<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
div {border:1px solid blue;}
h2 {border:1px solid blue; padding:5px; margin-left:50px; margin-right:50px;
	background-color:lightgreen; }
tr td {padding :20px ; font-size:20px; color:blue; }

</style>
</head>
<body>
<div align="center">
<h2>영화 추천 결과</h2>
<%
String[]cine=(String[])request.getAttribute("CIN");
String genre=(String)request.getAttribute("GEN");
out.print("<table border='1'><tr><th colspan='2'>"+genre+"</th></tr>");
for (int i=0; i<cine.length;i++) {
	out.print("<tr><th>"+(i+1)+"</th>");
	out.print("<td>"+cine[i]+"</td></tr>");
}
out.print("</table>");
%>
</div>
</body>
</html>