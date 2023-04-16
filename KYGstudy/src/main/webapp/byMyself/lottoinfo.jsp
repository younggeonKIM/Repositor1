<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, lotto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="lotto_style.css">
</head>
<body>
<header>
	<h1 align="center">복권 당첨번호 관리 시스템 Ver1.0</h1>
</header>
<menu>
	<jsp:include page="lotto_menu_header.jsp"/>
</menu>
<section>
	<div align="center">
	<h2 align="center">당첨 추천번호 조회 결과</h2>
	<form action="" method="post">
		<table border="1"><tr><th>일련번호</th><th>이름</th><th>복권등수</th>
								<th>복권당첨 추천번호</th><th>추천일</th></tr>
<%
	ArrayList arli=(ArrayList) request.getAttribute("AL");
	int count=arli.size();	
	for (int i=0;i<count;i++) {
		Lotnum ltnm=(Lotnum)arli.get(i);
%>
						<tr><td><%= ltnm.getLotSeq() %></td><td><%= ltnm.getName() %></td><td><%= ltnm.getGrade() %>
						</td><td><%= ltnm.getNums() %></td><td><%= ltnm.getDate() %></td></tr>	
<%
}
%>
		</table>
<%
	out.println("&nbsp;&nbsp;");
	int pages = (int)request.getAttribute("PAGE");
	int i;
	for(i = 1; i<= pages ; i++){
		if(pages==1){
			out.println("<span>["+i+"]</span>");
		}
		else{
			out.println("<span><a href='lottoinfo.do?PNUM="+i+"'>"+i+"</a></span>");
		}
	}
	out.println("&nbsp;&nbsp;");
%>
	
	</form>
	</div>
</section>
<footer>
	<h3 align="center">YounggeonKim copyright 2022 All right reserved</h3>
</footer>
</body>
</html>