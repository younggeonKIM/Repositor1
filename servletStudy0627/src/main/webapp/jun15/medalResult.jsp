<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

h2 {border : 1px solid blue; padding:10px; background-color:lightgreen;}
tr td { padding :20px ; font-size:20px; color:blue;}
</style>
</head>
<body>
<div align="center">
<h2>�ø��� �޴� ���� ���</h2>
<%
int[] medNum=(int[])request.getAttribute("MEDAL");
String natName=(String)request.getAttribute("Nation");
String msg="";
out.print("<table border='1'><tr><th colspan='2'>"+natName+"</th></tr>");
for (int i=0;i<medNum.length;i++) {
	if (i==0) {
		msg="�ݸ޴�";
	} else if (i==1) {
		msg="���޴�";
	} else if (i==2) {
		msg="���޴�";
	}
	out.print("<tr><th>"+msg+"</th>");
	out.print("<td>"+medNum[i]+"</td></tr>");
}
out.print("</table>");
%>
</div>
</body>
</html>