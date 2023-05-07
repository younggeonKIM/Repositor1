<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function popupAlert() {
	setTimeout(function(){alert("로그인 되었습니다.");} , 100);
}
</script>
<div align="center">
<h2>상 품 목 록</h2>
<table width="100%">
	<tr><th>상품번호</th><th>상품이름</th><th>가 격</th>
		<th>원산지</th><th>선 택</th></tr>
		<c:forEach items="${AL }" var="item">
			<tr><td>${item.id }</td>
			<td><a href="getItem?ID=${item.id }">${item.name }</a></td>
			<td>${item.pric }</td><td>${item.orig }</td>
			<td><a href="#" 
			onClick="window.open('addCart.do?CODE=${item.id }', 'my_cart', 'width=400, height=300')">장바구니 담기</a></td></tr>
		</c:forEach>
</table>
<c:forEach begin="1" end="${PAGES }" var="page">
	<a href="getAllItems?PAGENO=${page }">${page }</a>
</c:forEach>
</div>
<c:if test="${requestScope.R>0 }">
	<script type="text/javascript">
		alert("상품이 등록되었습니다.");
	</script>
</c:if>
<c:if test="${requestScope.R<1 }">
	<script type="text/javascript">
		alert("상품이 등록되지 않았습니다. 관리자에게 문의하세요.");
	</script>
</c:if>
</body>
</html>