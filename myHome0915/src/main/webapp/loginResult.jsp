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
	<h2 align="center">로그인 결과</h2>
</header>
<section>
<c:if test="${param.R=='OK' }">
	로그인 되었습니다.<br/>
	환영합니다. 
	<c:if test="${! empty sessionScope.LOGINID }">
	${sessionScope.LOGINID }님~
	</c:if>
	<c:if test="${! empty sessionScope.MANAGER }">
	${sessionScope.MANAGER }님~
	</c:if>
	<c:if test="${param.POPUP == 'YES' }">
		<br/>
		<input type="button" value="닫 기" />
		<script type="text/javascript">
			self.close();
			opener.document.location.reload();
			opener.popupAlert();
		</script>
	</c:if>
</c:if>
<c:if test="${param.R=='NOPWD' }">
	암호가 일치하지 않습니다. 암호를 확인하세요.
</c:if>
<c:if test="${param.R=='NOID' }">
	계정이 없습니다. 가입 후 이용해 주세요.
</c:if>
</section>
</body>
</html>