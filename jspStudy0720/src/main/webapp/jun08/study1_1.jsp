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
	String priceId=request.getParameter("PRICE");
	String itemId=request.getParameter("ID");
	//itemId�� �ִ� ��ǰ��ȣ�� ����ؼ� ����ó���Ѵ�.
	System.out.println("����ó�� �Ϸ�.");
	//Redirect�θ� �������� �ٲ�� �Ѵ�.
	response.sendRedirect("study1_2.jsp?ABC="+itemId+"&PR="+priceId);
	//RequestDispatcher rd=request.getRequestDispatcher("study1_2.jsp");
	//rd.forward(request,response);
%>

</body>
</html>