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
<c:choose>
	<c:when test="${param.R=='OK' }">
		<h2>������ �����մϴ�~</h2>
	</c:when>
	<c:otherwise>
		<h2>���Խ� ������ �߻��߽��ϴ�.</h2>
		<h2>�����ڿ��� ������ �ּ���.</h2>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>