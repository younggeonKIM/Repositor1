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
<%
	String seq=request.getParameter("SEQ");
%>
<header>
	<h1 align="center">복권 당첨번호 관리 시스템 Ver1.0</h1>
</header>
<menu>
	<jsp:include page="lotto_menu_header.jsp"/>
</menu>
<section>
<form action="lotto_insert.do" method="post" name="frmSubmit" 
		onSubmit="return check(this)">
	<input type="hidden" name="SEQNUM" value="<%=seq %>"/><br/>
	복권 도전자 이름:<input type="text" name="NAME"/><br/>
	복권 도전일 :<input type="date" name="DATE"/><br/>
	복권당첨 추천번호:<input type="text" name="Lotnum" readonly id="Lotnum"/>
<div align="center" id="numbers">예상 로또 번호 :???</div>
<div align="center">
		<input type="button" value="추천받기" onClick="dolotto()"/>
		<input type="submit" value="저 장"/>
		<input type="reset" value="취 소"/>
</div>
</form>
<script type="text/javascript">
function dolotto(mode) {
	var no45=[];
	for (var a=0;a<45;a++) {
		no45[a]=a+1;
	}
	var imsi=-1;
	for (var mix=0;mix<4000;mix++) {
		imsi=no45[0];
		var nansu=parseInt(Math.random()*45);
		no45[0]=no45[nansu];
		no45[nansu]=imsi;
	}
	
	var ppop=0;
	var noSeq1, noSeq2, noSeq3, noSeq4, noSeq5, noSeq6;
	var imsi1, imsi2, imsi3, imsi4, imsi5, imsi6;
	
	for (var b=0;b<6;b++) {
		ppop=ppop+no45[b]+" ";
	}
	noSeq1=no45[0];
	for (var cnt=0; cnt<5; cnt++) {
		if (noSeq1>no45[cnt+1]) {
			noSeq1=no45[cnt+1];
			imsi1=no45[0]; no45[0]=no45[cnt+1]; no45[cnt+1]=imsi1;
		}
	}
	noSeq6=no45[5];
	for (var cnt=5; cnt>0; cnt--) {
		if (noSeq6<no45[cnt-1]) {
			noSeq6=no45[cnt-1]; 
			imsi6=no45[5]; no45[5]=no45[cnt-1]; no45[cnt-1]=imsi6;
		}
	}
	noSeq2=no45[1];
	for (var cnt=0; cnt<4; cnt++) {
		if (noSeq2>no45[cnt+1]) {
			noSeq2=no45[cnt+1]; 
			imsi2=no45[1]; no45[1]=no45[cnt+1]; no45[cnt+1]=imsi2;
		}
	}
	noSeq5=no45[4];
	for (var cnt=4; cnt>0; cnt--) {
		if (noSeq5<no45[cnt-1]) {
			noSeq5=no45[cnt-1]; 
			imsi5=no45[4]; no45[4]=no45[cnt-1]; no45[cnt-1]=imsi5;
		} 
	}
	noSeq3=no45[2];
	for (var cnt=2; cnt<5; cnt++) {
		if (noSeq3>no45[cnt+1]) {
			noSeq3=no45[cnt+1]; 
		} 
	}
	noSeq4=no45[3];
	for (var cnt=3; cnt>0; cnt--) {
		if (noSeq4<no45[cnt-1]) {
			noSeq4=no45[cnt-1];
		} 
	}
	
	var html=""; 
	html=noSeq1+", "+noSeq2+", "+noSeq3+", "+noSeq4+", "+noSeq5+", "+noSeq6;
	document.getElementById("numbers").innerHTML="무작위 뽑은 번호 : "+ppop+
	"<br/><br/><br/>추천드리는 로또 번호 : "+html;
	if(mode==1)
	return html;
	document.getElementById("Lotnum").value=dolotto(1);
}
function check(frm){
	if (frm.NAME.value=='') {
		alert("이름을 입력해 주세요.");
		return false;
	}
	if (frm.DATE.value=='') {
		alert("도전날짜를 달력에서 선택해 주세요.");
		return false;
	}
	if(confirm("정말로 복권 추천 번호를 저장하시겠습니까?")){
		return true;
	}else {
		return false;
	}
}
</script>
</section>
<footer>
	<h3 align="center">YounggeonKim copyright 2022 All right reserved</h3>
</footer>
</body>
</html>