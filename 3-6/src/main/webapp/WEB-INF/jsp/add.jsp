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
	<tr height="40px"><th>상품ID</th><td><form:input path="itemId" cssClass="itemId" maxlength="20"/></td></tr>
	<tr height="40px"><th>상품이름</th><td><form:input path="itemName" cssClass="itemName" maxlength="30"/></td></tr>
	<tr height="40px"><th>상품가격</th><td><form:input path="price" cssClass="price" maxlength="6"/>원</td></tr>
	<tr height="40px"><th>이미지 파일</th><td><input type="file" name="pictureUrl"/></td></tr>
	<tr height="40px"><th>상품설명</th><td><form:textarea path="info" cssClass="info"/></td></tr>
</table>
	<input type="submit" value="등 록"/><input type="reset" value="취 소"/><br/><br/>
</div>
</form:form><a href="index.html">돌아가기</a>
<script type="text/javascript">
function check(fm){
	if(fm.itemId.value == ''){
		alert("상품번호를 입력하세요."); return false;
	}
	if(fm.itemName.value==''){
		alert("상품이름을 입력하세요."); return false;
	}
	if(fm.price.value== ''){
		alert("가격을 입력하세요."); return false;
	}
	if(fm.pictureUrl.value== ''){
		alert("이미지 파일을 선택하세요."); return false;
	}
	if(fm.info.value== ''){
		alert("상품설명을 입력하세요."); return false;
	}
	if( ! confirm("입력한 내용이 맞습니까?")) {
		return false;
	}
}
</script>
</body>
</html>