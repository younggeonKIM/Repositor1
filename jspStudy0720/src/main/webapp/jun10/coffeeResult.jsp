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
	int total=(int)request.getAttribute("total");	
	String totalCofPri=request.getParameter("CoTot");
	String totalBreaPri=request.getParameter("BreTot");
	String totalPri=request.getParameter("Tot");
	out.print("<h2>�ֹ����ּż� �����մϴ�~</h2>");
	out.print("<h2>�ֹ� �Ѿ�: "+total+"��</h2>");
// 	out.print("<h2>Ŀ���� �ֹ� �Ѿ�: "+totalCofPri+"��"+
// 			" ���� �ֹ� �Ѿ�: "+totalBreaPri+"��</h2>");
%>
</body>
</html>