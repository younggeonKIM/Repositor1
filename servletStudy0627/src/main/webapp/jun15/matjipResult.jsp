<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
div {border:1px solid blue; background-color:lightblue; padding:20px;}
</style>
</head>
<body>
<div align="center">
<h2>��õ�� ������ ������ �����ϴ�.</h2>
<%
String[] matjips=(String[])request.getAttribute("Matj");
out.print("<table border='1'>");
for (int i=0;i<matjips.length;i++) {
	out.print("<tr><th>"+(i+1)+"</th>");
	out.print("<td>"+matjips[i]+"</td></tr>");
}//�迭�� ���̸�ŭ �ݺ�
out.print("</table>");
%>
</div>
</body>
</html>