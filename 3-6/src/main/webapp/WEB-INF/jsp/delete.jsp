<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemDelete.title"/></title>
</head>
<body>
<form:form modelAttribute="item" action="delete.html" onsubmit="return check()">
<form:hidden path="itemId"/>
<div align="center" class="body">
	<h2><font color="blue"><spring:message code="itemDelete.title"/></font></h2>
	<table>
		<tr height="40px"><th>��ǰ��</th><td><form:input path="itemName" cssClass="itemName" disabled="true"/></td></tr>
		<tr height="40px"><th>��ǰ����</th><td><form:input path="price" cssClass="price" disabled="true"/>��</td></tr>
		<tr height="40px"><th>�̹���</th><td><img alt="" src="${pageContext.request.contextPath }/upload/${imageName}" width="200" height="200"></td></tr>
		<tr height="40px"><th>��ǰ����</th><td><form:textarea path="info" cssClass="description" disabled="true"/></td></tr>
	</table><br/>
		<input type="submit" value="����"/><br/>
</div>
</form:form><a href="index.html">���ư���</a>
</body>
</html>