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
	//Redirect방식으로 page3.jsp로 전환
	//response.sendRedirect("page3.jsp");

	//Forward방식으로 page3.jsp로 전환
	// -->브라우저의 주소창(url)은 page2.jsp에 멈춰있음.
	// -->하지만, 브라우저의 내용은 page3.jsp가 나옴.
	//RequestDispatcher이름의 객체를 사용함.
	RequestDispatcher rd=request.getRequestDispatcher("page3.jsp");
	rd.forward(request,response);
%>
</body>
</html>