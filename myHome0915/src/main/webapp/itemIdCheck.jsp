<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">��ǰ��ȣ �ߺ� Ȯ��</h2>
<form action="itemIdCheck.do" name="frm">
	��ǰ ��ȣ : <input type="text" name="ID" value="${ID }"/>
	<input type="submit" value="�ߺ� �˻�"/>
</form>
<c:if test="${ ! empty DUP }">
	${ID } �� �̹� ��� ���Դϴ�.
	<script type="text/javascript">
		opener.document.frm.ID.value='';
	</script>
</c:if>
<c:if test="${empty DUP }">
	${ID } �� ��� �����մϴ�.
	<input type="button" value="���" onClick="idOK()"/>
</c:if>
<script type="text/javascript">
function idOK() {
	opener.document.frm.ID.value=document.frm.ID.value;
	opener.document.frm.idChecked.value="OK";
	opener.document.getElementById("ID").readOnly=true;
	self.close();
}
</script>
</body>
</html>