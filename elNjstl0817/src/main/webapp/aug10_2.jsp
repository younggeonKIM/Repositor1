<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="bar" uri="http://taglib5.com" %>
<%@ taglib prefix="rand" uri="http://taglib4.com" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Third Party�� �ۼ��� �±� ���</h2>
<rand:randomValue to="10" from="1"/><br/>
<rand:randomValue to="100" from="1"/><br/>
<bar:Hbar values="7,4,12" fgcolor="red" width="220" 
			labels="�ѱ�, �Ϻ�, �߱�" bgcolor="blue"/><br/>
<bar:Vbar values="7,4,12" fgcolor="red" width="220" 
			labels="�ѱ�, �Ϻ�, �߱�" bgcolor="blue"/>
<h2>���� ��Ȳ</h2>
<bar:Vbar values="110,120,90,140" fgcolor="yellow" width="250" 
			labels="1��, 2��, 3��, 4��" bgcolor="green"/><br/>
<bar:Vbar values="110, 120, 90, 140, 200, 230" fgcolor="yellow" width="350" 
			labels="1��, 2��, 3��, 4��, 5��, 6��" bgcolor="green" 
			height="300"/>
</body>
</html>