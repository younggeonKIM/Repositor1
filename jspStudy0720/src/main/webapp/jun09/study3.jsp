<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�ڹ��� �޼���</h2>
<p>�ڹٽ�ũ��Ʈ�� �Լ��� �ڹٿ����� �޼���(method)��� �Ѵ�.<br/>
�ڹٽ�ũ��Ʈ���� �Լ��� void�Լ�, �����Լ��� ������.<br/>
�ڹٿ����� �޼��尡 void�޼���, ���ϸ޼���� ������.</p>
<script type="text/javascript">
hello(); 
var hap = sum();
function sum() {
	var a=3+6; return a;
}
function hello() {
	var a =100; 
}
</script>
<%!
	//void�޼��� �̸� hello()
	void hello() {
		System.out.print("�ڹ� void �Լ��Դϴ�.");
	}
	//���ϸ޼��� �̸� sum()�̰� ����(int)�� �ٲ��.
	int sum() {return 500;} 
	//���ϸ޼��� �̸� data1()�̰� �Ǽ�(double)�� �ٲ��.
	double data1() {return 3.14;}
	//���ϸ޼��� �̸� data2()�̰� �Ǽ�(float)�� �ٲ��.
	float data2() {return 3.14f;}
	//���ϸ޼��� �̸� data3()�̰� �����ϳ�(char)�� �ٲ��.
	char data3() {return 'A';}
	//���ϸ޼��� �̸� data4()�̰� �Ҹ�(boolean)���� �ٲ��.
	boolean data4() {return true;}
	//���ϸ޼��� �̸� data5()�̰� ���ڿ�(String)���� �ٲ��.
	String data5() {return "���ѹα�";}
	//���ϸ޼��� �̸� data6()�̰� ���ڿ�(String)���� �ٲ��.
	String data6() {return "KOREA";}
%>
<%
	hello(); //void�Լ� ȣ��
	int value=sum();
	out.print("<h2>value�� ���� : "+value+"</h2>");
	int value2=sum()+sum()+sum();
	out.print("<h2>value2�� ���� : "+value2+"</h2>");
	double value3= data1();
	out.print("<h2>value3�� ���� : "+value3+"</h2>");
	float value4=data2();
	out.print("<h2>value4�� ���� : "+value4+"</h2>");
	char value5=data3();
	out.print("<h2>value5�� ���� : "+value5+"</h2>");
	boolean value6=data4();
	out.print("<h2>value6�� ���� : "+value6+"</h2>");
	String value7=data5()+data5()+data5();
	out.print("<h2>value7�� ���� : "+value7+"</h2>");
	String value8=data6()+data6()+data6();
	out.print("<h2>value8�� ���� : "+value8+"</h2>");
%>
</body>
</html>