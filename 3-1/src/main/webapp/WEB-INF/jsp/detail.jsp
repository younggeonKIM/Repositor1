<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/3-1.css">
</head>
<body>
<div align="center" class="body">
	<table>
		<tr><td><img alt="" src="img/${item.pictureUrl }"></td>
			<td align="center">
				<table>
					<tr height="50"><td width="80">상품명</td>
									<td width="160">${item.itemName }</td></tr>
					<tr height="50"><td width="80">가 격</td>
									<td width="160">${item.price }</td></tr>
					<tr height="50"><td width="80">설 명</td>
									<td width="160">${item.info }</td></tr>
				</table>
			</td>
	</table>
</div>
</body>
</html>