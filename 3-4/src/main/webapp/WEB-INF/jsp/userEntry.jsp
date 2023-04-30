<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ��� ȭ��</title>
</head>
<body>
<div align="center" class="body">
<h2>ȸ�� ���</h2>
<form:form action="userEntry.html" method="post" modelAttribute="user">
	<spring:hasBindErrors name="user">
		<font color="red">
			<c:forEach items="${errors.globalErrors }" var="err">
				<spring:message code="${err.code }"/>
			</c:forEach>
		</font>
	</spring:hasBindErrors>
<table>
	<tr height="40px"><th>������ID</th><td><form:input path="userId" maxLength="20" cssClass="userId"/>
										<font color="red"><form:errors path="userId"/></font></td></tr>
	<tr height="40px"><th>�� ȣ</th><td><form:password path="password" maxLength="20" cssClass="password"/>
										<font color="red"><form:errors path="password"/></font></td></tr>
	<tr height="40px"><th>�� ��</th><td><form:input path="userName" maxLength="20" cssClass="userName"/>
										<font color="red"><form:errors path="userName"/></font></td></tr>
	<tr height="40px"><th>�� ��</th><td><form:input path="address" maxLength="20" cssClass="address"/>
										<font color="red"><form:errors path="address"/></font></td></tr>
	<tr height="40px"><th>�̸���</th><td><form:input path="email" maxLength="20" cssClass="email"/>
										<font color="red"><form:errors path="email"/></font></td></tr>
	<tr height="40px"><th>�� ��</th><td><form:select path="job" cssClass="job">
											<form:option value="ȸ���" label="ȸ���"></form:option>
											<form:option value="�л�" label="�л�"></form:option>
											<form:option value="�ֺ�" label="�ֺ�"></form:option>
											<form:option value="��Ÿ" label="��Ÿ"></form:option>
										</form:select></td></tr>
	<tr height="40px"><th>�� ��</th><td>
									<form:radiobutton path="gender" value="M"/> ��,
									<form:radiobutton path="gender" value="F"/> ��</td></tr>
	<tr height="40px"><th>�������</th><td><form:input path="birthday" maxLength="10" cssClass="birthday"/>
										<font color="red"><form:errors path="birthday"/></font></td></tr>
</table>
<table>
	<tr><td height="40px" align="center">
		<input type="submit" value="�� ��" name="btnSubmit"/></td>
		<td height="40px" align="center">
		<input type="reset" value="�� ��" name="btnReset"/></td>
</table>
</form:form>
</div>
</body>
</html>