<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="floraSortDetail.titl"/></title>
<link rel="stylesheet" type="text/css" href="../css/flora_style.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" id="floSortDet">
<h2><spring:message code="floraSortDetail.head"/></h2>
	<h3>${Detail.floname }</h3>
	<table>
		<tr><td><img alt="" src="../img/${Detail.picurl } " width="500px"></td>
			<td align="center">
				<table id="details">
					<tr><th>학명</th><td><c:choose>
										<c:when test="${Detail.acaname eq '미정' || empty Detail.acaname }">
											-
										</c:when>
										<c:otherwise>
											${Detail.acaname }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>영어명</th><td><c:choose>
										<c:when test="${Detail.engname eq '미정' || empty Detail.engname }">
											-
										</c:when>
										<c:otherwise>
											${Detail.engname }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>목</th><td>
									<c:choose>
										<c:when test="${Detail.mok eq '미정' }">
											-
										</c:when>
										<c:otherwise>
											${Detail.mok }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>과</th><td><c:choose>
										<c:when test="${Detail.gwa eq '미정' }">
											-
										</c:when>
										<c:otherwise>
											${Detail.gwa }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>속</th><td><c:choose>
										<c:when test="${Detail.sok eq '미정' }">
											-
										</c:when>
										<c:otherwise>
											${Detail.sok }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>키</th><td><c:choose>
										<c:when test="${Detail.flosize eq '미정' }">
											-
										</c:when>
										<c:otherwise>
											${Detail.flosize }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>꽃 색깔</th><td><c:choose>
										<c:when test="${Detail.color eq '미정' }">
											-
										</c:when>
										<c:otherwise>
											${Detail.color }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>자생지</th><td><c:choose>
										<c:when test="${Detail.habitat eq '미정' }">
											-
										</c:when>
										<c:otherwise>
											${Detail.habitat }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>수명</th><td><c:choose>
										<c:when test="${Detail.life eq '미정' }">
											-
										</c:when>
										<c:otherwise>
											${Detail.life }
										</c:otherwise>
									</c:choose></td></tr>
					<tr><th>개화기</th><td><c:choose>
										<c:when test="${Detail.bloom eq '미정' || empty Detail.bloom }">
											-
										</c:when>
										<c:otherwise>
											${Detail.bloom }
										</c:otherwise>
									</c:choose></td></tr>
					
				</table>
			</td>
	</table>
</div>
</body>
</html>