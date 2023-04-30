<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="floraIndex.titl"></spring:message></title>
<link rel="stylesheet" type="text/css" href="../css/flora_style.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="florind">
<h2 align="center"><spring:message code="floraIndex.head"/></h2>
	<div class="para">
		<p>식물 정보 총망라 사이트에 오신 것을 환영합니다.<br/>
		본 사이트에서는 식물 종류 보기와 식물 상세 보기 그리고 주제별 식물 이름을 검색해 볼 수 있습니다.<br/>
		식물들을 좋아하시는 분들은 꼭 저희 총망라 사이트에 들르셔서 다양한 정보 얻어가시기 바랍니다.</p>
	</div>
<div class="florimags">
	<section>
		<div class="inner">
			<div class="uchae">
				<div class="inner">
					<div class="title">유채꽃</div>
				</div>
				<div class="uchae_wrap">
					<a href=""></a>
				</div>
			</div>
			<div class="pinkmuhly">
				<div class="inner">
					<div class="title">핑크뮬리</div>
				</div>
				<div class="pinkmuhly_wrap">
					<a href=""></a>
				</div>
			</div>
			<div class="mugunghwa">
				<div class="inner">
					<div class="title">무궁화</div>
				</div>
				<div class="mugunghwa_wrap">
					<a href=""></a>
				</div>
			</div>
		</div>
	</section>
</div>
</div>
</body>
</html>