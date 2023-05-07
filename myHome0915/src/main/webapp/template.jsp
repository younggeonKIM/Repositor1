<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table {width:90%; height:80%; border:1px solid blue; border-collapse:collapse;
		margin-left:20px; margin-right:20px; background-color:lightgreen;}
#content {background-color:wheat;}
#menu {margin-top:10px; margin-left:10px; margin-right:10px;
		margin-bottom:10px; border:1px dashed green; 
		background-color:orange;}
td.main {width:30%; height:300px; border:1px solid black;}
#login {margin-right:10px;}
</style>
</head>
<body onload="startClock()">
<header>
	<h2 align="center"><img alt="" src="logo_1.gif" id ="main_image"></h2>
</header>
<section>
	<table id="body">
		<tr>
			<td class="main">
				<div id="login">
					<c:choose>
						<c:when test="${sessionScope.LOGINID==null &&
										sessionScope.MANAGER==null}">
							<jsp:include page="login.jsp"/>
						</c:when>
						<c:otherwise>
							<jsp:include page="logout.jsp"/>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="menu">
					<a href="template.jsp?BODY=intro.jsp">�� �� ��</a><br/>
					<a href="">�� ������ �ð�</a><br/>
					<c:if test="${sessionScope.MANAGER != null}">
					<a href="MemberAllSelect">�� ȸ����� ��ȸ/����</a><br/>
					</c:if>
					<c:if test="${sessionScope.MANAGER != null}">
						<a href="template.jsp?BODY=noticeInput.jsp">
							<font color="maroon">�� �������� ����</font>
						</a><br/>
					</c:if>					
					<a href="NoticeSelectAllServlet">�� �������� ���</a><br/>
					<c:if test="${sessionScope.LOGINID != null }">
					<a href="template.jsp?BODY=bbsInput.jsp">�� �Խñ� ����</a><br/>
					</c:if>
					<a href="getAllBBS.do">�� �Խñ� ���</a><br/>
					<c:if test="${sessionScope.MANAGER != null}">
						<a href="getNationCodes">
							<font color="maroon">�� ��ǰ ���</font>
						</a><br/>
					</c:if>
					<a href="getAllItems">�� ��ǰ ���</a><br/>
					<c:if test="${sessionScope.LOGINID != null }">
						<a href="cartlist.do">�� ��ٱ��� ����</a><br/>
					</c:if>
					<a href="imageForm.do">�� �̹��� �Խñ� ����</a><br/>
					<a href="">�� �̹��� �Խñ� ���/��� �ޱ�</a><br/>
					
				</div>
			</td>
			<td id="content"><jsp:include page="${param.BODY }"/></td>
		</tr>
	</table>
</section>
<footer>
	<h3 align="center">Copyright 2022. MyHome
		<font color="red"><span id="clock"></span></font></h3>
</footer>
<script type="text/javascript">
function workingClock() {
	var days=["��","��","ȭ","��","��","��","��"];
	var today=new Date();
	var year=today.getFullYear();
	var month=today.getMonth()+1;
	if(month<10) month="0"+month;
	var date= today.getDate();
	if(date<10) date="0"+date;
	var index=today.getDay();
	var day=days[index];
	var hour=today.getHours();
	var min=today.getMinutes();
	if (min<10) min="0"+min;
	var sec=today.getSeconds();
	if(sec<10) sec="0"+sec;
	var str=year+"/"+month+"/"+date+" "+day+" "+hour+":"+min+":"+sec;
	document.getElementById("clock").innerHTML=str;
}
function startClock() {
	workingClock();
	setInterval(workingClock, 1000);
}
</script>
</body>
</html>