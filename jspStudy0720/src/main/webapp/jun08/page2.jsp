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
	//Redirect������� page3.jsp�� ��ȯ
	//response.sendRedirect("page3.jsp");

	//Forward������� page3.jsp�� ��ȯ
	// -->�������� �ּ�â(url)�� page2.jsp�� ��������.
	// -->������, �������� ������ page3.jsp�� ����.
	//RequestDispatcher�̸��� ��ü�� �����.
	RequestDispatcher rd=request.getRequestDispatcher("page3.jsp");
	rd.forward(request,response);
%>
</body>
</html>