<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="menu"/>
<div align="center"><table><tr>

<td><a href="makeTimezone.do">● <fmt:message key="MENU1"/></a>
&nbsp;&nbsp;</td>
<td><a href="memberEntry.do">● <fmt:message key="MENU2"/></a>
&nbsp;&nbsp;</td>
<td><a href="memberAll.do">● <fmt:message key="MENU3"/></a>
&nbsp;&nbsp;</td>
<td><a href="salesAll.do">● <fmt:message key="MENU4"/></a>
&nbsp;&nbsp;</td>
<td><a href="index.jsp">● <fmt:message key="MENU5"/></a>
&nbsp;&nbsp;</td>
<%
	String id=(String)session.getAttribute("LOGINID");
	if(id==null){
%>
<td><a href="login.jsp">● 로그인</a></td>
<%
	}else{
%>
<td>
<table><tr><td>
<font color="red">환영합니다~<br/><%= id %>님</font><br/>
</td></tr></table>
<a href="logout.do">● 로그아웃</a></td>
</div>
<% 
	}
%>
</tr></table>