<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
*��÷�� ����� ������ �����ϴ�. *<br/>
1.${requestScope.W[0] }<br/>
2.${requestScope.W[1] }<br/>
3.${requestScope.W[2] }<br/>
*��ǰ ����� ������ �����ϴ�. *<br/>
1. ${requestScope.G[0] }<br/>
2. ${requestScope.G[1] }<br/>
3. ${requestScope.G[2] }<br/>
<%
// 	String [] name= (String [])request.getAttribute("W"); //��÷�� ���
// 	String [] goods= (String [])request.getAttribute("G"); //��ǰ ���
	
// 	out.print("��÷�ڸ���� ������ �����ϴ�.");
// 	for(int i=0;i<name.length;i++) {
// 		out.print(name[i]+"<br/>");
// 	}
// 	out.print("��ǰ�� ������ �����ϴ�.");
// 	for(int i=0; i<goods.length; i++) {
// 		out.print(goods[i]+"<br/>");
// 	}
%>
</body>
</html>