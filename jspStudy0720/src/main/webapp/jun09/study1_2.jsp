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
	out.print("���º��Դϴ�.");
} else if (res.equals("G")) {
	out.print("�����մϴ�. ����� �¸��Դϴ�!!!");
} else {
	out.print("�ȵƳ׿�. ��ǻ���� �¸��Դϴ�!!!");
}
// 	String msg="";
// 	switch (res) {
// 	case "D" : out.print("���º��Դϴ�."); break;
// 	case "G" : out.print("�����մϴ�. ����� �¸��Դϴ�!!!"); break;
// 	case "C" : out.print("�ȵƳ׿�. ��ǻ���� �¸��Դϴ�!!!"); break;
// 	}
%>

</body>
</html>