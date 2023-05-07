<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>JSTL의 지역과 시간대를 바꾸는 기능</h2>
<c:set value="<%= new Date() %>" var="today"/>
<h3>대한민국</h3>
금액:<fmt:formatNumber value="3300000" type="currency"
					currencySymbol="￦"/><br/> <%-- 대한민국은 화폐기호를 넣어줘야 함 --%>
일시:<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
<h3>일 본</h3>
<fmt:setLocale value="ja_jp"/> <%-- 언어코드_국가코드를 입력 --%>
금액:<fmt:formatNumber value="3300000" type="currency"/><br/>
일시:<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
<h3>미 국</h3>
<fmt:setLocale value="en_us"/>
금액:<fmt:formatNumber value="3300000" type="currency"/><br/>
일시:<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
<h3>러시아</h3>
<fmt:setLocale value="ru_ru"/>
금액:<fmt:formatNumber value="3300000" type="currency"/><br/>
일시:<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/><br/>
				
<fmt:setLocale value="ko_kr"/> <%-- 대한민국 지역으로 변경해서 언어코드를 변경--%>
<%
	String[] timelist = TimeZone.getAvailableIDs();
	for(int i =0; i<timelist.length ; i++){
		out.print(timelist[i]+"<br/>");
	}
%>
<h3>서울의 현재 시간</h3>
서울 : <fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
<h3>홍콩의 현재 시간</h3>
<fmt:timeZone value="Asia/Hong_Kong"> <%-- 지역이름 / 도시이름 --%>
<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
</fmt:timeZone>
<h3>런던의 현재 시간</h3>
<fmt:timeZone value="Europe/London">
<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
</fmt:timeZone>
<h3>두바이의 현재 시간</h3>
<fmt:timeZone value="Asia/Dubai">
<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
</fmt:timeZone>
</body>
</html>