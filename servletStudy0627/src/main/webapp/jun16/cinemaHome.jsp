<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
div {border:1px solid blue;}
h2 {border:1px solid blue; padding:5px; margin-left:50px; margin-right:50px;
	background-color:lightgreen; }
form, select {font-size:20px;}
.btn {width:120px; height:40px; font-size:16px;}

</style>
</head>
<body>
<script type="text/javascript">
function check() {
	if (document.frm.GENRE.selectedIndex==0) {
		alert ("영화의 장르를 선택해 주세요.");
		return false;
	}
	var c=confirm("선택하신 장르가 맞나요?");
	if (! c) {return false;}
}
</script>
<div align="center">
<h2>영화 추천 APP ver1.0</h2>
<h3>원하시는 장르를 선택하고, 버튼을 누르세요.</h3>
<form action="findCinema.do" onSubmit="return check()" name="frm">
장르 선택 : <select name="GENRE">
				<option>--선택하세요--</option>
				<option value="1">공 포</option>
				<option value="2">전 쟁</option>
				<option value="3">코미디</option>
				<option value="4">스릴러</option>
				<option value="5">드라마</option>
			</select><br/><br/>
<input type="submit" value="추천영화 보기" class="btn"/>
<input type="reset" value="취 소" class="btn"/><br/><br/>
</form>
</div>
</body>
</html>