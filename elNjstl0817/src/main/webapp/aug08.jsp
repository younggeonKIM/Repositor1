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
	//�̺�Ʈ ��÷���� �̸��� �迭�� ����
	String[] winner={"ȫ�浿","��ö��","�ڵ���"};
	//�̺�Ʈ ��ǰ�̸��� �迭�� ����
	String[] gift={"����TV","���������","������Ź��"};
	//��÷�� ��ܰ� ��ǰ���� JSP(winner.jsp)���� ���
	//1.Redirect, 2.Forward, 3.�� �� --> Forward�� ����
	request.setAttribute("W", winner);
	request.setAttribute("G", gift);
	RequestDispatcher r=request.getRequestDispatcher("winner.jsp");
	r.forward(request, response);
%>
</body>
</html>