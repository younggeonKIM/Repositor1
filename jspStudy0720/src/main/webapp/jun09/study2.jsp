<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
var a="KOREA"; var b="���ѹα�";
if (a==b) {
	
}
</script>
<body>
<%
	//�ڹٿ��� ���ڿ��� �� (�ǹ� 1:��ġ��, �ǹ� 2:�����)
	String msg1="KOREA"; String msg2="KOREA"; 
	String msg3=new String("KOREA");
	//1. �� ���ڿ��� ��ġ(�ּ�) ��
	if (msg2==msg1) {
		out.print("<h2>����</h2>");
	} else {
		out.print("<h2>�ٸ���</h2>");
	}
	//2. �� ���ڿ��� ���� ��
	if (msg1.equals(msg3)) {
		out.print("<h2>1.����</h2>");
	}else {
		out.print("<h2>1.�ٸ���</h2>");
	}
	if ("KOREA".equals(msg1)) {
		out.print("<h2>2.����</h2>");
	}else {
		out.print("<h2>2.�ٸ���</h2>");
	}
%>
</body>
</html>