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
<h2>������ ���</h2>
<form action="register" method="post" name="frm" 
	onSubmit="return check(this)">
�� �� : <input type="text" name="NAME"/><br/>
�� �� : <input type="text" name="ID"/>
<input type="button" value="�ߺ��˻�" onClick="idCheck()"/><br/>
�� �� : <input type="text" name="ADDR"/><br/>
����ó : <input type="text" name="TEL"/><br/>
�� ȣ : <input type="password" name="PWD"/><br/>
��ȣ Ȯ�� : <input type="password" name="CFM"/><br/>
�� �� : ��<input type="radio" name="GENDER" value="M"/>, 
	��<input type="radio" name="GENDER" value="F"/><br/>
�̸��� : <input type="text" name="EMAIL"/><br/>
�� �� : <select name="JOB">
	<option>--�����ϼ���--</option><option>ȸ���</option><option>�л�</option>
	<option>��Ÿ</option>
		</select><br/><br/>
<input type="submit" value="�� ��"/>
<input type="reset" value="�� ��"/>
</form>
</div>
<script type="text/javascript">
function check(f) {
	if(f.NAME.value=='') {
		alert("�̸��� �Է��ϼ���."); return false;
	}
	if(f.ID.value=='') {
		alert("������ �Է��ϼ���."); return false;
	}
	if(f.ADDR.value=='') {
		alert("�ּҸ� �Է��ϼ���."); return false;
	}
	if(f.TEL.value=='') {
		alert("����ó�� �Է��ϼ���."); return false;
	}
	if(f.PWD.value=='') {
		alert("��ȣ�� �Է��ϼ���."); return false;
	}
	if(f.PWD.value != f.CFM.value) {
		alert("��ȣ�� ��ġ���� �ʽ��ϴ�."); return false;
	}
	if( ! f.GENDER[0].checked && ! f.GENDER[1].checked) {
		alert("������ �Է��ϼ���."); return false;
	}
	if(f.JOB.selectedIndex < 1) {
		alert("������ �����ϼ���."); return false;
	}
	if (confirm("������ �����Ͻðڽ��ϱ�?")) {
		return true;
	} else {
		return false;
	}
}
</script>
</body>
</html>