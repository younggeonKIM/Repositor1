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
	String id=request.getParameter("WRITER");
	String msg=request.getParameter("CONTENT");
	//id에 들어있는 계정과 msg에 들어있는 글 내용을 게시글 DB에 저장한다.
	System.out.println("게시글 DB에 새로운 글 등록함");
	//Redirect로 페이지를 전환한다.
	response.sendRedirect("study2_2.jsp");
	//RequestDispatcher rd=request.getRequestDispatcher("study2_2.jsp");
	//rd.forward(request,response);
%>
</body>
</html>