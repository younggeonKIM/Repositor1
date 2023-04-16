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
	<h1 align="center">���� ��÷��ȣ ���� �ý��� Ver1.0</h1>
</header>
<menu>
	<jsp:include page="lotto_menu_header.jsp"/>
</menu>
<section>
<form action="lotto_insert.do" method="post" name="frmSubmit" 
		onSubmit="return check(this)">
	<input type="hidden" name="SEQNUM" value="<%=seq %>"/><br/>
	���� ������ �̸�:<input type="text" name="NAME"/><br/>
	���� ������ :<input type="date" name="DATE"/><br/>
	���Ǵ�÷ ��õ��ȣ:<input type="text" name="Lotnum" readonly id="Lotnum"/>
<div align="center" id="numbers">���� �ζ� ��ȣ :???</div>
<div align="center">
		<input type="button" value="��õ�ޱ�" onClick="dolotto()"/>
		<input type="submit" value="�� ��"/>
		<input type="reset" value="�� ��"/>
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
	document.getElementById("numbers").innerHTML="������ ���� ��ȣ : "+ppop+
	"<br/><br/><br/>��õ�帮�� �ζ� ��ȣ : "+html;
	if(mode==1)
	return html;
	document.getElementById("Lotnum").value=dolotto(1);
}
function check(frm){
	if (frm.NAME.value=='') {
		alert("�̸��� �Է��� �ּ���.");
		return false;
	}
	if (frm.DATE.value=='') {
		alert("������¥�� �޷¿��� ������ �ּ���.");
		return false;
	}
	if(confirm("������ ���� ��õ ��ȣ�� �����Ͻðڽ��ϱ�?")){
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