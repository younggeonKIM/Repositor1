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
<h2>������� ��ȸ ver1.0</h2>
<form action="selectEmp" method="post" >
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
		<input type="submit" value="�� ȸ" name="btn"/>
		<input type="reset" value="�� ��"/></td></tr>
</table>
</form>
</div>
</body>
</html>