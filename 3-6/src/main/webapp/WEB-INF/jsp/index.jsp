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
<title><spring:message code="itemMenu.title"/></title>
</head>
<body>
<form:form method="post" action="search.html">
<div align="center" class="body">
<h2><spring:message code="itemMenu.title"/></h2>
��ǰ�� �˻�<input type="text" name="itemName"/>
<input type="submit" value="�� ��"/>
<a href="create.html">��ǰ ���</a>
<table border="1">
	<tr class="header"><th align="center" width="80">��ǰID</th>
						<th align="center" width="320">��ǰ��</th>
						<th align="center" width="100">��ǰ����</th>
						<th align="center" width="80">�� ��</th>
						<th align="center" width="80">�� ��</th></tr>
	<c:forEach items="${itemList }" var="item">
		<tr class="record"><td align="center">${item.itemId }</td>
							<td align="left">${item.itemName }</td>
							<td align="right"><f:formatNumber type="currency" currencySymbol="��" value="${item.price }"/>��</td>
							<td align="center"><a href="edit.html?itemId=${item.itemId }">��ǰ ����</a></td>
							<td align="center"><a href="confirm.html?itemId=${item.itemId }">��ǰ ����</a></td></tr>
	</c:forEach>
</table>
</div>
</form:form>
</body>
</html>