<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 등록 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>회원 등록</h2>
<form:form action="userEntry.html" method="post" modelAttribute="user">
	<spring:hasBindErrors name="user">
		<font color="red">
			<c:forEach items="${errors.globalErrors }" var="err">
				<spring:message code="${err.code }"/>
			</c:forEach>
		</font>
	</spring:hasBindErrors>
<table>
	<tr height="40px"><th>가입자ID</th><td><form:input path="userId" maxLength="20" cssClass="userId"/>
										<font color="red"><form:errors path="userId"/></font></td></tr>
	<tr height="40px"><th>암 호</th><td><form:password path="password" maxLength="20" cssClass="password"/>
										<font color="red"><form:errors path="password"/></font></td></tr>
	<tr height="40px"><th>이 름</th><td><form:input path="userName" maxLength="20" cssClass="userName"/>
										<font color="red"><form:errors path="userName"/></font></td></tr>
	<tr height="40px"><th>주 소</th><td><form:input path="address" maxLength="20" cssClass="address"/>
										<font color="red"><form:errors path="address"/></font></td></tr>
	<tr height="40px"><th>이메일</th><td><form:input path="email" maxLength="20" cssClass="email"/>
										<font color="red"><form:errors path="email"/></font></td></tr>
	<tr height="40px"><th>직 업</th><td><form:select path="job" cssClass="job">
											<form:option value="회사원" label="회사원"></form:option>
											<form:option value="학생" label="학생"></form:option>
											<form:option value="주부" label="주부"></form:option>
											<form:option value="기타" label="기타"></form:option>
										</form:select></td></tr>
	<tr height="40px"><th>성 별</th><td>
									<form:radiobutton path="gender" value="M"/> 남,
									<form:radiobutton path="gender" value="F"/> 여</td></tr>
	<tr height="40px"><th>생년월일</th><td><form:input path="birthday" maxLength="10" cssClass="birthday"/>
										<font color="red"><form:errors path="birthday"/></font></td></tr>
</table>
<table>
	<tr><td height="40px" align="center">
		<input type="submit" value="등 록" name="btnSubmit"/></td>
		<td height="40px" align="center">
		<input type="reset" value="취 소" name="btnReset"/></td>
</table>
</form:form>
</div>
</body>
</html>