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
�ȳ��ϼ���.<br/>
</c:forEach>
<c:forEach begin="1" end="10" step="2">
�ݰ����ϴ�.<br/>
</c:forEach>
<c:forEach begin="100" end="105" var="i">
${i }<br/>
</c:forEach>
<%
	String[] menu={"��ġ�", "�����", "���κ��"};
%>
<h2>������ ���� �޴�</h2>
<c:forEach items="<%=menu %>" var="lunch">
${lunch }<br/>
</c:forEach>
<c:set var="a" value="100"/>
<c:set var="b" value="100"/>
<c:set var="c" value="${a + b }"/>
${c }<br/>
<c:if test="${a > b }">
ù��° ���� �� Ů�ϴ�.
</c:if>
<c:if test="${b > a }">
�ι�° ���� �� Ů�ϴ�.
</c:if>
<c:choose>
	<c:when test="${a>b }">
	ù��° ���� Ů�ϴ�.
	</c:when>
	<c:when test="${b>a }">
	�ι�° ���� Ů�ϴ�.
	</c:when>
	<c:otherwise>
	ù��° ���� �ι�° ���� �����ϴ�.
	</c:otherwise>
</c:choose>
<%
// 	int a=100; int b = 200;
// 	int c =a+b;
// 	out.print(c);
%>
</body>
</html>