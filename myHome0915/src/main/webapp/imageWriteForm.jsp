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
<h2>�̹��� �Խñ� �ۼ�</h2>
<form action="" method="post" onSubmit="return check(this)" 
				encType="multipart/form-data">
	<table>
		<tr><th>�� ��</th><td><input type="text" name="TITLE"/></td></tr>
		<tr><th>�� ȣ</th><td><input type="password" name="PWD"/></td></tr>
		<tr><th>�̹���</th><td><input type="file" name="IMAGENAME"/></td></tr>
		<tr><th>�� ����</th><td>
			<textarea rows="8" cols="40" name="CONTENT">
			</textarea></td></tr>
		<tr><td colspan="2"	 align="center">
			<input type="submit" value="�� �ø���"/>
			<input type="reset" value="�� ��"/></td></tr>
	</table>
</form>
</div>
<script type="text/javascript">
function check(f) {
	if(f.TITLE.value==''){
		alert("�� ������ �Է��ϼ���."); return false;
	}else{
		if(f.TITLE.value.length>30) {
			alert("�� ������ 30�� �̳��� �ۼ��ϼ���."); return false;
		}
	}
	if(f.PWD.value=='') {
		alert("��ȣ�� �Է��ϼ���."); return false;
	}else{
		if(f.PWD.value.length>20){
			alert("��ȣ�� 20�� �̳��� �ۼ��ϼ���."); return false;
		}
	}
	if(f.IMAGENAME.value==''){
		alert("�̹��� ������ �����ϼ���."); return false;
	}
	if(f.CONTENT.value==''){
		alert("�� ������ �Է��ϼ���."); return false;
	}else {
		if(f.CONTENT.value.length>100) {
			alert("�� ������ 100�� �̳��� �ۼ��ϼ���."); return false;
		}
	}
	if( ! confirm("������ �ø��ðڽ��ϱ�?")){
		return false;
	}
}
</script>
</body>
</html>