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
	int gamer=(int) ((Math.random()*6)+1);//1���� 6���� ������ �ʿ�
	int com=(int) ((Math.random()*6)+1);
	if(gamer>com) {//���̸� ��
%>
���̸� �� !! <%=gamer %> vs <%=com %>
<%
	}else if(gamer==com) {//���º�
%>
���º� !! <%=gamer %> vs <%=com %>
<%
	} else {//��ǻ�� ��
%>
��ǻ�� ��!! <%=gamer %> vs <%=com %>
<%
	}
%>
</body>
</html>