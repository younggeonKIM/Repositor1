<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
	//�̸��� add, add �޼����� ��� : �� ���� ������ ���� ����
	int add (int box1,int box2) {
		return box1+box2;
	}
	String makeMsg (String m1,String m2) {
		String a=m1 +" "+m2;
		return a;
	}
%>
<%
	String msg=makeMsg("�ȳ��ϼ���", "ȫ�浿");
	out.print ("<h2>"+msg+"</h2>");
	int dap=add(54,23); out.print ("<h2>"+dap+"</h2>");
	dap=add(1,100); out.print ("<h2>"+dap+"</h2>");
	dap=add(34,847); out.print ("<h2>"+dap+"</h2>");
%>
</body>
</html>