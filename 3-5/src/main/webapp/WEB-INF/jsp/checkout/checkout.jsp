<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<h2>���� ȭ��</h2>
<font color="red"><b>��� ���� ��</b></font>
<table border="1" >
	<tr align="center"><th>�����ID</th><td>${loginUser.userId }</td></tr>
	<tr align="center"><th>�� ��</th><td>${loginUser.userName }</td></tr>
	<tr align="center"><th>�� ��</th><td>${loginUser.address }</td></tr>
	<tr align="center"><th>�̸���</th><td>${loginUser.email }</td></tr>
</table><br/>
<font color="red"><b>���� ���</b></font>
<table border="1">
	<tr><th width="200">��ǰ��</th><th width="150">����</th><th width="50">����</th><th width="150">�� ��</th></tr>
	<c:forEach items="${itemList }" var="itemSet">
		<tr><td align="left">${itemSet.item.itemName }</td>
			<td align="right">${itemSet.item.price }��</td>
			<td align="right">${itemSet.quantity }��</td>
			<td align="right">${itemSet.quantity * itemSet.item.price }��</td></tr>
	</c:forEach>
</table><br/><br/><b>�� �� : ${totalAmount }��</b><br/><br/>
<form action="../end/end.html">
	<input type="submit" value="���� Ȯ��" name="btn"/>
</form>
</div>
</body>
</html>