<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ȭ��</title>
<link rel="stylesheet" type="text/css" href="css/3-3.css">
</head>
<body>
<div align="center" class="body">
	<form:form action="login.html" method="post" modelAttribute="user">
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach items="${errors.globalErrors }" var="err">
					<spring:message code="${err.code }"/>
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		<table>
			<tr height="40px"><td>�����ID</td><td><form:input path="userId" cssClass="userId"/>
												<font color="red"><form:errors path="userId"/></font></td></tr>
			<tr height="40px"><td>��ȣ</td><td><form:password path="password" cssClass="password"/>
												<font color="red"><form:errors path="password"/></font></td></tr>
		</table>
		<table>
			<tr><td align="center"><input type="submit" value="�α���"/></td>
				<td align="center"><input type="reset" value="���"/></td></tr>
		</table>
	</form:form>
</div>
</body>
</html>