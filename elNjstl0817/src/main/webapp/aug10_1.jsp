<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:set var="msg" value="How Are You?"/>
������ ���ڿ� : ${msg }<br/>
��� �빮�ڷ� : ${fn:toUpperCase(msg) }<br/>
��� �ҹ��ڷ� : ${fn:toLowerCase(msg) }<br/>
Are�� ��ġ? : ${fn:indexOf(msg,"Are") }<br/>
Are�� Were�� ��ü : ${fn:replace(msg, "Are", "Were") }<br/>
���ڿ��� ���� : ${fn:length(msg) }<br/>
</body>
</html>