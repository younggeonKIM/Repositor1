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
	String resu=request.getParameter("R");
	if (resu.equals("OK")) {
%>
<script type="text/javascript">
	alert("���� ��õ ��ȣ�� ����� �Ϸ�Ǿ����ϴ�.");
	location.href="lotto_index.jsp";
</script>
<%
}else {
%>
<script type="text/javascript">
	alert("���� ��õ ��ȣ�� ����� �����߽��ϴ�.");
	location.href="lotto_index.jsp";
	
</script>
<%
}
%>
</body>
</html>