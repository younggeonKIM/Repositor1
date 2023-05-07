<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>폼 체크를 이용한 화면 설계</h2>
<form action="study2_1.jsp" name="frm" onSubmit="return check()">
이름: <input type="text" name="NAME"/><br/>
	<input type="submit" value="OK"/>
</form>
<script type="text/javascript">
function check() {
	if (document.frm.NAME.value=="") {
		alert("이름은 반드시 입력해야 합니다.");
		return false;
	} else {
		return true;
	}
}
</script>
</body>
</html>