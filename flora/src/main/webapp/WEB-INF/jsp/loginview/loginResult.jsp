<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="floraLoginResult.titl"/></title>
<link rel="stylesheet" type="text/css" href="../css/flora_style.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center">
	<h2>환영합니다~~~~</h2>
	<br/>${loginMemb.membId }님!!
</div>
</body>
</html>