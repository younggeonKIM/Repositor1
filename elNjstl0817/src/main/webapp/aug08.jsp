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
	//이벤트 당첨자의 이름을 배열에 저장
	String[] winner={"홍길동","김철수","박동혁"};
	//이벤트 상품이름을 배열에 저장
	String[] gift={"대형TV","대형냉장고","대형세탁기"};
	//당첨자 명단과 상품명을 JSP(winner.jsp)에서 출력
	//1.Redirect, 2.Forward, 3.둘 다 --> Forward만 가능
	request.setAttribute("W", winner);
	request.setAttribute("G", gift);
	RequestDispatcher r=request.getRequestDispatcher("winner.jsp");
	r.forward(request, response);
%>
</body>
</html>