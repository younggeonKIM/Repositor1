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
<form action="loginProcess.jsp" method="post">
<p>계정과 암호를 입력하고, 로그인 버튼을 누르세요</p>
계 정 : <input type="text" name="ID" size="10"/><br/>
암 호 : <input type="password" name="PWD" size="10"/><br/>
<br/>
<input type="submit" value="로그인"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>