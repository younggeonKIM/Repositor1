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
	//id�� ����ִ� ������ msg�� ����ִ� �� ������ �Խñ� DB�� �����Ѵ�.
	System.out.println("�Խñ� DB�� ���ο� �� �����");
	//Redirect�� �������� ��ȯ�Ѵ�.
	response.sendRedirect("study2_2.jsp");
	//RequestDispatcher rd=request.getRequestDispatcher("study2_2.jsp");
	//rd.forward(request,response);
%>
</body>
</html>