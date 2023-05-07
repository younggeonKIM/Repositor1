<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="myStyle.css">
</head>
<body>
<header>
	<h1 align="center">���θ� ȸ������ ver1.0</h1>
</header>
<menu>
	<jsp:include page="menu_header.jsp"/>
</menu>
<section>
	<h2 align="center">�� �� �� ��</h2>
		<fmt:timeZone value="${requestScope.ZONE }">
			<fmt:formatDate value="${requestScope.TODAY }" type="both" timeStyle="full"
			dateStyle="full"/><br/>
		</fmt:timeZone>
</section>
<footer>
	<h3 align="center">HRDKOREA copyright 2022 All right reserved</h3>
</footer>
</body>
</html>