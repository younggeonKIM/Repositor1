<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>�������� ����</h2>
<form action="noticeInput.do" method="post" onSubmit="return check(this)">
	<table>
		<tr><th>�� ��</th>
			<td><input type="text" name="TITLE"/></td></tr>
		<tr><th>�� ��</th>
			<td><textarea rows="6" cols="40" name="CONTENT"></textarea>
			</td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="�� �ø���"/>
			<input type="reset" value="�� ��"/></td></tr>
	</table>
</form>
</div>
<script type="text/javascript">
function check(f) {
	if(f.TITLE.value==''){
		alert("������ �Է��ϼ���."); return false;
	}else {
		if(f.TITLE.value.length>30){
			alert("������ �ʹ� ��ϴ�."); return false;
		}
	}
	if(f.CONTENT.value==''){
		alert("������ �Է��ϼ���."); return false;
	}else {
		if(f.CONTENT.value.length>100) {
			alert("������ �ʹ� ��ϴ�."); return false;
		}
	}
	if (! confirm("������ �ۼ��Ͻðڽ��ϱ�?")) {return false;}
}
</script>
</body>
</html>