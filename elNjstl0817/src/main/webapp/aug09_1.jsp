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
<h2>JSTL�� ������ �ð��븦 �ٲٴ� ���</h2>
<c:set value="<%= new Date() %>" var="today"/>
<h3>���ѹα�</h3>
�ݾ�:<fmt:formatNumber value="3300000" type="currency"
					currencySymbol="��"/><br/> <%-- ���ѹα��� ȭ���ȣ�� �־���� �� --%>
�Ͻ�:<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
<h3>�� ��</h3>
<fmt:setLocale value="ja_jp"/> <%-- ����ڵ�_�����ڵ带 �Է� --%>
�ݾ�:<fmt:formatNumber value="3300000" type="currency"/><br/>
�Ͻ�:<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
<h3>�� ��</h3>
<fmt:setLocale value="en_us"/>
�ݾ�:<fmt:formatNumber value="3300000" type="currency"/><br/>
�Ͻ�:<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
<h3>���þ�</h3>
<fmt:setLocale value="ru_ru"/>
�ݾ�:<fmt:formatNumber value="3300000" type="currency"/><br/>
�Ͻ�:<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/><br/>
				
<fmt:setLocale value="ko_kr"/> <%-- ���ѹα� �������� �����ؼ� ����ڵ带 ����--%>
<%
	String[] timelist = TimeZone.getAvailableIDs();
	for(int i =0; i<timelist.length ; i++){
		out.print(timelist[i]+"<br/>");
	}
%>
<h3>������ ���� �ð�</h3>
���� : <fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
<h3>ȫ���� ���� �ð�</h3>
<fmt:timeZone value="Asia/Hong_Kong"> <%-- �����̸� / �����̸� --%>
<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
</fmt:timeZone>
<h3>������ ���� �ð�</h3>
<fmt:timeZone value="Europe/London">
<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
</fmt:timeZone>
<h3>�ι����� ���� �ð�</h3>
<fmt:timeZone value="Asia/Dubai">
<fmt:formatDate value="${today }" type="both" timeStyle="full"
					dateStyle="full"/><br/>
</fmt:timeZone>
</body>
</html>