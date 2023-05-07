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
	out.print("<h2>주문해주셔서 감사합니다~</h2>");
	out.print("<h2>주문 총액: "+total+"원</h2>");
// 	out.print("<h2>커피의 주문 총액: "+totalCofPri+"원"+
// 			" 빵의 주문 총액: "+totalBreaPri+"원</h2>");
%>
</body>
</html>