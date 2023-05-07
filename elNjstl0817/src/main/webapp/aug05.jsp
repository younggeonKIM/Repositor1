<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>사칙연산 APP ver1.0</h2>
<form action="calculate.do">
첫번째 수를 입력하세요. <input type="text" name="N1"/><br/>
두번째 수를 입력하세요. <input type="text" name="N2"/><br/>
<br/>
<input type="submit" value="결과보기1" name="btn"/>
<input type="submit" value="결과보기1_1" name="btn"/>
<input type="button" value="결과보기2" onClick="doIt()"/>
<input type="reset" value="취 소"/>
</form>
</div>
<form name="frm">

</form>
<script type="text/javascript">
function doIt() {
	document.frm.action="calc.do";
	document.frm.submit();
}
</script>
</body>
</html>