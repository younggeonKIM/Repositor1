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
function Check() {
	if(document.frm.COLOR.selectedIndex==0) {
		alert("���� �����ؾ� �մϴ�.");
		return false;
	} else {
		return true;
	}
}
</script>
<div align="center">
<h2>���� ��õ APP ver1.0</h2>
<h3>���� ��õ APP�� ���� ���� ȯ���մϴ�~ ���ϴ� ���� �����ϰ�, ��ư�� ������ �ش� ���� ���ְ�
��õ�˴ϴ�.</h3>
<form action="beerselect3.do" name="frm" onSubmit="return Check()">
�� ����: <select name="COLOR">
			<option>--�����ϼ���--</option>
			<option value="DARK">��ο� ��</option>
			<option value="LIGHT">���� ��</option>
			<option value="YELLOW">�����</option>
			<option value="BROWN">����</option>
</select><br/><br/>
<input type="submit" value="���� �Ϸ�"/>
<input type="reset" value="�� ��"/>
</form>
</div>
</body>
</html>