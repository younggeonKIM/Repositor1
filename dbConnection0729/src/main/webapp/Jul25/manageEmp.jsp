<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import= "jul25.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Employee e = (Employee)request.getAttribute("EMP");
%>
<div align="center">
<script type="text/javascript">
function check() {
	if(confirm("�۾��� �����Ͻðڽ��ϱ�?")) {
		return true;
	}else {
		return false;
	}
}
</script>
<h2>�� �� �� �� �� ��</h2>
<form action="manageDo" method="post" onSubmit="return check(this)">
	<input type="hidden" name="ID" value="<%= e.getEmp_id() %>"/>;
<table border="1">
	<tr><th>�� ��</th><td><%= e.getEmp_id() %></td></tr>
	<tr><th>��</th><td><input type="text" name="FIRST" value="<%= e.getFirst_name() %>"/>
	</td></tr>
	<tr><th>�� ��</th><td><input type="text" name="NAME" value="<%= e.getLast_name() %>"/>
	</td></tr>
	<tr><th>�̸���</th><td><input type="text" name="EMAIL" value="<%= e.getEmail() %>"/>
	</td></tr>
	<tr><th>����ó</th><td><input type="text" name="TEL" value="<%= e.getPhone() %>"/>
	</td></tr>
	<tr><th>�Ի���</th><td><input type="date" name="HIRE" value="<%= e.getHire_date() %>"/>
	</td></tr>
	<tr><th>�����ڵ�</th><td><input type="text" name="JOB" value="<%= e.getJob_id() %>"/>
	</td></tr>
	<tr><th>�� ��</th><td><input type="text" name="SALARY" value="<%= e.getSalary() %>"/>
	</td></tr>
	<tr><th>Ŀ�̼�</th><td><input type="text" name="COMM" value="<%= e.getComm() %>"/></td></tr>
	<tr><th>������ ���</th><td><input type="text" name="MAN" value="<%= e.getManager_id() %>"/>
	</td></tr>
	<tr><th>�μ� ��ȣ</th><td><input type="text" name="DEPT" value="<%= e.getDept_id() %>"/>
	</td></tr>
	<tr><td colspan="2" align="center">
	<input type="submit" value="����" name="btn"/>
	<input type="submit" value="����" name="btn"/></td></tr>
</table>
</form>
</div>
</body>
</html>