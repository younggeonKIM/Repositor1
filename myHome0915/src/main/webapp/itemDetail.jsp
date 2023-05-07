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
<h2>��ǰ �� ����</h2>
	
	<c:if test="${param.R=='OK' }">
		<script type="text/javascript">
			alert("��ǰ ������ �����ƽ��ϴ�.");
		</script>
	</c:if>
	<c:if test="${param.R=='NOK' }">
		<script type="text/javascript">
			alert("��ǰ ���� �����ϴ� �� �����߽��ϴ�.");
		</script>
	</c:if>
<form action="updateItem.do" method="post" onSubmit="return check(this)">
	<input type="hidden" name="ID" value="${ITEM.id }"/>
<table>
	<tr><th>��ǰ ��ȣ</th><td><input type="text" name="ID" value="${ITEM.id }" readOnly="readonly"/></td></tr>
	<tr><th>��ǰ �̸�</th>
		<td>
			<c:if test="${sessionScope.MANAGER != null }">
				<input type="text" name="NAME" value="${ITEM.name }"/>
			</c:if>
			<c:if test="${sessionScope.MANAGER == null }">
				${ITEM.name }
			</c:if>
		</td></tr>
	<tr><th>��ǰ ����</th>
		<td>
			<c:if test="${sessionScope.MANAGER != null }">
				<input type="text" name="PRIC" value="${ITEM.pric }"/>
			</c:if>
			<c:if test="${sessionScope.MANAGER == null }">
				${ITEM.pric }
			</c:if>
		</td></tr>
	<tr><th>������</th><td><input type="text" name="ORIG" value="${ITEM.orig }" readOnly="readonly"/></td></tr>
	<tr><th>�� ��</th>
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
			<input type="submit" value="�� ��"/>
			<input type="reset" value="�� ��"/></td></tr>
	</c:if>
</table>
</form>
</div>
<script type="text/javascript">
function check(f) {
	if(f.NAME.value==''){
		alert("��ǰ �̸��� �Է����ּ���.");
		return false;
	}
	if(f.NAME.value.length>20){
		alert("��ǰ �̸��� 20�� �̳��� �Է����ּ���.");
		return false;
	}
	if(isNaN(f.PRIC.value)) {
		alert("��ǰ ������ ���ڷ� �Է����ּ���.");
		return false;
	}
	if(f.PRIC.value<0){
		alert("��ǰ ������ 0���� Ŀ�� �մϴ�.");
		return false;
	}
	
	if(!confirm("������ �����Ͻðڽ��ϱ�?")){
		return false;
	}
}
</script>
</body>
</html>