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
<header>
	<h2>�Խ��� �۾���</h2>
</header>
<section>
	<form action="bbsPost.do" method="post" onSubmit="return check(this)">
	�� �� : <input type="text" name="TITLE" placeHolder="������ �Է��ϼ���"
					size="20"/><br/>
	�� �� : <br/>
	<textarea rows="5" cols="40" name="CONTENT"></textarea>
	<br/>
	<input type="submit" value="�� �ø���"/>
	<input type="reset" value="�� ��"/>
	</form>
</section>
</div>
<script type="text/javascript">
function check(f) {
	if(f.TITLE.value==''){
		alert("������ �Է��ϼ���."); return false;
	}
	else {
		if(f.TITLE.value.length>30){
			alert("������ 30�� �̳��� �ۼ��ϼ���."); return false;
		}
	}
	if(f.CONTENT.value==''){
		alert("������ �Է��ϼ���."); return false;
	}else {
		if(f.CONTENT.value.length>100) {
			alert("������ 100�� �̳��� �ۼ��ϼ���."); return false;
		}
	}
	if(!confirm("������ ���� �ø��ðڽ��ϱ�?")){
		return false;
	}
}
</script>
</body>
</html>