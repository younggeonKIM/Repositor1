<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
div {border:1px solid blue;}
h2 {border:1px solid blue; padding:5px; margin-left:50px; margin-right:50px;
	background-color:lightgreen; }
form, select {font-size:20px;}
.btn {width:120px; height:40px; font-size:16px;}

</style>
</head>
<body>
<script type="text/javascript">
function check() {
	if (document.frm.GENRE.selectedIndex==0) {
		alert ("��ȭ�� �帣�� ������ �ּ���.");
		return false;
	}
	var c=confirm("�����Ͻ� �帣�� �³���?");
	if (! c) {return false;}
}
</script>
<div align="center">
<h2>��ȭ ��õ APP ver1.0</h2>
<h3>���Ͻô� �帣�� �����ϰ�, ��ư�� ��������.</h3>
<form action="findCinema.do" onSubmit="return check()" name="frm">
�帣 ���� : <select name="GENRE">
				<option>--�����ϼ���--</option>
				<option value="1">�� ��</option>
				<option value="2">�� ��</option>
				<option value="3">�ڹ̵�</option>
				<option value="4">������</option>
				<option value="5">���</option>
			</select><br/><br/>
<input type="submit" value="��õ��ȭ ����" class="btn"/>
<input type="reset" value="�� ��" class="btn"/><br/><br/>
</form>
</div>
</body>
</html>