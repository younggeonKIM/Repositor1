<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="myStyle.css">
</head>
<body>
<%
	String id=request.getParameter("ID");
%>
<header>
	<h1 align="center">쇼핑몰 회원관리 ver1.0</h1>
</header>
<menu>
	<jsp:include page="menu_header.jsp"/>
</menu>
<section>
	<h2 align="center">홈쇼핑 회원 등록</h2>
	<form action="memberRegister.do" method="post" onSubmit="return check(this)">
	<div align="center">
	<table border="1">
		<tr><th>회원번호(자동발생)</th>
			<td><input type="text" name="ID" readonly value="<%= id %>"/></td></tr>
		<tr><th>회원성명</th><td><input type="text" name="NAME"/></td></tr>
		<tr><th>회원전화</th><td><input type="text" name="TEL"/></td></tr>
		<tr><th>회원주소</th><td><input type="text" name="ADDR"/></td></tr>
		<tr><th>가입일자</th><td><input type="date" name="DATE"/></td></tr>
		<tr><th>고객등급[A:VIP, B:일반, C:직원]</th><td><select name="LEVEL">
													<option value="A">VIP</option>
													<option value="B">일반</option>
													<option value="C">직원</option>
		</select></td></tr>
	<tr><th>도시코드</th><td>
		<select name="CITY">
			<option value="01">서울</option>
			<option value="60">제주</option>
			<option value="30">울릉</option>
		</select>
	<tr><td colspan="2" align="center"><input type="submit" value="등록" name="btn"/>
									<input type="button" value="조회" onClick="doSelect()"/>
									</td></tr>
	</table>
	</div>
	</form>
</section>
<footer>
	<h3 align="center">HRDKOREA copyright 2022 All right reserved</h3>
</footer>
<script type="text/javascript">
function doSelect() {
	if(confirm("정말로 조회하시겠습니까?")) {
		location.href="memberAll.do";
	}
}
function check(frm) {
	if(frm.NAME.value=='') {
		alert("이름을 입력하세요."); return false;
	}
	if(frm.TEL.value=='') {
		alert("전화번호를 입력하세요."); return false;
	}
	if(frm.ADDR.value=='') {
		alert("주소를 입력하세요."); return false;
	}
	if(frm.DATE.value=='') {
		alert("날짜를 입력하세요."); return false;
	}
	if(confirm("입력한 내용이 맞습니까?")) {
		return true;
	}else {return false;}
}
</script>
</body>
</html>