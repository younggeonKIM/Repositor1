<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.btn {width : 100px; height: 50px; padding: 10px; font-size: 20px; 
		color: red;}
h2 {border : 1px solid blue; padding:10px; background-color:lightgreen;}

</style>
</head>
<body>
<script type="text/javascript">
function check() {
	if(document.frm.Coun.selectedIndex==0) {
		alert("������ �������ּ���.");
		return false;
	}
	var c=confirm("�����Ͻ� �� �³���?");
	if (! c) return false;
}
</script>
<div align="center">
<h2>�ø��� �޴� Ȯ�� APP</h2>
<form action="medalServlet.do" onSubmit="return check()" name="frm">
�� �� �� �� : <select name="Coun">
				<option>--�޴� Ȯ���� ������ �����ϼ���--</option>
				<option value="1">���ѹα�</option>
				<option value="2">�Ϻ�</option>
				<option value="3">�߱�</option>
			</select><br/><br/>
	<input type="submit" value="���� �Ϸ�" class="btn"/>
	<input type="reset" value="�� ��" class="btn"/>
</form>
</div>
</body>
</html>