<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
var a="KOREA"; var b="대한민국";
if (a==b) {
	
}
</script>
<body>
<%
	//자바에서 문자열의 비교 (의미 1:위치비교, 의미 2:내용비교)
	String msg1="KOREA"; String msg2="KOREA"; 
	String msg3=new String("KOREA");
	//1. 두 문자열의 위치(주소) 비교
	if (msg2==msg1) {
		out.print("<h2>같다</h2>");
	} else {
		out.print("<h2>다르다</h2>");
	}
	//2. 두 문자열의 내용 비교
	if (msg1.equals(msg3)) {
		out.print("<h2>1.같다</h2>");
	}else {
		out.print("<h2>1.다르다</h2>");
	}
	if ("KOREA".equals(msg1)) {
		out.print("<h2>2.같다</h2>");
	}else {
		out.print("<h2>2.다르다</h2>");
	}
%>
</body>
</html>