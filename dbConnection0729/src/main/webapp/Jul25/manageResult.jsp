<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String result=request.getParameter("R");
	if(result.equals("OK")) {
%>
<script type="text/javascript">
		alert("�۾��� �Ϸ�Ǿ����ϴ�.");
		location.href="entryEmp.jsp"; //������ �̵�
</script>
<% 	}else {
%>
<script type="text/javascript">
		alert("�۾� �� ������ �߻��߽��ϴ�.");
		location.href="entryEmp.jsp"; //������ �̵�
</script>
<%
	}
%>
</body>
</html>