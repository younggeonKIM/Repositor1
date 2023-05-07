<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var a=100; var b="대한민국"; var c=3.14;
</script>
<%
	//june07.html에서 송신한 파라미터(NUM1, NUM2)를 수신한다.
	String num1=request.getParameter("NUM1");
	String num2=request.getParameter("NUM2");
	int number1=Integer.parseInt(num1);
	int number2=Integer.parseInt(num2);
	int hap=number1+number2; //덧셈의 결과
	int sub=number1-number2; //뺄셈의 결과
	int gop=number1*number2; //곱셈의 결과
	int div=number1/number2; //나눗셈의 결과 (정수/정수)
	byte a=100;	float b= 3.14F;
	//자바에서 변수를 선언하는 경우에는,
	//변수 앞에 반드시 데이터의 형태(data type)를 선언한다.
	//자바에서 데이터의 형태:정수(byte, short, int, long),
	//실수(float, double), 문자하나(char), 불린(boolean)
%>
<h2 align="center">사칙 연산의 결과</h2><br/>
<ul>
	<li>덧셈의 결과 : <%=hap %></li>
	<li>뺄셈의 결과 : <%=sub %></li>
	<li>곱셈의 결과 : <%=gop %></li>
	<li>나눗셈의 결과 : <%=div %></li>
</ul>
</body>
</html>