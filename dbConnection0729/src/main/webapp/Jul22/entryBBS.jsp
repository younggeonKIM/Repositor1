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
<h2>�Խñ� �ۼ� �� ����</h2>
<form action="registerBBS" method="post"
		>
�ۼ��� : <input type="text" name="ID" size="10"/><br/>
�� �� : <input type="text" name="TITLE" size="20"/><br/>
�� �� : <textarea rows="5" cols="30" name="CONTENT"></textarea>
<br/><br/>
<input type="submit" value="�� ��" name="btn"/>
<input type="submit" value="�� ��" name="btn"/>
<input type="submit" value="�� ��" name="btn"/>
<input type="submit" value="�� ȸ" name="btn"/>
<input type="reset" value="�� ��"/>
</form>
</div>
<script type="text/javascript">
function check(f) {
	if(f.ID.value== '') {
		alert("�ۼ��ڸ� �Է��ϼ���."); return false;
	}
	if(f.TITLE.value== '') {
		alert("������ �Է��ϼ���."); return false;
	}
	if(f.CONTENT.value=='') {
		alert("������ �Է��ϼ���."); return false;
	}
	if(confirm("�۾��� �����Ͻðڽ��ϱ�?")) {
		return true;
	} else {
		return false;
	}
}
</script>
</body>
</html>