<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="lotto_style.css">
</head>
<body>
<header>
	<h1 align="center">복권 당첨번호 관리 시스템 Ver1.0</h1>
</header>
<menu>
	<jsp:include page="lotto_menu_header.jsp"/>
</menu>
<section>
	<h2 align="center">복권 당첨번호 관리 프로그램</h2>
	<p> 저희 복권 당첨번호 관리 시스템은 복권을 구매하신 고객 여러분들의 당첨을 돕고자
	여러가지 서비스를 하고 있습니다.<br/>
	복권 1등에 당첨될 가능성이 있는 번호를 추천해드립니다.<br/>
	번호는 1부터 45의 숫자를 <b>4000번</b> 섞습니다.<br/>
	섞은 뒤에는 6가지 숫자를 읽어 와서 서비스 이용하시는 고객님께만 알려드립니다.<br/>
	본 서비스는 보안이 훌륭하므로 외부에 노출될 가능성이 적으므로 <i>걱정하지 마세요.</i><br/>
	또한 역대 복권 당첨 결과를 찾아볼 수 있습니다. 1등 당첨금이 얼마였는지
	알아볼 수 있습니다.<br/>
	1등 당첨에 성공하시기를 진심으로 기원합니다.
	<img alt="" src="images/lottonums.jpg" title="로또당첨기원" 
			width="480" height="360">
</section>
<footer>
	<h3 align="center">YounggeonKim copyright 2022 All right reserved</h3>
</footer>
</body>
</html>