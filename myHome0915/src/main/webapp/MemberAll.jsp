<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>ȸ�� ��� ����</h2>
<form action="MemberAllSelect">
<table>
	<c:forEach items="${AL }" var="users">
		<tr><th width="20">����</th>
			<th width="20">ȸ�� �̸�</th>
			<th width="50">��������</th></tr>
		<tr><td><a href="readMember?USID=${users.id }">${users.id }</a></td><td>${users.name }</td>
		<td>${users.entry_date }</td></tr>
	</c:forEach>
</table>
	<c:forEach begin="1" end="${PAGE }" var="page">
		<a href="MemberAllSelect?PAGENO=${page }">${page }</a>
	</c:forEach>
</form>
</div>
</body>
</html>