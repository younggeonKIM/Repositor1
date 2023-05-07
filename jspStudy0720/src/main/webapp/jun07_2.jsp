<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">

</script>
<body>
<%
	int gamer=(int) ((Math.random()*6)+1);//1부터 6까지 난수가 필요
	int com=(int) ((Math.random()*6)+1);
	if(gamer>com) {//게이머 승
%>
게이머 승 !! <%=gamer %> vs <%=com %>
<%
	}else if(gamer==com) {//무승부
%>
무승부 !! <%=gamer %> vs <%=com %>
<%
	} else {//컴퓨터 승
%>
컴퓨터 승!! <%=gamer %> vs <%=com %>
<%
	}
%>
</body>
</html>