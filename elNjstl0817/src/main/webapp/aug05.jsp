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
<h2>��Ģ���� APP ver1.0</h2>
<form action="calculate.do">
ù��° ���� �Է��ϼ���. <input type="text" name="N1"/><br/>
�ι�° ���� �Է��ϼ���. <input type="text" name="N2"/><br/>
<br/>
<input type="submit" value="�������1" name="btn"/>
<input type="submit" value="�������1_1" name="btn"/>
<input type="button" value="�������2" onClick="doIt()"/>
<input type="reset" value="�� ��"/>
</form>
</div>
<form name="frm">

</form>
<script type="text/javascript">
function doIt() {
	document.frm.action="calc.do";
	document.frm.submit();
}
</script>
</body>
</html>