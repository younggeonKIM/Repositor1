<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="myStyle.css">
</head>
<body>
<%
	String id=request.getParameter("ID");
%>
<header>
	<h1 align="center">���θ� ȸ������ ver1.0</h1>
</header>
<menu>
	<jsp:include page="menu_header.jsp"/>
</menu>
<section>
	<h2 align="center">Ȩ���� ȸ�� ���</h2>
	<form action="memberRegister.do" method="post" onSubmit="return check(this)">
	<div align="center">
	<table border="1">
		<tr><th>ȸ����ȣ(�ڵ��߻�)</th>
			<td><input type="text" name="ID" readonly value="<%= id %>"/></td></tr>
		<tr><th>ȸ������</th><td><input type="text" name="NAME"/></td></tr>
		<tr><th>ȸ����ȭ</th><td><input type="text" name="TEL"/></td></tr>
		<tr><th>ȸ���ּ�</th><td><input type="text" name="ADDR"/></td></tr>
		<tr><th>��������</th><td><input type="date" name="DATE"/></td></tr>
		<tr><th>�����[A:VIP, B:�Ϲ�, C:����]</th><td><select name="LEVEL">
													<option value="A">VIP</option>
													<option value="B">�Ϲ�</option>
													<option value="C">����</option>
		</select></td></tr>
	<tr><th>�����ڵ�</th><td>
		<select name="CITY">
			<option value="01">����</option>
			<option value="60">����</option>
			<option value="30">�︪</option>
		</select>
	<tr><td colspan="2" align="center"><input type="submit" value="���" name="btn"/>
									<input type="button" value="��ȸ" onClick="doSelect()"/>
									</td></tr>
	</table>
	</div>
	</form>
</section>
<footer>
	<h3 align="center">HRDKOREA copyright 2022 All right reserved</h3>
</footer>
<script type="text/javascript">
function doSelect() {
	if(confirm("������ ��ȸ�Ͻðڽ��ϱ�?")) {
		location.href="memberAll.do";
	}
}
function check(frm) {
	if(frm.NAME.value=='') {
		alert("�̸��� �Է��ϼ���."); return false;
	}
	if(frm.TEL.value=='') {
		alert("��ȭ��ȣ�� �Է��ϼ���."); return false;
	}
	if(frm.ADDR.value=='') {
		alert("�ּҸ� �Է��ϼ���."); return false;
	}
	if(frm.DATE.value=='') {
		alert("��¥�� �Է��ϼ���."); return false;
	}
	if(confirm("�Է��� ������ �½��ϱ�?")) {
		return true;
	}else {return false;}
}
</script>
</body>
</html>