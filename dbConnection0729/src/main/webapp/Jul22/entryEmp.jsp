<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
<h2>������� ��� ver1.0</h2>
<form action="registerEmp" method="post" onSubmit="return check(this)">
<table border="1">
	<tr><th>�� ��</th><td><input type="text" name="ID"/></td></tr>
	<tr><th>��</th><td><input type="text" name="FIRST"/></td></tr>
	<tr><th>�̸�</th><td><input type="text" name="LAST"/></td></tr>
	<tr><th>�̸���</th><td><input type="text" name="EMAIL"/></td></tr>
	<tr><th>����ó</th><td><input type="text" name="TEL"/></td></tr>
	<tr><th>�Ի���</th><td><input type="date" name="HIRE"/></td></tr>
	<tr><th>�����ڵ�</th><td><select name="JOB">
							<option>IT_PROG</option><option>SA_REP</option>
							</select></td></tr>
	<tr><th>�� ��</th><td><input type="text" name="SALARY"/></td></tr>
	<tr><th>Ŀ�̼�</th><td><input type="text" name="COMM"/></td></tr>
	<tr><th>������ ���</th><td><input type="text" name="MAN"/></td></tr>
	<tr><th>�μ���ȣ</th><td><input type="text" name="DEPT"/></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="�� ��" name="btn"/>
		<input type="submit" value="�� ��" name="btn"/>
		<input type="submit" value="�� ��" name="btn"/>
		<input type="reset" value="�� ��"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function check() {
	if (f.ID.value=='') {
		alert ("����� �Է��ϼ���."); return false;
	}
	if (f.FIRST.value=='') {
		alert ("���� �Է��ϼ���."); return false;
	}
	if (f.LAST.value=='') {
		alert ("�̸��� �Է��ϼ���."); return false;
	}
	if (f.EMAIL.value=='') {
		alert ("�̸����� �Է��ϼ���."); return false;
	}
	if (f.HIRE.value== '') {
		alert ("�Ի����� �Է��ϼ���."); return false;
	}
	if (f.SALARY.value== '') {
		alert ("������ �Է��ϼ���."); return false;
	}
	if (f.MAN.value=='') {
		alert ("������ ����� �Է��ϼ���."); return false;
	}
	if(f.DEPT.value=='') {
		alert ("�μ� ��ȣ�� �Է��ϼ���."); return false;
	}
	if (confirm("������ ����Ͻðڽ��ϱ�?")) return true;
	else return false;
}
</script>
</body>
</html>