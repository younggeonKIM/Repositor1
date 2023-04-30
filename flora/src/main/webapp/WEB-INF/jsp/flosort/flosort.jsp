<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="floraSort.title"/></title>
<link rel="stylesheet" type="text/css" href="../css/flora_style.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<h2 align="center"><spring:message code="floraSort.head"/></h2>
<div id="Sort">
	<ul>
	<c:forEach items="${List }" var="lis">
		<form:form action="sort_detail.html" method="post" modelAttribute="floSort">
			<li>
				<a href="flomgsn.html?name=${lis.floname }">${lis.floname }</a>
			</li>
		</form:form>
	</c:forEach>
	</ul>
</div>
</body>
</html>