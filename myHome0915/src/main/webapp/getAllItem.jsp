<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function popupAlert() {
	setTimeout(function(){alert("�α��� �Ǿ����ϴ�.");} , 100);
}
</script>
<div align="center">
<h2>�� ǰ �� ��</h2>
<table width="100%">
	<tr><th>��ǰ��ȣ</th><th>��ǰ�̸�</th><th>�� ��</th>
		<th>������</th><th>�� ��</th></tr>
		<c:forEach items="${AL }" var="item">
			<tr><td>${item.id }</td>
			<td><a href="getItem?ID=${item.id }">${item.name }</a></td>
			<td>${item.pric }</td><td>${item.orig }</td>
			<td><a href="#" 
			onClick="window.open('addCart.do?CODE=${item.id }', 'my_cart', 'width=400, height=300')">��ٱ��� ���</a></td></tr>
		</c:forEach>
</table>
<c:forEach begin="1" end="${PAGES }" var="page">
	<a href="getAllItems?PAGENO=${page }">${page }</a>
</c:forEach>
</div>
<c:if test="${requestScope.R>0 }">
	<script type="text/javascript">
		alert("��ǰ�� ��ϵǾ����ϴ�.");
	</script>
</c:if>
<c:if test="${requestScope.R<1 }">
	<script type="text/javascript">
		alert("��ǰ�� ��ϵ��� �ʾҽ��ϴ�. �����ڿ��� �����ϼ���.");
	</script>
</c:if>
</body>
</html>