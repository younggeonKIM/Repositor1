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
<header>
	<h2 align="center">�α��� ���</h2>
</header>
<section>
<c:if test="${param.R=='OK' }">
	�α��� �Ǿ����ϴ�.<br/>
	ȯ���մϴ�. 
	<c:if test="${! empty sessionScope.LOGINID }">
	${sessionScope.LOGINID }��~
	</c:if>
	<c:if test="${! empty sessionScope.MANAGER }">
	${sessionScope.MANAGER }��~
	</c:if>
	<c:if test="${param.POPUP == 'YES' }">
		<br/>
		<input type="button" value="�� ��" />
		<script type="text/javascript">
			self.close();
			opener.document.location.reload();
			opener.popupAlert();
		</script>
	</c:if>
</c:if>
<c:if test="${param.R=='NOPWD' }">
	��ȣ�� ��ġ���� �ʽ��ϴ�. ��ȣ�� Ȯ���ϼ���.
</c:if>
<c:if test="${param.R=='NOID' }">
	������ �����ϴ�. ���� �� �̿��� �ּ���.
</c:if>
</section>
</body>
</html>