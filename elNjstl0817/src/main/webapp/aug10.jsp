<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<fmt:setBundle basename="intro"/>
<h1><fmt:message key="TITLE"/></h1>
<h3><fmt:message key="GREETING"/></h3>
<p>
<fmt:message key="BODY"/></p>
<h3><font color="red"><fmt:message key="FOOTER"/></font></h3>

</body>
</html>