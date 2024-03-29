<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>장바구니 목록</h2>
<c:if test="${empty LISTS }">
	<h3>장바구니가 비었습니다.</h3>
</c:if>
<c:if test="${ ! empty LISTS }">
	<table>
		<tr><th>상품번호</th><th>상품이름</th><th>상품가격</th><th>원산지</th>
			<th>상품개수</th><th>합 계</th><th>수정/삭제</th></tr>
		<c:forEach items="${LISTS }" var="item">
		<form action="modifyCart.do" method="post" onSubmit="return check(this)">
		<input type="hidden" name="CODE" value="${item.id }"/>
		<tr><td>${item.id }</td><td>${item.name }</td>
			<td><fmt:formatNumber groupingUsed="true">${item.price }</fmt:formatNumber></td>
			<td>${item.origin }</td>
			<td><input type="text" name="NUM" value="${item.num }" size="2"/></td>
			<td><fmt:formatNumber groupingUsed="true">${item.price * item.num }</fmt:formatNumber></td>
			<td><input type="submit" value="수정" name="BTN"/>
				<input type="submit" value="삭제" name="BTN"/></td></tr>
		</form>
		</c:forEach>
	</table>
	<form action="">
	총 계 : <fmt:formatNumber groupingUsed="true">${TOTAL }</fmt:formatNumber>원<input type="submit" value="결제하기"/>
	</form>
</c:if>
</div>
<script type="text/javascript">
function check(f) {
	if(f.NUM.value=='') {
		alert("개수를 입력하세요."); return false;
	}else {
		if(isNaN(f.NUM.value)) {
			alert("개수는 숫자로 입력하세요."); return false;
		}
	}
	if(! confirm("작업을 진행하시겠습니까?")) {
		return false;
	}
}
</script>
</body>
</html>