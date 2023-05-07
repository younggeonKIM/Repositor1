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
<h2>공지글 상세보기</h2>
	<table>
		<tr><th>글번호</th><td>${NOTICE.seqno }</td></tr>
		<tr><th>작성자</th><td>${NOTICE.id }</td></tr>
		<tr><th>제 목</th><td>${NOTICE.title }</td></tr>
		<tr><th>작성일</th><td>${NOTICE.date }</td></tr>
		<tr><th>내 용</th><td>
		<textarea rows="5" cols="30">${NOTICE.content }</textarea>
			</td></tr>
	</table>
</div>
</body>
</html>