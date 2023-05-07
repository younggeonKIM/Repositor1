<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:forEach begin="1" end="5">
안녕하세요.<br/>
</c:forEach>
<c:forEach begin="1" end="10" step="2">
반갑습니다.<br/>
</c:forEach>
<c:forEach begin="100" end="105" var="i">
${i }<br/>
</c:forEach>
<%
	String[] menu={"김치찌개", "된장찌개", "순두부찌개"};
%>
<h2>오늘의 점심 메뉴</h2>
<c:forEach items="<%=menu %>" var="lunch">
${lunch }<br/>
</c:forEach>
<c:set var="a" value="100"/>
<c:set var="b" value="100"/>
<c:set var="c" value="${a + b }"/>
${c }<br/>
<c:if test="${a > b }">
첫번째 수가 더 큽니다.
</c:if>
<c:if test="${b > a }">
두번째 수가 더 큽니다.
</c:if>
<c:choose>
	<c:when test="${a>b }">
	첫번째 수가 큽니다.
	</c:when>
	<c:when test="${b>a }">
	두번째 수가 큽니다.
	</c:when>
	<c:otherwise>
	첫번째 수와 두번째 수가 같습니다.
	</c:otherwise>
</c:choose>
<%
// 	int a=100; int b = 200;
// 	int c =a+b;
// 	out.print(c);
%>
</body>
</html>