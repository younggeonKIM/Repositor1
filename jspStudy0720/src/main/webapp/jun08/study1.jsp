<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>�� ǰ �� ��</h2>
<%
	//�ڹٿ��� ��ǰ ��ȣ (���� 5��)�� ����ִ� �迭 ����
	int [] ids = {100, 200, 300, 400, 500};
	//�ڹٿ��� ��ǰ �̸� (���ڿ� 5��)�� ����ִ� �迭 ����
	String [] names = {"����", "����", "Ű��", "������", "��"};
	//�ڹٿ��� ��ǰ ���� (���� 5��)�� ����ִ� �迭 ����
	int [] prices = {8000, 9000, 10000, 6000, 11000};
%>
<table border="1">
	<tr><th>��ǰ ��ȣ</th><th>��ǰ �̸�</th><th>��ǰ ����</th><th>�� ��</th></tr>
	<%
		for (int idx=0 ; idx<prices.length ; idx++) {
	%>
		<form action="study1_1.jsp" method="get">
		<input type="hidden" name="PRICE" value="<%=prices[idx] %>"/>
		<input type="hidden" name="ID" value="<%=ids[idx] %>"/>
		<tr><td><%=ids[idx] %></td><td><%=names[idx] %></td>
		<td><%=prices[idx] %></td>
		<td><input type="submit" value="�����ϱ�"/></td></tr>
		</form>
	<%
		}
	%>
</table>
</div>
</body>
</html>