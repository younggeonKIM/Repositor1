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
switch (resu) {
case "G": out.print("�����մϴ�. ���߼̽��ϴ�."); break;
case "C": out.print("�ƽ��Ե� ������ ���ϼ̽��ϴ�."); break;
}
%>
</body>
</html>