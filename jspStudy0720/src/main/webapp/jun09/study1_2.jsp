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
String res=request.getParameter("R");
if (res.equals("D")) {
	out.print("무승부입니다.");
} else if (res.equals("G")) {
	out.print("축하합니다. 당신의 승리입니다!!!");
} else {
	out.print("안됐네요. 컴퓨터의 승리입니다!!!");
}
// 	String msg="";
// 	switch (res) {
// 	case "D" : out.print("무승부입니다."); break;
// 	case "G" : out.print("축하합니다. 당신의 승리입니다!!!"); break;
// 	case "C" : out.print("안됐네요. 컴퓨터의 승리입니다!!!"); break;
// 	}
%>

</body>
</html>