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
<h2>������ �󼼺���</h2>
	<table>
		<tr><th>�۹�ȣ</th><td>${NOTICE.seqno }</td></tr>
		<tr><th>�ۼ���</th><td>${NOTICE.id }</td></tr>
		<tr><th>�� ��</th><td>${NOTICE.title }</td></tr>
		<tr><th>�ۼ���</th><td>${NOTICE.date }</td></tr>
		<tr><th>�� ��</th><td>
		<textarea rows="5" cols="30">${NOTICE.content }</textarea>
			</td></tr>
	</table>
</div>
</body>
</html>