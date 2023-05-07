<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function doIt() {
	alert ("게임을 시작합니다.");
}
</script>
<div align="center">
<h2>승부차기 게임에 오신 것을 환영합니다~</h2>
<p>킥의 방향을 선택하고 버튼을 누르세요.
<form action="penaltyProcess.jsp" onSubmit="doIt()">
상<input type="radio" name="DIR" value="1"/>
하<input type="radio" name="DIR" value="2"/>
좌<input type="radio" name="DIR" value="3"/>
우<input type="radio" name="DIR" value="4"/>
중<input type="radio" name="DIR" value="5"/><br/><br/>
<input type="submit" value="슛 하기"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>