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
<h2>��ȭ ��õ ���</h2>
<%
String[] movies=(String [])request.getAttribute("MOV");
out.print("<table border='1'>");
for (int i=0; i<movies.length;i++) {
	out.print("<tr><th>"+(i+1)+"</th>");
	out.print("<td>"+movies[i]+"</td></tr>");
}
out.print("</table>");
%>
</div>
</body>
</html>