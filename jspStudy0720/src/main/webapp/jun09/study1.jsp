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
<h2>가위, 바위, 보 게임 APP ver1.0</h2>
<p>가위, 바위, 보 중 하나를 선택하고 버튼을 입력하세요.</p>
<form action="study1_1.jsp" method="get">
가위 : <input type="radio" name="GAMER" value="1"/>
바위 : <input type="radio" name="GAMER" value="2"/>
보 : <input type="radio" name="GAMER" value="3"/><br/><br/>
<input type="submit" value="결과 보기"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>