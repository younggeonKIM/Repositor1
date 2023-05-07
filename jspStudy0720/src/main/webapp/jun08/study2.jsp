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
<h2>게시글 작성</h2>
<form action="study2_1.jsp" method="post">
작성자 : <input type="text" name="WRITER"/><br/>
내용 : <br/>
<textarea rows="5" cols="40" name="CONTENT"></textarea>
<br/><br/>
<input type="submit" value="글 올리기"/>
<input type="reset" value="취 소"/>
</form>
</div>
</body>
</html>