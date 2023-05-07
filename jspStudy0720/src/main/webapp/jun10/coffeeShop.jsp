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
<h2>커피 주문 페이지에 오신 것을 환영합니다.</h2>
<h3>원하시는 커피를 선택하고 주문 버튼을 누르세요.</h3>
<form action="coffeeOrder.jsp" method="get">
아메리카노 <input type="radio" name="MENU" value="A"/>, 
카푸치노 <input type="radio" name="MENU" value="B"/>, 
카페라테 <input type="radio" name="MENU" value="C"/>, 
카페오레 <input type="radio" name="MENU" value="D"/>, 
카페모카 <input type="radio" name="MENU" value="E"/><br/>
수량 선택 : <select name="NUM">
<%
	for (int cnt=0; cnt<=30 ; cnt++) {
		out.print("<option>"+cnt+"</option>");
	}
%>
</select><br/><br/>
<h3>원하시는 빵을 선택하고 주문 버튼을 누르세요.</h3>
핫도그 <input type="radio" name="BREAD" value="A"/>, 
크루아상 <input type="radio" name="BREAD" value="B"/>, 
크림빵 <input type="radio" name="BREAD" value="C"/>, 
호밀빵 <input type="radio" name="BREAD" value="D"/>, 
고로케 <input type="radio" name="BREAD" value="E"/><br/>
수량 선택 : <select name="QUAN">
<%
	for (int cnt=0; cnt<=10 ; cnt++) {
		out.print("<option>"+cnt+"</option>");
	}
%>
</select><br/><br/>
<input type="submit" value="주문하기"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>