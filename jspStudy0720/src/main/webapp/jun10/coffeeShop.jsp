<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>Ŀ�� �ֹ� �������� ���� ���� ȯ���մϴ�.</h2>
<h3>���Ͻô� Ŀ�Ǹ� �����ϰ� �ֹ� ��ư�� ��������.</h3>
<form action="coffeeOrder.jsp" method="get">
�Ƹ޸�ī�� <input type="radio" name="MENU" value="A"/>, 
īǪġ�� <input type="radio" name="MENU" value="B"/>, 
ī����� <input type="radio" name="MENU" value="C"/>, 
ī����� <input type="radio" name="MENU" value="D"/>, 
ī���ī <input type="radio" name="MENU" value="E"/><br/>
���� ���� : <select name="NUM">
<%
	for (int cnt=0; cnt<=30 ; cnt++) {
		out.print("<option>"+cnt+"</option>");
	}
%>
</select><br/><br/>
<h3>���Ͻô� ���� �����ϰ� �ֹ� ��ư�� ��������.</h3>
�ֵ��� <input type="radio" name="BREAD" value="A"/>, 
ũ��ƻ� <input type="radio" name="BREAD" value="B"/>, 
ũ���� <input type="radio" name="BREAD" value="C"/>, 
ȣ�л� <input type="radio" name="BREAD" value="D"/>, 
����� <input type="radio" name="BREAD" value="E"/><br/>
���� ���� : <select name="QUAN">
<%
	for (int cnt=0; cnt<=10 ; cnt++) {
		out.print("<option>"+cnt+"</option>");
	}
%>
</select><br/><br/>
<input type="submit" value="�ֹ��ϱ�"/>
<input type="reset" value="�� ��"/>
</form>
</div>
</body>
</html>