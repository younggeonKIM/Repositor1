<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="floraPresent.titl"/></title>
<link rel="stylesheet" type="text/css" href="../css/flora_style.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center">
	<h2><spring:message code="floraPresent.head"/></h2>
	<form:form action="flosortDetail.html" method="post" modelAttribute="present">
		<form:select path="flomsg">
			<c:forEach items="${List}" var="lis">
				<form:option value="${ lis}"></form:option>
			</c:forEach>
		</form:select>
		<input type="submit" value="관련 꽃말 찾기"/>
	</form:form>
</div>
<div id="presenCont">
	<jsp:include page="${BODY }"></jsp:include>
</div>
</body>
</html>