<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�� üũ�� �̿��� ȭ�� ����</h2>
<form action="study2_1.jsp" name="frm" onSubmit="return check()">
�̸�: <input type="text" name="NAME"/><br/>
	<input type="submit" value="OK"/>
</form>
<script type="text/javascript">
function check() {
	if (document.frm.NAME.value=="") {
		alert("�̸��� �ݵ�� �Է��ؾ� �մϴ�.");
		return false;
	} else {
		return true;
	}
}
</script>
</body>
</html>