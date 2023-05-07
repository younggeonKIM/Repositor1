<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<c:if test="${empty LIST }">
	<h3>��ϵ� �Խñ��� �������� �ʽ��ϴ�.</h3>
</c:if>
<c:if test="${ ! empty LIST }">
	<h2>�Խñ� ���</h2>
	<table>
		<tr><th>�۹�ȣ</th><th>�� ��</th><th>�ۼ���</th>
			<th>�ۼ���</th></tr>
		<c:forEach items="${LIST }" var="bbs">
		<tr><td>${bbs.seqno }</td><td><a href="getBBS.do?NO=${bbs.seqno }">${bbs.title }</a></td>
			<td>${bbs.writer }</td><td>${bbs.date }</td>
		</tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href="getAllBBS.do?PAGE=${page }">${page }</a>
	</c:forEach>
</c:if>
</div>
</body>
</html>