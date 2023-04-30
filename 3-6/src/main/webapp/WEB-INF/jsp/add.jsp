<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemAdd.title"/></title>
</head>
<body>
<form:form modelAttribute="item" action="register.html" method="post" 
			enctype="multipart/form-data" onsubmit="return check(this)">
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
<table>
	<tr height="40px"><th>��ǰID</th><td><form:input path="itemId" cssClass="itemId" maxlength="20"/></td></tr>
	<tr height="40px"><th>��ǰ�̸�</th><td><form:input path="itemName" cssClass="itemName" maxlength="30"/></td></tr>
	<tr height="40px"><th>��ǰ����</th><td><form:input path="price" cssClass="price" maxlength="6"/>��</td></tr>
	<tr height="40px"><th>�̹��� ����</th><td><input type="file" name="pictureUrl"/></td></tr>
	<tr height="40px"><th>��ǰ����</th><td><form:textarea path="info" cssClass="info"/></td></tr>
</table>
	<input type="submit" value="�� ��"/><input type="reset" value="�� ��"/><br/><br/>
</div>
</form:form><a href="index.html">���ư���</a>
<script type="text/javascript">
function check(fm){
	if(fm.itemId.value == ''){
		alert("��ǰ��ȣ�� �Է��ϼ���."); return false;
	}
	if(fm.itemName.value==''){
		alert("��ǰ�̸��� �Է��ϼ���."); return false;
	}
	if(fm.price.value== ''){
		alert("������ �Է��ϼ���."); return false;
	}
	if(fm.pictureUrl.value== ''){
		alert("�̹��� ������ �����ϼ���."); return false;
	}
	if(fm.info.value== ''){
		alert("��ǰ������ �Է��ϼ���."); return false;
	}
	if( ! confirm("�Է��� ������ �½��ϱ�?")) {
		return false;
	}
}
</script>
</body>
</html>