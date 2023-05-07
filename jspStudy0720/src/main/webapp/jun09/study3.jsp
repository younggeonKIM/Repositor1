<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>자바의 메서드</h2>
<p>자바스크립트의 함수를 자바에서는 메서드(method)라고 한다.<br/>
자바스크립트에서 함수가 void함수, 리턴함수로 나뉜다.<br/>
자바에서도 메서드가 void메서드, 리턴메서드로 나뉜다.</p>
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
	//void메서드 이름 hello()
	void hello() {
		System.out.print("자바 void 함수입니다.");
	}
	//리턴메서드 이름 sum()이고 정수(int)로 바뀐다.
	int sum() {return 500;} 
	//리턴메서드 이름 data1()이고 실수(double)로 바뀐다.
	double data1() {return 3.14;}
	//리턴메서드 이름 data2()이고 실수(float)로 바뀐다.
	float data2() {return 3.14f;}
	//리턴메서드 이름 data3()이고 문자하나(char)로 바뀐다.
	char data3() {return 'A';}
	//리턴메서드 이름 data4()이고 불린(boolean)으로 바뀐다.
	boolean data4() {return true;}
	//리턴메서드 이름 data5()이고 문자열(String)으로 바뀐다.
	String data5() {return "대한민국";}
	//리턴메서드 이름 data6()이고 문자열(String)으로 바뀐다.
	String data6() {return "KOREA";}
%>
<%
	hello(); //void함수 호출
	int value=sum();
	out.print("<h2>value의 값은 : "+value+"</h2>");
	int value2=sum()+sum()+sum();
	out.print("<h2>value2의 값은 : "+value2+"</h2>");
	double value3= data1();
	out.print("<h2>value3의 값은 : "+value3+"</h2>");
	float value4=data2();
	out.print("<h2>value4의 값은 : "+value4+"</h2>");
	char value5=data3();
	out.print("<h2>value5의 값은 : "+value5+"</h2>");
	boolean value6=data4();
	out.print("<h2>value6의 값은 : "+value6+"</h2>");
	String value7=data5()+data5()+data5();
	out.print("<h2>value7의 값은 : "+value7+"</h2>");
	String value8=data6()+data6()+data6();
	out.print("<h2>value8의 값은 : "+value8+"</h2>");
%>
</body>
</html>