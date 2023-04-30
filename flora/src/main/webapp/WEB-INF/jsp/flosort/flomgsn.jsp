<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="floraSortMGSN.titl"/></title>
<link rel="stylesheet" type="text/css" href="../css/flora_style.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<h2 align="center"><spring:message code="floraSortMGSN.head"/></h2>
<div align="center">
	<h3>검색 결과가 ${no } 건이 있습니다.</h3>
	<table>
		<tr><th>이름</th><th>목</th><th>과</th><th>속</th></tr>
			<c:forEach items="${listMgsn }" var="lis">
				<tr><td><a href="detail.html?name=${lis.floname }&mok=${lis.mok }&gwa=${lis.gwa }">${lis.floname }</a></td><td>${lis.mok }</td><td>${lis.gwa }</td><td>${lis.sok }</td></tr>				
			</c:forEach>
	</table>
</div>
</body>
</html>