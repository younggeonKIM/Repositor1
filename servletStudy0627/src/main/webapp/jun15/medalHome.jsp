<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.btn {width : 100px; height: 50px; padding: 10px; font-size: 20px; 
		color: red;}
h2 {border : 1px solid blue; padding:10px; background-color:lightgreen;}

</style>
</head>
<body>
<script type="text/javascript">
function check() {
	if(document.frm.Coun.selectedIndex==0) {
		alert("국가를 선택해주세요.");
		return false;
	}
	var c=confirm("선택하신 게 맞나요?");
	if (! c) return false;
}
</script>
<div align="center">
<h2>올림픽 메달 확인 APP</h2>
<form action="medalServlet.do" onSubmit="return check()" name="frm">
국 가 선 택 : <select name="Coun">
				<option>--메달 확인할 국가를 선택하세요--</option>
				<option value="1">대한민국</option>
				<option value="2">일본</option>
				<option value="3">중국</option>
			</select><br/><br/>
	<input type="submit" value="선택 완료" class="btn"/>
	<input type="reset" value="취 소" class="btn"/>
</form>
</div>
</body>
</html>