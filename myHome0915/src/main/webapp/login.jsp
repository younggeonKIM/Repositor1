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
<section>
<div align="center">
<c:if test="${param.CART=='YES' }">
	<font color="red">상품을 장바구니에 담으시려면 로그인을 해주세요.</font><br/>
</c:if>
</div>
<div align="right">

<a href="template.jsp?BODY=entry.jsp">가입하기</a></div>
	<div align="center">
	<form action="login.do" method="post" name="login" 
			onSubmit="return check()">
	<c:if test="${param.CART=='YES' }">
		<input type="hidden" name="CART" value="OK"/>
	</c:if>
	계 정 : <input type="text" name="ID" size="10"/><br/>
	암 호 : <input type="password" name="PWD" size="10"/><br/><br/>
	<input type="submit" value="로그인"/>
	<input type="reset" value="취 소"/>
	</form>
	</div>
</section>

<script type="text/javascript">
function check() {
	if (document.login.ID.value=='') {
		alert("계정을 입력하세요.");
		return false;
	}
	if (document.login.PWD.value=='') {
		alert("암호를 입력하세요.");
		return false;
	}
}
</script>
</body>
</html>