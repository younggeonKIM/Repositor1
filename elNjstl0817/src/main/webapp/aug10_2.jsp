<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="bar" uri="http://taglib5.com" %>
<%@ taglib prefix="rand" uri="http://taglib4.com" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Third Party가 작성한 태그 사용</h2>
<rand:randomValue to="10" from="1"/><br/>
<rand:randomValue to="100" from="1"/><br/>
<bar:Hbar values="7,4,12" fgcolor="red" width="220" 
			labels="한국, 일본, 중국" bgcolor="blue"/><br/>
<bar:Vbar values="7,4,12" fgcolor="red" width="220" 
			labels="한국, 일본, 중국" bgcolor="blue"/>
<h2>매출 상황</h2>
<bar:Vbar values="110,120,90,140" fgcolor="yellow" width="250" 
			labels="1월, 2월, 3월, 4월" bgcolor="green"/><br/>
<bar:Vbar values="110, 120, 90, 140, 200, 230" fgcolor="yellow" width="350" 
			labels="1월, 2월, 3월, 4월, 5월, 6월" bgcolor="green" 
			height="300"/>
</body>
</html>