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
var a=100; var b="���ѹα�"; var c=3.14;
</script>
<%
	//june07.html���� �۽��� �Ķ����(NUM1, NUM2)�� �����Ѵ�.
	String num1=request.getParameter("NUM1");
	String num2=request.getParameter("NUM2");
	int number1=Integer.parseInt(num1);
	int number2=Integer.parseInt(num2);
	int hap=number1+number2; //������ ���
	int sub=number1-number2; //������ ���
	int gop=number1*number2; //������ ���
	int div=number1/number2; //�������� ��� (����/����)
	byte a=100;	float b= 3.14F;
	//�ڹٿ��� ������ �����ϴ� ��쿡��,
	//���� �տ� �ݵ�� �������� ����(data type)�� �����Ѵ�.
	//�ڹٿ��� �������� ����:����(byte, short, int, long),
	//�Ǽ�(float, double), �����ϳ�(char), �Ҹ�(boolean)
%>
<h2 align="center">��Ģ ������ ���</h2><br/>
<ul>
	<li>������ ��� : <%=hap %></li>
	<li>������ ��� : <%=sub %></li>
	<li>������ ��� : <%=gop %></li>
	<li>�������� ��� : <%=div %></li>
</ul>
</body>
</html>