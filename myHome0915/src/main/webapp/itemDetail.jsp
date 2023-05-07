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
<div align="center">
<h2>상품 상세 정보</h2>
	
	<c:if test="${param.R=='OK' }">
		<script type="text/javascript">
			alert("상품 정보가 수정됐습니다.");
		</script>
	</c:if>
	<c:if test="${param.R=='NOK' }">
		<script type="text/javascript">
			alert("상품 정보 수정하는 데 실패했습니다.");
		</script>
	</c:if>
<form action="updateItem.do" method="post" onSubmit="return check(this)">
	<input type="hidden" name="ID" value="${ITEM.id }"/>
<table>
	<tr><th>상품 번호</th><td><input type="text" name="ID" value="${ITEM.id }" readOnly="readonly"/></td></tr>
	<tr><th>상품 이름</th>
		<td>
			<c:if test="${sessionScope.MANAGER != null }">
				<input type="text" name="NAME" value="${ITEM.name }"/>
			</c:if>
			<c:if test="${sessionScope.MANAGER == null }">
				${ITEM.name }
			</c:if>
		</td></tr>
	<tr><th>상품 가격</th>
		<td>
			<c:if test="${sessionScope.MANAGER != null }">
				<input type="text" name="PRIC" value="${ITEM.pric }"/>
			</c:if>
			<c:if test="${sessionScope.MANAGER == null }">
				${ITEM.pric }
			</c:if>
		</td></tr>
	<tr><th>원산지</th><td><input type="text" name="ORIG" value="${ITEM.orig }" readOnly="readonly"/></td></tr>
	<tr><th>설 명</th>
		<td>
			<c:if test="${sessionScope.MANAGER !=null }">
				<textarea name="SPEC" rows="5" cols="40">
					${ITEM.spec }
				</textarea>
			</c:if>
			<c:if test="${sessionScope.MANAGER == null }">
				<textarea name="SPEC" rows="5" cols="40" readonly="readonly">
					${ITEM.spec }
				</textarea>
			</c:if>
		</td></tr>
	<c:if test="${sessionScope.MANAGER != null }">
		<tr><td colspan="2" align="center">
			<input type="submit" value="수 정"/>
			<input type="reset" value="취 소"/></td></tr>
	</c:if>
</table>
</form>
</div>
<script type="text/javascript">
function check(f) {
	if(f.NAME.value==''){
		alert("상품 이름을 입력해주세요.");
		return false;
	}
	if(f.NAME.value.length>20){
		alert("상품 이름은 20자 이내로 입력해주세요.");
		return false;
	}
	if(isNaN(f.PRIC.value)) {
		alert("상품 가격은 숫자로 입력해주세요.");
		return false;
	}
	if(f.PRIC.value<0){
		alert("상품 가격은 0보다 커야 합니다.");
		return false;
	}
	
	if(!confirm("정말로 수정하시겠습니까?")){
		return false;
	}
}
</script>
</body>
</html>