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
String res=request.getParameter("R");
String Id=request.getParameter("ID");
if(res.equals("YES")) {
	out.print("<h2>�α��� �Ǿ����ϴ�. ȯ���մϴ�~"+Id+"��~</h2>");
} else {
	out.print("<h2>�α��� �����߽��ϴ�. ������ ��ȣ�� Ȯ���ϼ���.");
}
%>
</body>
</html>