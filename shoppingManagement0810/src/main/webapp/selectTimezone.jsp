<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="myStyle.css">
</head>
<body>
<header>
	<h1 align="center">���θ� ȸ������ ver1.0</h1>
</header>
<menu>
	<jsp:include page="menu_header.jsp"/>
</menu>
<section>
<div align="center">
	<h2 align="center">������ �ð� �Ұ�</h2>
	<p>���Ͻô� ������ �����ϰ� ��ư�� ��������.</p>
	<c:set var="timelist" value="${requestScope.TIMES }"></c:set>
	<form action="resultTime.do" method="post">
	
		<select name="ZONE">
			<c:forEach items="${timelist }" var="name">
				<option>${name }</option>
			</c:forEach>
		</select><br/><br/>
		<input type="submit" value="���ÿϷ�"/>
		<input type="reset" value="�� ��"/>
	</form>
</div>
</section>
<footer>
	<h3 align="center">HRDKOREA copyright 2022 All right reserved</h3>
</footer>
</body>
</html>