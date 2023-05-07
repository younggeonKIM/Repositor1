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
<form action="logIdCheck" name="frm" method="get">
<div align="center">
<h2>계정 중복 검사</h2>
	ID : <input type="text" name="ID" value="${ID }"/>
		<input type="submit" value="중복 검사"/><br/>
		
</div>
</form>
<div id="here">

<c:if test="${!empty DUP }">
	${ID }는 이미 사용 중입니다.
	<script type="text/javascript">
		opener.document.frm.ID.value='';
		
	</script>
</c:if>
<c:if test="${empty DUP }">
	${ID }는 사용가능합니다.
	<input type="button" value="사용" onClick="idOK()"/>
</c:if>
</div>
<script type="text/javascript">

function idOK() {
	opener.document.frm.IDD.value=document.frm.ID.value;
	opener.document.getElementById("IDD").readOnly=true;
	opener.document.frm.idChecked.value="OK";
	self.close();
}
</script>
</body>
</html>