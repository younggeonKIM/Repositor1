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
	//itemId에 있는 상품번호를 사용해서 구매처리한다.
	System.out.println("구매처리 완료.");
	//Redirect로만 페이지를 바꿔야 한다.
	response.sendRedirect("study1_2.jsp?ABC="+itemId+"&PR="+priceId);
	//RequestDispatcher rd=request.getRequestDispatcher("study1_2.jsp");
	//rd.forward(request,response);
%>

</body>
</html>