<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function check() {
	if(document.f.TOWN.selectedIndex==0) {
		alert("������ �����ؾ� �մϴ�.");
		return false;
	}
	var c= confirm("������ ������ �½��ϱ�?");
	if (! c) return false;
}
</script>
<div align="center">
<h2>���� ��õ APP ver1.0</h2>
<h3>������ �����ϰ� ��ư�� ������, ������ ��µ˴ϴ�.</h3>
<form action="matjipFind.do" onSubmit="return check()" name="f">
�� �� : <select name="TOWN">
			<option>--������ �����ϼ���--</option>
			<option value="1">���α�</option>
			<option value="2">������</option>
			<option value="3">������</option>
			<option value="4">������</option>
		</select><br/>
		<input type="submit" value="���� ã��"/>
		<input type="reset" value="�� ��"/>
</form>
</div>
</body>
</html>