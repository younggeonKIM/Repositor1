<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="member.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="myStyle.css">
</head>
<body>
<header>
	<h1 align="center">���θ� ȸ������ ver1.0</h1>
</header>
<menu>
	<jsp:include page="menu_header.jsp"/>
</menu>
<section>
	<h2 align="center">Ȩ���� ȸ�� ���� ����</h2>
	<div align="center">
	<form action="memberUpdate.do" method="post" onSubmit="return check(this)">
	<table border="1">
<%
	Member mem = (Member)request.getAttribute("MEM");
	
%>
	<tr><th>ȸ����ȣ</th><td>
				<input type="text" name="ID" readonly value="<%=mem.getCustno()%>"/>
				</td></tr>
	<tr><th>ȸ������</th><td>
				<input type="text" name="NAME" value="<%=mem.getName()%>"/></td></tr>
	<tr><th>ȸ����ȭ</th><td>
				<input type="text" name="TEL" value="<%=mem.getTel()%>"/></td></tr>
	<tr><th>ȸ���ּ�</th><td>
				<input type="text" name="ADDR" value="<%=mem.getAddr()%>"/></td></tr>
	<tr><th>��������</th><td>
				<input type="date" name="DATE" value="<%=mem.getDate()%>"/></td></tr>
	<tr><th>�����[A:VIP, B:�Ϲ�, C:����]</th><td>
				<input type="text" name="LEVEL" value="<%=mem.getGrade()%>"/></td></tr>
	<tr><th>�����ڵ�</th><td>
				<input type="text" name="CITY" value="<%=mem.getCode()%>"/></td></tr>
	<tr><td colspan="2" align="center">
				<input type="submit" value="����" name="btn"/>
				<input type="submit" value="��ȸ" name="btn"/></td></tr>
	</table>
	</form>
	</div>
</section>
<footer>
	<h3 align="center">HRDKOREA copyright 2022 All right reserved</h3>
</footer>
<script type="text/javascript">
function check() {
	if(confirm("�۾��� �����Ͻðڽ��ϱ�?")) {
		return true;
	}else {
		return false;
	}
}
</script>
</body>
</html>