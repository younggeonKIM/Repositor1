<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="../flosort/flosort.html">식물 종류 보기</a>&nbsp;&nbsp;&nbsp;
<a href="../present/present.html">꽃 선물 정보 보기</a>&nbsp;&nbsp;&nbsp;
<a href="../search/">검색하기</a>&nbsp;&nbsp;&nbsp;
<a href="../index/index.html">홈으로</a>
<div align="right">
<c:choose>
	<c:when test="${not empty loginMemb }">
		<font color="red">환영합니다~ ●${loginMemb.membId }님<br/>
		<a href="../logoutview/logout.html">로그아웃하기</a>
		</font>
	</c:when>
	<c:when test="${empty loginMemb }">
		<font color="red">
		<a href="../loginview/login.html">로그인하기</a>
		</font>
	</c:when>
</c:choose>
</div>