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
	//��ǻ�͸� ���ؼ� ������ ���Ѵ�. (1~3)
	int com=(int)((Math.random()*3)+1);
	String gamer=request.getParameter("GAMER");
	//���ڿ��� ������ �ٲ۴�.
	int gamerInt=Integer.parseInt(gamer);
	String result="";
	if (com==gamerInt) {//���º��� ���
		result="D";
	} else if (com==1&&gamerInt==2||com==2&&gamerInt==3||
				com==3&&gamerInt==1) {//���̸Ӱ� �̱� ���
		result="G";
	}
	else {//��ǻ�Ͱ� �̱� ���
		result="C";
	}
	response.sendRedirect("study1_2.jsp?R="+result);
%>
</body>
</html>