<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �Ϸ� ȭ��</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<h2>ȸ�� ���� �Ϸ�</h2>
<b><font color="red">������ �Ϸ�ƽ��ϴ�~</font></b>
<table>
	<tr height="40px"><td>������ID</td><td>${user.userId }</td></tr>
	<tr height="40px"><td>�� ȣ</td><td>${user.password }</td></tr>
	<tr height="40px"><td>�� ��</td><td>${user.userName }</td></tr>
	<tr height="40px"><td>�� ��</td><td>${user.address }</td></tr>
	<tr height="40px"><td>�̸���</td><td>${user.email }</td></tr>
	<tr height="40px"><td>�� ��</td><td>${user.job }</td></tr>
	<tr height="40px"><td>�������</td><td>${user.birthday }</td></tr>
</table>
</div>
</body>
</html>