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
	<font color="red">��ǰ�� ��ٱ��Ͽ� �����÷��� �α����� ���ּ���.</font><br/>
</c:if>
</div>
<div align="right">

<a href="template.jsp?BODY=entry.jsp">�����ϱ�</a></div>
	<div align="center">
	<form action="login.do" method="post" name="login" 
			onSubmit="return check()">
	<c:if test="${param.CART=='YES' }">
		<input type="hidden" name="CART" value="OK"/>
	</c:if>
	�� �� : <input type="text" name="ID" size="10"/><br/>
	�� ȣ : <input type="password" name="PWD" size="10"/><br/><br/>
	<input type="submit" value="�α���"/>
	<input type="reset" value="�� ��"/>
	</form>
	</div>
</section>

<script type="text/javascript">
function check() {
	if (document.login.ID.value=='') {
		alert("������ �Է��ϼ���.");
		return false;
	}
	if (document.login.PWD.value=='') {
		alert("��ȣ�� �Է��ϼ���.");
		return false;
	}
}
</script>
</body>
</html>