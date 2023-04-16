<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String resu=request.getParameter("R");
	if (resu.equals("OK")) {
%>
<script type="text/javascript">
	alert("복권 추천 번호의 등록이 완료되었습니다.");
	location.href="lotto_index.jsp";
</script>
<%
}else {
%>
<script type="text/javascript">
	alert("복권 추천 번호의 등록이 실패했습니다.");
	location.href="lotto_index.jsp";
	
</script>
<%
}
%>
</body>
</html>