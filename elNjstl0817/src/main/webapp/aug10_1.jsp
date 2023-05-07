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
원래의 문자열 : ${msg }<br/>
모두 대문자로 : ${fn:toUpperCase(msg) }<br/>
모두 소문자로 : ${fn:toLowerCase(msg) }<br/>
Are의 위치? : ${fn:indexOf(msg,"Are") }<br/>
Are를 Were로 교체 : ${fn:replace(msg, "Are", "Were") }<br/>
문자열의 길이 : ${fn:length(msg) }<br/>
</body>
</html>