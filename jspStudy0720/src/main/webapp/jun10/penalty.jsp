<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function doIt() {
	alert ("������ �����մϴ�.");
}
</script>
<div align="center">
<h2>�º����� ���ӿ� ���� ���� ȯ���մϴ�~</h2>
<p>ű�� ������ �����ϰ� ��ư�� ��������.
<form action="penaltyProcess.jsp" onSubmit="doIt()">
��<input type="radio" name="DIR" value="1"/>
��<input type="radio" name="DIR" value="2"/>
��<input type="radio" name="DIR" value="3"/>
��<input type="radio" name="DIR" value="4"/>
��<input type="radio" name="DIR" value="5"/><br/><br/>
<input type="submit" value="�� �ϱ�"/>
<input type="reset" value="�� ��"/>
</form>
</div>
</body>
</html>